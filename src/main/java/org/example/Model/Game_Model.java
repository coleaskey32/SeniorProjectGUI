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
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class Game_Model {
    protected Player[] players;
    protected String selectedGame;
    protected int totalPlayers;
    protected int rounds;
    protected boolean speedMode;
    protected Stage primaryStage;
    protected int totalRounds;
    int currentLives = 3;
    protected int currentPlayer = 1;

    protected double ballSpeed; // Ball speed applicable across different game models

    protected String ballPosition = "0,0"; // Default position as a string




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
    public abstract int[] setGrid();


    /** Depending on the game will give certain amount of points to the player
     *  Will be implemented in Game1_Model and Game2_Model
     **/
    public abstract int pointsGiven();

    /**
     * Retrieves coordinates from standard input (stdin) and processes them.
     * Assumes input in the format of a 6x4 grid of coordinates.
     * Each line of input is expected to contain a set of coordinates.
     * Coordinates are accumulated into a StringBuilder.
     **/
    public String retrieveCoordinates() {
        StringBuilder contentBuilder = new StringBuilder();
        try {
            // Execute the C++ program
            Process process = new ProcessBuilder("./coordinates_generator").start();

            // Read the output from the C++ program
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                contentBuilder.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contentBuilder.toString().trim(); // Return coordinates as a formatted string
    }

    /** Opens the High Score Screen **/
    public Player[] getPlayers() {
        return players;
    }

    /** Creates the amount of player objects asked in game setting **/
    void initializePlayers() {
        for (int i = 0; i < totalPlayers; i++) {
            players[i] = new Player("Player " + (i + 1));

        }
    }

    public int getTotalPlayers() {
        return totalPlayers;
    }

    public void incrementPlayer(int currentPlayer) {
        this.currentPlayer = currentPlayer++;
    }

    public void setCurrentPlayer(int currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public int decrementRounds() {
        return --rounds;
    }

    public int decrementPlayerLives() {
        return --currentLives;
    }

    public int getCurrentLives() {
        return currentLives;
    }

    public int getCurrentRound() {
        return rounds;
    }

    public String getPlayerName() {
            return "Player " + (this.currentPlayer);
    }

    public int getCurrentPlayerVar() {
        return this.currentPlayer;
    }

    public void openHighScoreWindow() {
        new HighScore_View(primaryStage, selectedGame, speedMode, totalRounds, players);
    }

    public Player getCurrentPlayer() {
        // Ensure this does not go out of bounds; adjust logic as necessary for your application's flow
        return players[currentPlayer - 1]; // Assuming currentPlayer is 1-based index; adjust if 0-based
    }

    public double getBallSpeed() {
        return ballSpeed;
    }

    public void setBallSpeed(double ballSpeed) {
        this.ballSpeed = ballSpeed;
    }

    // Method to calculate or update the ball speed
    public abstract double calculateBallSpeed(double ballSpeed);

    // Method to set position; to be overridden in subclasses
    public abstract void setPosition(String position);

    // Method to get the current position
    public String getBallPosition() {
        return ballPosition;
    }

}
