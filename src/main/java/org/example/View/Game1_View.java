package org.example.View;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button; // Import Button class
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox; // Import VBox layout
import javafx.stage.Stage;

import org.example.Model.Game_Model;

public class Game1_View {

    private Game_Model game;

    public Game1_View(Stage primaryStage, Game_Model game) {

        this.game = game;


        // Label for Ball Speed
        Label speedLabel = new Label("   Ball Speed:");
        speedLabel.setStyle("-fx-font-size: 20px;"); // Increase font size

        // Total Score Label
        Label totalScoreLabel = new Label("   Total Score:    ");
        totalScoreLabel.setStyle("-fx-font-size: 20px;"); // Increase font size

        // Current Score Label
        Label currentScoreLabel = new Label("   Current Score:");
        currentScoreLabel.setStyle("-fx-font-size: 20px;"); // Increase font size


        // Text Fields
        TextField totalScoreTextField = new TextField();
        totalScoreTextField.setPrefWidth(100); // Set preferred width
        TextField currentScoreTextField = new TextField();
        currentScoreTextField.setPrefWidth(100); // Set preferred width


        // HBox for Total Score
        HBox totalScoreBox = new HBox(40); // Horizontal layout with spacing of 40
        totalScoreBox.getChildren().addAll(totalScoreLabel, totalScoreTextField);
        totalScoreBox.setAlignment(Pos.CENTER_LEFT); // Align the components to the left

        // HBox for Current Score
        HBox currentScoreBox = new HBox(40); // Horizontal layout with spacing of 40
        currentScoreBox.getChildren().addAll(currentScoreLabel, currentScoreTextField);
        currentScoreBox.setAlignment(Pos.CENTER_LEFT); // Align the components to the left

        HBox layout = new HBox(40); // Horizontal layout with spacing of 40
        layout.getChildren().addAll(totalScoreBox, currentScoreBox); // Add scoring components to the layout

        // Ball speed Label
        Label ballSpeedLabel = new Label("Ball Speed:");
        ballSpeedLabel.setStyle("-fx-font-size: 20px;"); // Increase font size

        // mph Label
        Label mphLabel = new Label("mph");
        mphLabel.setStyle("-fx-font-size: 20px;"); // Increase font size

        TextField ballSpeedTextField = new TextField();
        ballSpeedTextField.setPrefWidth(50); // Set preferred width

        // HBox for ball speed
        HBox ballSpeedBox = new HBox(40); // Horizontal layout with spacing of 40
        ballSpeedBox.getChildren().addAll(ballSpeedLabel, ballSpeedTextField, mphLabel);
        ballSpeedBox.setAlignment(Pos.CENTER_RIGHT); // Align the components to the left
        VBox.setMargin(ballSpeedBox, new Insets(-90, 0, 0, 0)); // Add top margin of -10 pixels

        layout.getChildren().addAll(ballSpeedBox); // Add scoring components to the layout

        //if (speedmode) {

            // multiplier Label
            Label multiplierLabel = new Label("Multiplier:");
            multiplierLabel.setStyle("-fx-font-size: 20px;"); // Increase font size

            TextField multiplierTextField = new TextField();
            multiplierTextField.setPrefWidth(135); // Set preferred width

            // HBox for multiplier
            HBox multiplierBox = new HBox(40); // Horizontal layout with spacing of 40
            multiplierBox.getChildren().addAll(multiplierLabel, multiplierTextField);
            multiplierBox.setAlignment(Pos.CENTER_RIGHT); // Align the components to the left
            VBox.setMargin(ballSpeedBox, new Insets(-90, 0, 0, 0)); // Add top margin of -10 pixels

            layout.getChildren().addAll(multiplierBox); // Add scoring components to the layout

        //}

       /* BackgroundImage background1 = new BackgroundImage(
                backgroundImage1,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false)

                  // Set the background image to the layout
                layout.setBackground(new Background(background1));
        */

        // Create an ImageView with the image
        Image image = new Image("SoccerGoalPost.jpg");
        ImageView imageView = new ImageView(image);

        // Set the size of the image view
        imageView.setFitWidth(400); // Set width to 400 pixels
        imageView.setFitHeight(400); // Set height to 400 pixels

        // Create a label
        //Label startLabel = new Label("Game starting...");

        // Create a StackPane to hold the label and image
        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(imageView); // Add both image and label to the stackPane

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
        Scene scene = new Scene(vbox, 1000, 900);

        // Set the scene on the primary stage
        primaryStage.setScene(scene);

        // Show the primary stage
        primaryStage.show();
    }
}

//FOR ALL GAMES

/*
// Player Name Label
        Label playerNameLabel = new Label("  Player Name:");
        playerNameLabel.setStyle("-fx-font-size: 30px;"); // Increase font size

        // Round Label
        Label roundLabel = new Label("Round:");
        roundLabel.setStyle("-fx-font-size: 30px;"); // Increase font size

        // Text Fields
        TextField playerNameTextField = new TextField();
        playerNameTextField.setPrefWidth(200); // Set preferred width
        //playerNameTextField.setText(String.valueOf(currentPlayerIndex)); // Set the text field with the player name

        TextField roundTextField = new TextField();
        roundTextField.setPrefWidth(200); // Set preferred width

        // HBox for Player Name and Round
        HBox labelsBox = new HBox(40); // Horizontal layout with spacing of 40
        labelsBox.getChildren().addAll(playerNameLabel, playerNameTextField, roundLabel, roundTextField);
        labelsBox.setAlignment(Pos.CENTER_LEFT); // Align the components to the left

        // Create a VBox to hold the player information
        VBox layout = new VBox(10); // Vertical layout with spacing of 10
        layout.getChildren().addAll(labelsBox); // Add labelsBox to the layout
        layout.setAlignment(Pos.TOP_LEFT); // Align the layout to the top-left corner
 */