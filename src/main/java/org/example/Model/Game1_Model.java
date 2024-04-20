package org.example.Model;

import javafx.stage.Stage;
import org.example.Controller.GameSetting_Controller;
import org.example.View.Game1_View;

public class Game1_Model extends Game_Model {

    // Assuming currentPlayer is the index of the current player in the players array
    int scoreToAdd = 0; // Default score

    int multiplier = 0;


    public Game1_Model(int totalPlayers, String selectedGame, boolean speedMode, int rounds, Stage primaryStage) {
        super(totalPlayers, selectedGame, speedMode, rounds, primaryStage);

        initializePlayers();
    }

    public boolean getSpeedMode(boolean speedMode) {
        return this.speedMode = speedMode;

    }

    public int getMultiplier() {

        if (getBallSpeed() > 0 && getBallSpeed() < 30) {
            multiplier = 1;
        } else if (getBallSpeed() > 30 && getBallSpeed() < 40) {
            multiplier = 2;
        } else if (getBallSpeed() > 40) {
            multiplier = 3;
        }

        return multiplier;
    }

    public int setMultiplier(int multiplier) {
        return this.multiplier = multiplier;
    }

    @Override
    public int pointsGiven() {
        // Assume this is the position obtained somehow
        String coordinateString = coordinates[0] + "," + coordinates[1];

        switch (coordinateString) {
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

        if(getSpeedMode(speedMode))
        {

            System.out.println("speed:" + getBallSpeed() + "mult:" + getMultiplier() + "score" +  scoreToAdd + "multiplied" + getMultiplier()*scoreToAdd);

            return getMultiplier() * scoreToAdd;

        }
        else{
            System.out.println("reg" + scoreToAdd);
            return scoreToAdd;
        }

    }
    @Override
    public int[] generateRandomCoordinates() {
        return new int[0];
    }
}