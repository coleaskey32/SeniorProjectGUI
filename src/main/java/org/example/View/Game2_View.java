package org.example.View;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;

import org.example.Model.Game_Model;

public class Game2_View {

    private Game_Model game;

    public Game2_View(Stage primaryStage, Game_Model game) {
        this.game = game;

        // Create an ImageView with the image
        Image image = new Image("SoccerGoalPost.jpg");

        // Get the screen dimensions
        double screenWidth = Screen.getPrimary().getBounds().getWidth();
        double screenHeight = Screen.getPrimary().getBounds().getHeight();

        // Calculate the desired width and height as a percentage of the screen size
        double widthPercentage = 0.75; // 50% of screen width
        double heightPercentage = 0.75; // 50% of screen height
        double imageViewWidth = screenWidth * widthPercentage;
        double imageViewHeight = screenHeight * heightPercentage;

        ImageView imageView = new ImageView(image);

        // Set the size of the image view
        imageView.setFitWidth(imageViewWidth);
        imageView.setFitHeight(imageViewHeight);

        // Create a GridPane
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10); // Horizontal gap between grid elements
        gridPane.setVgap(10); // Vertical gap between grid elements

        // Add grid elements to the GridPane and set their initial color
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 6; col++) {
                // Create a StackPane for each grid element
                StackPane gridElement = new StackPane();
                gridElement.setStyle("-fx-background-color: red;"); // Initial color

                // Add the grid element to the GridPane
                gridPane.add(gridElement, col, row);
            }
        }

        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(imageView, gridPane); // Add both image and label to the stackPane

        // Center the ImageView within the StackPane
        StackPane.setAlignment(gridPane, Pos.CENTER);
        // Set white background color for the StackPane
        stackPane.setStyle("-fx-background-color: white;");

        // Set the StackPane as the root of the scene
        Scene scene = new Scene(stackPane, screenWidth, screenHeight);

        // Set the scene on the primary stage
        primaryStage.setScene(scene);

        // Show the primary stage
        primaryStage.show();
    }
}
