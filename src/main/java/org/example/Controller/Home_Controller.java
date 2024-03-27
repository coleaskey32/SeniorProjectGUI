package org.example.Controller;

import javafx.stage.Stage;
import org.example.View.GameSetting_View;


public class Home_Controller {

    private String selectedGame;

    public Home_Controller() {
        // Initialize any necessary data or dependencies
    }

    public void openGameSettingWindow(Stage primaryStage) {
        new GameSetting_View(primaryStage);
    }

    public void setSelectedGame(String gameNumber, String gameName) {
        selectedGame = gameNumber;
        System.out.println("Selected Game: " + selectedGame + ", Name: " + gameName);
    }
}