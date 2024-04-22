package org.example.Model;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import org.example.Controller.HighScore_Controller;
import org.example.View.HighScore_View;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public abstract class Game_Model {
    protected Player[] players;
    protected String selectedGame;
    protected int totalPlayers;
    protected int rounds;
    protected boolean speedMode;
    protected Stage primaryStage;
    protected int totalRounds;
    protected int currentPlayer = 1;

    protected double ballSpeed; // Ball speed applicable across different game models

    protected int[] coordinates;

    protected int[] randomSpeedInterval;



    public Game_Model(int totalPlayers, String selectedGame, boolean speedMode, int rounds, Stage primaryStage) {
        this.selectedGame = selectedGame;
        this.totalPlayers = totalPlayers;
        this.speedMode = speedMode;
        this.rounds = rounds;
        this.totalRounds = rounds;
        this.players = new Player[totalPlayers];
        this.primaryStage = primaryStage;

        initializePlayers();
    }



    /** Sets the grid view depending on the game. random box for simon says and point layout for shoot and score.
     *  Will be implemented in Game1_Model and Game2_Model
     **/


    /** Depending on the game will give certain amount of points to the player
     *  Will be implemented in Game1_Model and Game2_Model
     **/
    public abstract int pointsGiven();
    public abstract int[] generateRandomCoordinates();

    /**
     * Retrieves coordinates from standard input (stdin) and processes them.
     * Assumes input in the format of a 6x4 grid of coordinates.
     * Each line of input is expected to contain a set of coordinates.
     * Coordinates are accumulated into a StringBuilder.
     **/
    public void retrieveCoordinate() {
        int[] coordinateAndSpeed = new int[3];

        /*
        try {
            // Execute the C++ program
            ProcessBuilder processBuilder = new ProcessBuilder("C:\\Users\\colea\\OneDrive - The Pennsylvania State University\\Desktop\\Main.exe");
            processBuilder.directory(new File("C:\\Users\\colea\\OneDrive - The Pennsylvania State University\\Desktop"));

            // Start the process
            Process process = processBuilder.start();

            // Read the output from the C++ program
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;

            // Read each line of output and parse the values
            int index = 0;
            while ((line = reader.readLine()) != null && index < 3) {
                coordinateAndSpeed[index] = Integer.parseInt(line.trim()); // Parse the value and store it
                index++;
            }

            // Wait for the process to finish
            int exitCode = process.waitFor();
            if (exitCode != 0) {
                System.err.println("Error: Process exited with non-zero status " + exitCode);
            }

        } catch (IOException | InterruptedException | NumberFormatException e) {
            e.printStackTrace();
        }

        // Print the coordinate and speed values
        System.out.println("Coordinate: " + coordinateAndSpeed[0] + ", " + coordinateAndSpeed[1]);
        System.out.println("Speed: " + coordinateAndSpeed[2]);

        // Assign values to instance variables
        this.ballSpeed = coordinateAndSpeed[2];
        this.coordinates = new int[]{coordinateAndSpeed[0], coordinateAndSpeed[1]};
        */
        // Sleep for 3 seconds
        try {
            Thread.sleep(3000); // 3000 milliseconds = 3 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Random random = new Random();
        int x;
        int y;
        if (selectedGame.equals("Game 1")) {
            x = random.nextInt(3);
            y = random.nextInt(6);
        }
        else {
            x = random.nextInt(3);
            y = random.nextInt(3);
        }
        this.coordinates = new int[]{x, y};
        this.ballSpeed = random.nextInt(71);

        // Sleep for 3 seconds
        try {
            Thread.sleep(3000); // 3000 milliseconds = 3 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }



    public Player[] getPlayers() {
        return players;
    }

    /** Creates the amount of player objects asked in game setting **/
    void initializePlayers() {
        for (int i = 0; i < totalPlayers; i++) {
            players[i] = new Player("Player " + (i + 1));

        }
    }

    public void generateRandomSpeedRange() {
        Random random = new Random();
        int lowerBound = random.nextInt(35);
        int higherBound = lowerBound + 10;
        this.randomSpeedInterval = new int[]{lowerBound, higherBound};
    }

    public int[] getRandomSpeedInterval() { return randomSpeedInterval; }

    public int[] getCoordinates() { return this.coordinates; }

    public void incrementPlayer() {
        this.currentPlayer++;
    }

    public void setCurrentPlayer(int currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public void decrementRounds() { rounds--; }

    public int getPlayerLives() { return this.players[currentPlayer - 1].getLives(); }

    public int getCurrentRound() { return rounds; }

    public String getPlayerName() { return "Player " + (this.currentPlayer); }

    public int getCurrentPlayerNum() { return this.currentPlayer; }

    public void openHighScoreWindow() { new HighScore_View(primaryStage, selectedGame, speedMode, totalRounds, players); }

    public Player getCurrentPlayer() {
        // Ensure this does not go out of bounds; adjust logic as necessary for your application's flow
        return players[currentPlayer - 1]; // Assuming currentPlayer is 1-based index; adjust if 0-based
    }

    public double getBallSpeed() { return ballSpeed; }

    public int getPlayerScore() {
        System.out.println("Players Total Score: " + players[currentPlayer - 1].getCurrentScore());
        return players[currentPlayer - 1].getCurrentScore();
    }

    public void addToPlayerScore(int points) {
        this.players[currentPlayer - 1].addToTotalScore(points);
    }

    public abstract int getMultiplier();
}