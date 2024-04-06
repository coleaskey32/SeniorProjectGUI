package org.example.View;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button; // Import Button class
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox; // Import VBox layout
import javafx.stage.Stage;

import org.example.Model.Game_Model;

public class Game1_View {

    private Game_Model game;

    public Game1_View(Stage primaryStage, Game_Model game) {

        this.game = game;

        // Create an ImageView with the image
        Image image = new Image("SoccerGoalPost.jpg");
        ImageView imageView = new ImageView(image);

        // Set the size of the image view
        imageView.setFitWidth(400); // Set width to 400 pixels
        imageView.setFitHeight(400); // Set height to 400 pixels

        // Create a label
        Label startLabel = new Label("Game starting...");

        // Create a StackPane to hold the label and image
        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(imageView, startLabel); // Add both image and label to the stackPane

        // Center the ImageView within the StackPane
        StackPane.setAlignment(imageView, Pos.CENTER);

        // Create a VBox layout for vertical arrangement
        VBox vbox = new VBox();
        vbox.getChildren().addAll(stackPane); // Add StackPane to VBox

        // Create a button
        Button highScoreButton = new Button("View High Scores");
        highScoreButton.setOnAction(e -> {
            // Create a new instance of HighScore_View
            HighScore_View highScoreView = new HighScore_View(primaryStage);
        });

        // Add button to VBox
        vbox.getChildren().add(highScoreButton);

        // Set alignment of the VBox to bottom center
        vbox.setAlignment(Pos.BOTTOM_CENTER);

        // Set the VBox as the root of the scene
        Scene scene = new Scene(vbox, 800, 800);

        // Set the scene on the primary stage
        primaryStage.setScene(scene);

        // Show the primary stage
        primaryStage.show();
    }
}
