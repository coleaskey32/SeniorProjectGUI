package org.example.View;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button; // Import Button class
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import org.example.Model.Game_Model;

public class Game1_View {

    private Game_Model game;

    public Game1_View(Stage primaryStage, Game_Model game) {

        this.game = game;

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

        // HBox for Player Name
        HBox playerlabelsBox = new HBox(40); // Horizontal layout with spacing of 40
        playerlabelsBox.getChildren().addAll(playerNameLabel, playerNameTextField);
        playerlabelsBox.setAlignment(Pos.TOP_LEFT); // Align the components to the left

        // HBox for Round
        HBox roundlabelsBox = new HBox(40); // Horizontal layout with spacing of 40
        roundlabelsBox.getChildren().addAll(roundLabel, roundTextField);
        roundlabelsBox.setAlignment(Pos.TOP_RIGHT); // Align the components to the left
        //VBox.setMargin(roundlabelsBox, new Insets(-45, 0, 0, 0)); // Add top margin of -10 pixels

        // Spacer to push elements to the left and right
        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        // Create a VBox to hold the player information
        HBox layout = new HBox(40); // Vertical layout with spacing of 10
        layout.getChildren().addAll(playerlabelsBox, spacer, roundlabelsBox); // Add labelsBox to the layout

        // Load the image
        String imagePath = "file:///C:/Users/Jtuch/OneDrive/Desktop/SeniorProjectGUI/goaltempgrid.jpg";
        Image image = new Image(imagePath);

        // Create an ImageView for the image
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(600); // Set the ImageView size as needed
        imageView.setFitWidth(600);
        imageView.setPreserveRatio(true);

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

        VBox scoresBox = new VBox(40); // Horizontal layout with spacing of 40
        scoresBox.getChildren().addAll(totalScoreBox, currentScoreBox); // Add scoring components to the layout
        scoresBox.setAlignment(Pos.CENTER_LEFT); // Align the components to the left

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

        VBox rightSide = new VBox(40); // Horizontal layout with spacing of 40
        rightSide.getChildren().addAll(ballSpeedBox); // Add scoring components to the layout
        rightSide.setAlignment(Pos.CENTER_RIGHT); // Align the components to the left

        rightSide.getChildren().addAll(multiplierBox); // Add scoring components to the layout


        //}


        // Create a button
        Button highScoreButton = new Button("View High Scores");
        highScoreButton.setPrefSize(200, 50); // Set the preferred width and height
        highScoreButton.setStyle("-fx-font-size: 20px;"); // Increase font size


        highScoreButton.setOnAction(e -> {
            // Create a new instance of HighScore_View
            HighScore_View highScoreView = new HighScore_View(primaryStage);
        });

        HBox highScoreBox = new HBox(40);
        // Add button to HBox
        highScoreBox.getChildren().add(highScoreButton);
        // Set alignment of the VBox to bottom center
        highScoreBox.setAlignment(Pos.BOTTOM_CENTER);

        HBox hlayout = new HBox(); // Horizontal layout without specific spacing
        hlayout.setAlignment(Pos.CENTER); // Center align items in the HBox

        Region spacer2 = new Region();
        HBox.setHgrow(spacer2, Priority.ALWAYS);

        Region spacer3 = new Region();
        VBox.setVgrow(spacer3, Priority.ALWAYS);

        Region spacer4 = new Region();
        VBox.setVgrow(spacer4, Priority.ALWAYS);

// Add the left component, spacer, and right component
        hlayout.getChildren().addAll(scoresBox, imageView, spacer2, rightSide);

        VBox layoutFinal = new VBox(40); // Horizontal layout with spacing of 40
        layoutFinal.getChildren().addAll(layout, spacer3, hlayout, spacer4, highScoreBox); // Add scoring components to the layout

        Scene scene;
        scene = new Scene(layoutFinal, 1200, 900); // Set the scene size

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