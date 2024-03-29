package org.example.Controller;

import javafx.stage.Stage;

public class GameSetting_Controller {

    private static final int MIN_PLAYERS = 1;
    private static final int MAX_PLAYERS = 4;

    private int totalPlayers = 1;
    private int rounds = 5;
    private boolean speedMode = false;

    private String selectedGame = ""; // Variable to keep track of the selected game

    public GameSetting_Controller(String selectedGame) {
        this.selectedGame = selectedGame;
    }

    public void addPlayer() {
        if (totalPlayers < MAX_PLAYERS) {
            totalPlayers++;
            updatePlayerCircles();
        }
    }

    public void deletePlayer() {
        if (totalPlayers > MIN_PLAYERS) {
            totalPlayers--;
            updatePlayerCircles();
        }
    }

    public void setRounds(int numRounds) {
        rounds = numRounds;
    }

    public void setSpeedMode(boolean mode) {
        speedMode = mode;
    }


    public void openGameWindow(Stage primaryStage) {
        System.out.println("Selected Game: " + selectedGame);
        new Game_Controller(primaryStage, selectedGame, totalPlayers, speedMode);
    }

    private void updatePlayerCircles() {
        // Implement updating player circles if needed
    }


}
