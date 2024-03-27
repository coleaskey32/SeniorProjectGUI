package org.example.Controller;

import javafx.stage.Stage;

public class Home_Controller {

    private String selectedGame;

    public Home_Controller() {
        // Initialize any necessary data or dependencies
    }

    public void openSettingsWindow(Stage primaryStage) {
        // Close the current window
        primaryStage.close();

        // Open the GameSetting_View window
        new GameSetting_View(new Stage());
    }

    public void setSelectedGame(String gameNumber, String gameName) {
        selectedGame = gameNumber;
        System.out.println("Selected Game: " + selectedGame + ", Name: " + gameName);
    }
}