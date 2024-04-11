package org.example.Model;

import javafx.stage.Stage;

import java.lang.Math;


public class Game2_Model extends Game_Model {
    private int totalPlayers;
    private boolean speedMode;
    private Stage primaryStage;

    double ballSpeed = 0;

    // Constructor to initialize totalPlayers and speedMode
    public Game2_Model(int totalPlayers, String selectedGame, boolean speedMode, int rounds, Stage primaryStage) {
        super(totalPlayers, selectedGame, speedMode, rounds, primaryStage);

        initializePlayers();

    }


    @Override
    public int[] setGrid() {
        int randomColumn = (int)(Math.random() * 3);
        int randomRow = (int)(Math.random() * 3);

        return new int[]{randomRow, randomColumn};
    }

    @Override
    public void pointsGiven() {
        //needs a get position from main.cpp
        String ballposition = "0,0";


            //if position != randomRow + "," + randomColumn
            //decrementLives


        }

    @Override
    public double calculateBallSpeed(double ballSpeed) {
        setBallSpeed(ballSpeed);
        // Logic to calculate the ball speed for Game 1
        // For example, this could be a random speed, a speed based on game level, etc.
        this.ballSpeed = ballSpeed/* some calculation */;
        return  ballSpeed;
    }

    public void setPosition(String position) {

        this.ballPosition = position; // Directly set if you're using a string

    }

}
