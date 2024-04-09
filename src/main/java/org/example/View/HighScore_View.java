package org.example.View;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HighScore_View {
    public HighScore_View(Stage primaryStage) {


        VBox back = new VBox(20); // Create a vertical layout
        // Here, you would add components to 'layout' that make up your high score screen.
        // For example, labels showing high scores, maybe loaded from your Game_Model or another source.

        // Optionally, add a back button to return to the previous view
        Button backButton = new Button("Game Select");
        backButton.setOnAction(e -> {


        });
        back.getChildren().add(backButton);
        back.setAlignment(Pos.BOTTOM_CENTER);


        Scene highScoreScene = new Scene(back, 1200, 900); // Adjust size as needed
        primaryStage.setScene(highScoreScene); // Set the new scene on the primary stage
        primaryStage.setTitle("High Score");

    }
}