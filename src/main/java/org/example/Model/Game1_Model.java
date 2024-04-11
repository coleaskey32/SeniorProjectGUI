package org.example.Model;

import javafx.stage.Stage;
import org.example.View.Game1_View;

public class Game1_Model extends Game_Model {
    private int totalPlayers;
    private boolean speedMode;

    String ballposition = "0,0";
    double ballspeed = 25;

    // Assuming currentPlayer is the index of the current player in the players array
    int scoreToAdd = 0; // Default score

    int multiplier = 1;
    private Stage primaryStage;
    // Constructor to initialize totalPlayers and speedMode
    public Game1_Model(int totalPlayers, String selectedGame, boolean speedMode, int rounds, Stage primaryStage) {
        super(totalPlayers, selectedGame, speedMode, rounds, primaryStage);

        initializePlayers();

    }


    public int getMultiplier() {
        return multiplier;
    }

    public int setMultiplier() {
        return this.multiplier = multiplier;
    }

    public int updateMultiplier(int ballSpeed) {

        if (ballspeed > 0 && ballspeed < 20) {
            multiplier = 1;
        } else if (ballspeed > 20 && ballspeed < 30) {
            multiplier = 2;
        } else if (ballspeed > 30) {
            multiplier = 3;
        }

        return multiplier;
    }

    @Override
    public int[] setGrid() {
        return new int[]{1, 2, 3, 4, 5};
    }

    @Override
    public void pointsGiven() {
        // Assume this is the position obtained somehow

        switch (ballposition) {
            case "0,0":
            case "0,5":
            case "2,0":
            case "2,5":
                scoreToAdd = 5;
                break;
            case "0,1":
            case "0,4":
            case "1,0":
            case "1,5":
            case "2,1":
            case "2,4":
                scoreToAdd = 4;
                break;
            case "1,1":
            case "1,4":
            case "0,2":
            case "0,3":
                scoreToAdd = 3;
                break;
            case "1,2":
            case "1,3":
                scoreToAdd = 2;
                break;
            case "2,2":
            case "2,3":
                scoreToAdd = 1;
                break;

            // Add default case if necessary
        }

        // Assuming currentPlayer - 1 gives the correct index for the player in the players array
        if(speedMode)
        {
            players[currentPlayer - 1].setCurrentScore((multiplier * scoreToAdd));
        }
        else{
            players[currentPlayer - 1].setCurrentScore(scoreToAdd);
        }

        //updateScoreDisplays();
    }

}
