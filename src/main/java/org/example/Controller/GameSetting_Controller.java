package org.example.Controller;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.View.Game_View;

public class GameSetting_Controller {

    private static final int MIN_PLAYERS = 1;
    private static final int MAX_PLAYERS = 4;

    private int totalPlayers = 1;
    private int rounds = 5;
    private boolean speedMode = false;

    private String selectedGame = ""; // Variable to keep track of the selected game

    public GameSetting_Controller() {
        // Initialize any necessary data or dependencies
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
        new Game_View(primaryStage);
    }

    private void updatePlayerCircles() {
        // Implement updating player circles if needed
    }

    private void openGame1Window() {
        // Implement opening Game 1 window
    }

    private void openGame2Window() {
        // Implement opening Game 2 window
    }
}
