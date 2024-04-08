package org.example.View;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Screen;
import javafx.stage.Stage;
import org.example.Controller.Game_Controller;
import org.example.Model.Game_Model;

import java.util.ArrayList;
import java.util.List;


public class Game2_View {

    Game_Model model;
    GridPane gridPane;

    List<Circle> livesCircles = new ArrayList<>(); // ArrayList to store Circle objects representing players

    public HBox livesHBox = new HBox(10);// HBox to hold player circles

    public Game2_View(Stage primaryStage, Game_Model model) {

        this.model = model;

        updateLivesCircles(livesHBox);

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

        // HBox for Round
        HBox roundlabelsBox = new HBox(40); // Horizontal layout with spacing of 40
        roundlabelsBox.getChildren().addAll(roundLabel, roundTextField);


        // Create a VBox to hold the player information
        HBox layout = new HBox(40); // Vertical layout with spacing of 10
        layout.getChildren().addAll(playerlabelsBox, roundlabelsBox); // Add labelsBox to the layout
        roundlabelsBox.setAlignment(Pos.TOP_CENTER); // Align the components to the left


        // Create an ImageView with the image
        Image image = new Image("SoccerGoalPost.jpg");

        // Create an ImageView for the image
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(800); // Set the ImageView size as needed
        imageView.setFitWidth(800);
        imageView.setPreserveRatio(true);

        // true speed Label
        Label trueSpeedLabel = new Label("   Ball Speed:   ");
        trueSpeedLabel.setStyle("-fx-font-size: 20px;"); // Increase font size


        TextField trueSpeedTextField = new TextField();
        trueSpeedTextField.setPrefWidth(100); // Set preferred width

        // HBox for true speed
        HBox trueSpeedBox = new HBox(40); // Horizontal layout with spacing of 40
        trueSpeedBox.getChildren().addAll(trueSpeedLabel, trueSpeedTextField);
        trueSpeedBox.setAlignment(Pos.CENTER_LEFT); // Align the components to the left

        //if (speedmode) {
        // Target speed Label
        Label targetSpeedLabel = new Label("   Target Speed:");
        targetSpeedLabel.setStyle("-fx-font-size: 20px;"); // Increase font size


        // Text Fields
        TextField targetSpeedTextField = new TextField();
        targetSpeedTextField.setPrefWidth(100); // Set preferred width


        // HBox for Total Score
        HBox targetSpeedBox = new HBox(40); // Horizontal layout with spacing of 40
        targetSpeedBox.getChildren().addAll(targetSpeedLabel, targetSpeedTextField);
        targetSpeedBox.setAlignment(Pos.CENTER_LEFT); // Align the components to the left

        VBox speedBox = new VBox(40);
        speedBox.getChildren().addAll(trueSpeedBox, targetSpeedBox);
        speedBox.setAlignment(Pos.CENTER_LEFT); // Align the components to the left

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        Region spacer2 = new Region();
        HBox.setHgrow(spacer2, Priority.ALWAYS);

        Region spacer3 = new Region();
        VBox.setVgrow(spacer3, Priority.ALWAYS);

        Region spacer4 = new Region();
        VBox.setVgrow(spacer4, Priority.ALWAYS);

        Region spacer5 = new Region();
        VBox.setVgrow(spacer5, Priority.ALWAYS);

        HBox hlayout = new HBox(40);
        hlayout.getChildren().addAll(speedBox, spacer, imageView, spacer2);
        hlayout.setAlignment(Pos.CENTER); // Align the components to the left


        // Label for player lives
        Label livesLabel = new Label("Player Lives"); // Label indicating player lives
        livesLabel.setStyle("-fx-font-size: 30px;"); // Set font size for the label

        // Add buttons to an HBox for horizontal arrangement
        HBox livesButtonBox = new HBox(20); // Set spacing between buttons
        livesButtonBox.getChildren().addAll(livesLabel); // Add buttons to the HBox
        livesButtonBox.setAlignment(Pos.BOTTOM_CENTER); // Center align the buttons


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

        VBox layoutFinal = new VBox(40);
        layoutFinal.getChildren().addAll(layout, spacer3, hlayout, spacer4, livesButtonBox, livesHBox, spacer5, highScoreBox);
        layoutFinal.setAlignment(Pos.CENTER_LEFT); // Align the components to the left



        // Get the screen dimensions
      /*  double screenWidth = Screen.getPrimary().getBounds().getWidth();
        double screenHeight = Screen.getPrimary().getBounds().getHeight();

        // Calculate the desired width and height as a percentage of the screen size
        double widthPercentage = 0.75; // 75% of screen width
        double heightPercentage = 0.75; // 75% of screen height
        double imageViewWidth = screenWidth * widthPercentage;
        double imageViewHeight = screenHeight * heightPercentage;

        ImageView imageView = new ImageView(image);

        // Set the size of the image view
        imageView.setFitWidth(imageViewWidth);
        imageView.setFitHeight(imageViewHeight);
*/
        // Create a GridPane
        gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10); // Horizontal gap between grid elements
        gridPane.setVgap(10); // Vertical gap between grid elements

        // Add colored rectangles to the GridPane
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 6; col++) {
                Rectangle rectangle = new Rectangle(125, 100); // Size of each rectangle
                rectangle.setFill(Color.RED); // Set the initial color
                gridPane.add(rectangle, col, row); // Add rectangle to GridPane
            }
        }


        Scene scene;
        scene = new Scene(layoutFinal, 1200, 900); // Set the scene size
        // Set the scene on the primary stage
        primaryStage.setScene(scene);

        // Show the primary stage
        primaryStage.show();
    }

    public static void updateLivesCircles(HBox livesHBox) {
        livesHBox.setAlignment(Pos.CENTER); // Align the components to the left

        // Clear previous circles
        livesHBox.getChildren().clear();

        // Create circles for each player
        for (int i = 0; i < 3; i++) {
            Circle circle = new Circle(20); // Create a circle with radius
            circle.setFill(i < 3 ? Color.GREEN : Color.LIGHTGRAY); // Fill the circle if it represents a player
            circle.setStroke(Color.BLACK); // Set the border color
            livesHBox.getChildren().add(circle); // Add the circle to the HBox
        }
    }

    public void setRectangleVisibility(int row, int col, boolean isVisible) {
        Node node = getNodeByRowColumnIndex(row, col, gridPane);
        if (node != null && node instanceof Rectangle) {
            node.setVisible(isVisible);
        }
    }

    // Method to set the color of a specific rectangle
    public void setRectangleColor(int row, int col, Color color) {
        Node node = getNodeByRowColumnIndex(row, col, gridPane);
        if (node != null && node instanceof Rectangle) {
            ((Rectangle) node).setFill(color);
        }
    }

    // Helper method to get node by row and column index
    private Node getNodeByRowColumnIndex(final int row, final int column, GridPane gridPane) {
        Node result = null;
        ObservableList<Node> children = gridPane.getChildren();

        for (Node node : children) {
            if (gridPane.getRowIndex(node) == row && gridPane.getColumnIndex(node) == column) {
                result = node;
                break;
            }
        }

        return result;
    }
}
