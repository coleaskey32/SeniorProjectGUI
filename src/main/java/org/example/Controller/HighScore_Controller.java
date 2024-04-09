package org.example.Controller;

import org.example.Model.Player;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Map;

public class HighScore_Controller {

    private String selectedGame;
    private boolean speedMode;
    private Player[] players;

    private float averageScore;
    private int[] scoreList;
    private int rounds;


    public HighScore_Controller(String selectedGame, boolean speedMode, int rounds, Player[] players) {
        this.selectedGame = selectedGame;
        this.speedMode = speedMode;
        this.players = players;
        this.rounds = rounds;

        initializer();
    }


    public void initializer() {

        ArrayList<Integer> currentPlayerScores = new ArrayList<>();
        ArrayList<String> currentPlayerNames = new ArrayList<>();
        ArrayList<Integer> leaderBoardScores = new ArrayList<>();
        ArrayList<String> leaderBoardNames = new ArrayList<>();

        ArrayList<Map.Entry<Integer, String>> highScores = new ArrayList<>();

        for (Player player: this.players) {
            currentPlayerNames.add(player.getPlayerName());
            currentPlayerScores.add(player.getCurrentScore());
        }

        try {


            //Shoot and Score 5 rounds at [0]
            //if (selectedGame.equals("Game 1") & rounds == 5) {}

        }
        catch (Exception e) {
            e.printStackTrace();
        }




    }
    public int[] scoreList() {
        return new int[]{1};
    }

}
