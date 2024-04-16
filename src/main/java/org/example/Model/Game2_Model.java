package org.example.Model;

import javafx.stage.Stage;

import java.lang.Math;
import java.util.Random;


public class Game2_Model extends Game_Model {


    private double ballSpeed = 0;

    private int[] randomCoordinate;


    // Constructor to initialize totalPlayers and speedMode
    public Game2_Model(int totalPlayers, String selectedGame, boolean speedMode, int rounds, Stage primaryStage) {
        super(totalPlayers, selectedGame, speedMode, rounds, primaryStage);

        initializePlayers();

    }

    public int[] generateRandomCoordinates() {
        Random random = new Random();
        this.randomCoordinate = new int[]{random.nextInt(3), random.nextInt(6)};
        return this.randomCoordinate;
    }


    @Override
    public int pointsGiven() {
        if(!(this.coordinates == randomCoordinate)) {
            currentLives = decrementPlayerLives();
            return 0;
        }

        return 1;
    }



}
