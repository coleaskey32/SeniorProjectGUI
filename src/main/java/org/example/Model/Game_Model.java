package org.example.Model;

import javafx.stage.Stage;

import org.example.Controller.HighScore_Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class Game_Model {
    protected Player[] players;
    protected String selectedGame;
    protected int totalPlayers;
    protected int rounds;
    protected boolean speedMode;

    public Game_Model(int totalPlayers, String selectedGame, boolean speedMode, int rounds) {
        this.selectedGame = selectedGame;
        this.totalPlayers = totalPlayers;
        this.speedMode = speedMode;
        this.rounds = rounds;
        this.players = new Player[totalPlayers];

        initializePlayers();
    }

    /** Not Sure if we need this method yet **/
    public abstract void start();

    /** Sets the grid view depending on the game. random box for simon says and point layout for shoot and score.
     *  Will be implemented in Game1_Model and Game2_Model
     **/
    public abstract void setGrid();


    /** Depending on the game will give certain amount of points to the player
     *  Will be implemented in Game1_Model and Game2_Model
     **/
    public abstract void pointsGiven();

    /**
     * Retrieves coordinates from standard input (stdin) and processes them.
     * Assumes input in the format of a 6x4 grid of coordinates.
     * Each line of input is expected to contain a set of coordinates.
     * Coordinates are accumulated into a StringBuilder.
     **/
    public static String retrieveCoordinates() {
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
    public void openHighScoreWindow(Stage primaryStage) {
        System.out.println("Selected Game: " + selectedGame);
        new HighScore_Controller(primaryStage, selectedGame, speedMode, players);
    }

    /** Creates the amount of player objects asked in game setting **/
    void initializePlayers() {
        for (int i = 0; i < totalPlayers; i++) {
            players[i] = new Player("Player " + (i + 1));
        }
    }

    public int getRounds() {
        return rounds;
    }

}
