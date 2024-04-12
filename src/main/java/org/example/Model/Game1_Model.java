package org.example.Model;

import javafx.stage.Stage;
import org.example.Controller.GameSetting_Controller;
import org.example.View.Game1_View;

public class Game1_Model extends Game_Model {
    private int totalPlayers;
    private boolean speedMode;

    String ballposition = "0,0";

    // Assuming currentPlayer is the index of the current player in the players array
    int scoreToAdd = 0; // Default score

    int multiplier = 1;

    double ballSpeed = 0;
    private Stage primaryStage;
    // Constructor to initialize totalPlayers and speedMode
    public Game1_Model(int totalPlayers, String selectedGame, boolean speedMode, int rounds, Stage primaryStage) {
        super(totalPlayers, selectedGame, speedMode, rounds, primaryStage);

        initializePlayers();

    }


    public boolean getSpeedMode() {
        return speedMode;

    }

    public void setSpeedMode(boolean speedMode) {
        this.speedMode = speedMode;

    }
    public int getMultiplier() {
        return multiplier;
    }

    public int setMultiplier(int multiplier) {
        return this.multiplier = multiplier;
    }

    public int updateMultiplier() {
double currentBallSpeed = calculateBallSpeed(ballSpeed);
        if (currentBallSpeed > 0 && currentBallSpeed < 20) {
            multiplier = 1;
        } else if (currentBallSpeed > 20 && currentBallSpeed < 30) {
            multiplier = 2;
        } else if (currentBallSpeed > 30) {
            multiplier = 3;
        }
        setMultiplier(multiplier);

        return multiplier;
    }

    @Override
    public int[] setGrid() {
        return new int[]{1, 2, 3, 4, 5};
    }

    @Override
    public int pointsGiven() {
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

        boolean mode = getSpeedMode();
        multiplier = setMultiplier(multiplier);


        if(mode)
        {
            System.out.println((getMultiplier() * scoreToAdd));
            System.out.println("speedMode true");
            players[currentPlayer - 1].setCurrentScore((getMultiplier() * scoreToAdd));
            return getMultiplier() * scoreToAdd;
        }
        else{
            System.out.println((scoreToAdd));
            System.out.println("speedMode false");
            players[currentPlayer - 1].setCurrentScore(scoreToAdd);
            return scoreToAdd;
        }

    }

    @Override
    public double calculateBallSpeed(double ballSpeed) {
        setBallSpeed(ballSpeed);
        // Logic to calculate the ball speed for Game 1
        // For example, this could be a random speed, a speed based on game level, etc.
        this.ballSpeed = ballSpeed/* some calculation */;
        return  ballSpeed;
    }

    public void setBallSpeed() {
        double newSpeed = calculateBallSpeed(ballSpeed);
        super.setBallSpeed((int) newSpeed); // Updating the ballSpeed in the superclass (Game_Model)
        updateMultiplier(); // Update the multiplier based on the new speed
    }

    public void setPosition(String position) {

            this.ballposition = position; // Directly set if you're using a string

        }

}
