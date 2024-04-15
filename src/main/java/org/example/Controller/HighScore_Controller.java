package org.example.Controller;


import org.example.Model.Player;

import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.util.ArrayList;

public class HighScore_Controller {

    private String selectedGame;
    private boolean speedMode;
    private Player[] players;
    private int rounds;

    ArrayList<Integer> currentPlayerScores;
    ArrayList<String> currentPlayerNames;
    ArrayList<String> leaderBoardScores;
    ArrayList<String> leaderBoardNames;

    public HighScore_Controller(String selectedGame, boolean speedMode, int rounds, Player[] players) {
        this.selectedGame = selectedGame;
        this.speedMode = speedMode;
        this.players = players;
        this.rounds = rounds;

        initializer();
    }


    public void initializer() {

        currentPlayerScores = new ArrayList<>();
        currentPlayerNames = new ArrayList<>();
        leaderBoardScores = new ArrayList<>();
        leaderBoardNames = new ArrayList<>();

        for (Player player: this.players) {
            currentPlayerNames.add(player.getPlayerName());
            currentPlayerScores.add(player.getCurrentScore());
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
        }
        catch (Exception e) {
            e.printStackTrace();
        }
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
}
