package org.example.View;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import org.example.Model.Game_Model;

public class Game1_View {

    private Game_Model game;

    public Game1_View(Stage primaryStage, Game_Model game) {

        this.game = game;

        // Create an ImageView with the image
        Image image = new Image("SoccerGoalPost.jpg");
        ImageView imageView = new ImageView(image);

        // Create a label
        Label startLabel = new Label("Game starting...");

        // Create a StackPane to hold the label and image
        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(imageView, startLabel); // Add both image and label to the stackPane

        // Center the ImageView within the StackPane
        StackPane.setAlignment(imageView, Pos.CENTER);

        // Set the StackPane as the root of the scene
        Scene scene = new Scene(stackPane, 400, 300);

        // Set the scene on the primary stage
        primaryStage.setScene(scene);

        // Show the primary stage
        primaryStage.show();
    }
}
