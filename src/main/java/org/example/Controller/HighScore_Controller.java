package org.example.Controller;


import javafx.scene.control.TextInputDialog;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.example.Model.Player;

import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.util.ArrayList;
import java.util.Optional;

public class HighScore_Controller {

    private String selectedGame;
    private boolean speedMode;
    private Player[] players;
    private int rounds;
    private Stage primaryStage;

    ArrayList<Integer> currentPlayerScores;
    ArrayList<String> currentPlayerNames;
    ArrayList<String> leaderBoardScores;
    ArrayList<String> leaderBoardNames;

    public HighScore_Controller(String selectedGame, boolean speedMode, int rounds, Player[] players, Stage primaryStage) {
        this.selectedGame = selectedGame;
        this.speedMode = speedMode;
        this.players = players;
        this.rounds = rounds;
        this.primaryStage = primaryStage;

        initializer();
    }

    public void initializer() {

        currentPlayerScores = new ArrayList<>();
        currentPlayerNames = new ArrayList<>();
        leaderBoardScores = new ArrayList<>();
        leaderBoardNames = new ArrayList<>();

        for (Player player : this.players) {
            currentPlayerNames.add(player.getPlayerName());
            currentPlayerScores.add(player.getTotalScore());
        }

        try {

            JSONParser jsonParser = new JSONParser();
            JSONArray jsonArray = (JSONArray) jsonParser.parse(new FileReader("C://Users/colea/Downloads/SP/src/main/resources/Data.Json"));

            // Determine the index based on selectedGame and rounds
            int index = 0;
            if (selectedGame.equals("Game 1")) {
                if (rounds == 5)
                    index = 0;
                else if (rounds == 10)
                    index = 1;
                else if (rounds == 15)
                    index = 2;
            } else if (selectedGame.equals("Game 2")) {
                if (rounds == 5)
                    index = 3;
                else if (rounds == 10)
                    index = 4;
            } else {
                index = 5;
            }

            JSONObject jsonObj = (JSONObject) jsonArray.get(index);


            JSONArray entries = (JSONArray) jsonObj.get("entries");
            long average_score = (long) jsonObj.get("average_score");
            long total_entries = (long) jsonObj.get("total_entries");


            for (Object entryObj : entries) {
                JSONObject entry = (JSONObject) entryObj;
                leaderBoardNames.add(String.valueOf(entry.get("name")));
                leaderBoardScores.add(String.valueOf(entry.get("score")));
                System.out.println("Score: " + entry.get("score") + ", Name: " + entry.get("name"));
            }
            System.out.println("\n");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Check if a player will be on global leaderboard
        for (int i = 0; i < currentPlayerScores.size(); i++) {
            int currentPlayerScore = currentPlayerScores.get(i);

            for (int j = leaderBoardScores.size() - 1; j > 0; j--) {
                int leaderBoardScore = Integer.parseInt(leaderBoardScores.get(j));

                // Player made it on leaderboard
                System.out.println("CurrentPlayer Score: " + currentPlayerScore + "  LeaderBoard Score: " + leaderBoardScore);
                if (currentPlayerScore > leaderBoardScore) {
                    // Display a window to prompt the player to enter their name
                    String playerName = promptForPlayerName(primaryStage);

                    // Shift the elements down
                    for (int k = leaderBoardScores.size() - 1; k > j; k--) {
                        leaderBoardScores.set(k, leaderBoardScores.get(k - 1));
                        leaderBoardNames.set(k, leaderBoardNames.get(k - 1));
                    }

                    // Insert the new entry at index j
                    leaderBoardScores.set(j, String.valueOf(currentPlayerScore));
                    leaderBoardNames.set(j, playerName);

                    break;
                }
            }
        }

        // Update json file to have new LeaderBoard


    }

    public int[] scoreList() {
        return new int[]{1};
    }

    public String getLeaderBoardName(int i) {
        System.out.println(leaderBoardNames);
        return this.leaderBoardNames.get(i);
    }

    public String getLeaderBoardScore(int i) {
        System.out.println(leaderBoardScores);
        return this.leaderBoardScores.get(i);
    }

    public String promptForPlayerName(Stage primaryStage) {
        // Create a TextInputDialog
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Enter Your Name");
        dialog.setHeaderText("Congratulations! You've made it to the global leaderboard.");
        dialog.setContentText("Please enter your name:");

        // Show the dialog and wait for the user's response
        dialog.initOwner(primaryStage); // Set the owner stage
        dialog.initModality(Modality.WINDOW_MODAL); // Set modality to WINDOW_MODAL
        Optional<String> result = dialog.showAndWait();

        // Process the user's response
        // Return the entered name
        // Return null if the user cancels the dialog
        return result.orElse(null);
    }
}