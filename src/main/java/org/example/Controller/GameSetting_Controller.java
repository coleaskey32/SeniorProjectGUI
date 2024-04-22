package org.example.Controller;
//
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class GameSetting_Controller {

    private static final int MIN_PLAYERS = 1;
    private static final int MAX_PLAYERS = 4;

    private int totalPlayers = 1;
    private int rounds = 5;
    private boolean speedMode = false;

    private String selectedGame = ""; // Variable to keep track of the selected game

    List<Circle> playerCircles = new ArrayList<>(); // ArrayList to store Circle objects representing players
    private HBox playersHBox = new HBox(); // HBox to hold player circles

    public GameSetting_Controller(String selectedGame) {
        this.selectedGame = selectedGame;
        // Initialize or configure playersHBox as needed
        // For example, setting spacing between circles
        playersHBox.setSpacing(10); // Set spacing between elements in the HBox
    }

    public void addPlayer() {
        if (totalPlayers < MAX_PLAYERS) {
            totalPlayers++;
            updatePlayerCircles(totalPlayers, playersHBox);
        }
    }

    public void deletePlayer() {
        if (totalPlayers > MIN_PLAYERS) {
            totalPlayers--;
            updatePlayerCircles(totalPlayers, playersHBox);
        }
    }

    public void setRounds(int numRounds) {
        rounds = numRounds;
        System.out.println("Rounds Selected: " + numRounds);
    }

    public void setSpeedMode(boolean mode) {
        speedMode = mode;
        System.out.println("Speed mode setting: " + speedMode);
    }


    public void openGameWindow(Stage primaryStage) {
        System.out.println("Selected Game: " + selectedGame);
        new Game_Controller(primaryStage, selectedGame, totalPlayers, speedMode, rounds);
    }

    public void updatePlayerCircles(int totalPlayers, HBox playersHBox) {
        // Clear previous nodes
        playersHBox.getChildren().clear();

        // Base URL for random soccer ball images from Unsplash
        String baseUrl = "ball.png";

        // Create nodes for each player
        for (int i = 0; i < MAX_PLAYERS; i++) {
            Image image = new Image(baseUrl);
            ImageView imageView = new ImageView(image);
            imageView.setFitWidth(100); // Set width of image
            imageView.setFitHeight(100); // Set height of image
            imageView.setPreserveRatio(true); // Preserve aspect ratio
            imageView.setSmooth(true); // Enable smooth scaling
            imageView.setCache(true); // Cache image for performance
            imageView.setVisible(i < totalPlayers); // Show image if it represents a player
            playersHBox.getChildren().add(imageView); // Add image view to the HBox
        }
    }

    public HBox getPlayersHBox() {
        return this.playersHBox;
    }

    public int getTotalPlayers() {
        return this.totalPlayers;
    }

    public boolean getSpeedMode() {
        return speedMode;
    }


}