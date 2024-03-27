package org.example.View;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.example.Controller.Game_Controller;

public class Game_View {

    private Game_Controller controller;

    public Game_View(Stage primaryStage) {
        this.controller = new Game_Controller();

        // Create a label
        Label startLabel = new Label("Game starting...");

        // Create a StackPane to hold the label
        StackPane stackPane = new StackPane(startLabel);

        // Set the StackPane as the root of the scene
        Scene scene = new Scene(stackPane, 400, 300);

        // Set the scene on the primary stage
        primaryStage.setScene(scene);

        // Show the primary stage
        primaryStage.show();
    }
}
