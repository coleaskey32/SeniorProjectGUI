package org.example.View;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Screen;
import javafx.stage.Stage;
import org.example.Controller.Game_Controller;
import org.example.Model.Game1_Model;
import org.example.Model.Game2_Model;
import org.example.Model.Game_Model;
import org.example.Controller.GameSetting_Controller;

import java.util.ArrayList;
import java.util.List;


public class Game2_View {

    Game_Model model;
    GridPane gridPane;

    double targetSpeed = 0;

    List<Circle> livesCircles = new ArrayList<>(); // ArrayList to store Circle objects representing players

    Label playerNameTextField = new Label();
    Label trueSpeedTextField = new Label();
    Label targetSpeedTextField = new Label();
    Label roundTextField = new Label();
    Label outOfBounds = new Label();
    Label gameOver = new Label();
    Button highScoreButton = new Button("View High Scores");
    public HBox livesHBox = new HBox(10);// HBox to hold player circles

    public Game2_View(Stage primaryStage, Game_Model model) {

        this.model = model;

        outOfBounds.setAlignment(Pos.TOP_CENTER); // Align the components to the center
        outOfBounds.setStyle("-fx-font-size: 100px;"); // Set font size for the label
        outOfBounds.setText("  Out of bounds!");


        gameOver.setAlignment(Pos.TOP_CENTER); // Align the components to the center
        gameOver.setStyle("-fx-font-size: 100px;"); // Set font size for the label
        gameOver.setText("  Game Over!");

        // Player Name Label
        Label playerNameLabel = new Label("  Player Name:");
        playerNameLabel.setStyle("-fx-font-size: 30px;"); // Increase font size

        // Round Label
        Label roundLabel = new Label("Round:");
        roundLabel.setStyle("-fx-font-size: 30px;"); // Increase font size

        // Text Fields
        playerNameTextField.setPrefWidth(200); // Set preferred width
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


        trueSpeedTextField.setPrefWidth(100); // Set preferred width

        // HBox for true speed
        HBox trueSpeedBox = new HBox(40); // Horizontal layout with spacing of 40
        trueSpeedBox.getChildren().addAll(trueSpeedLabel, trueSpeedTextField);
        trueSpeedBox.setAlignment(Pos.CENTER_LEFT); // Align the components to the left

        //if (this.model.getSpeedMode()){   }

        // Target speed Label
        Label targetSpeedLabel = new Label("   Target Speed:");
        targetSpeedLabel.setStyle("-fx-font-size: 20px;"); // Increase font size


        // Text Fields
        targetSpeedTextField.setPrefWidth(100); // Set preferred width


        // HBox for Total Score
        HBox targetSpeedBox = new HBox(40); // Horizontal layout with spacing of 40
        targetSpeedBox.getChildren().addAll(targetSpeedLabel, targetSpeedTextField);
        targetSpeedBox.setAlignment(Pos.CENTER_LEFT); // Align the components to the left

        // Label for player lives
        Label livesLabel = new Label("Player Lives"); // Label indicating player lives
        livesLabel.setStyle("-fx-font-size: 30px;"); // Set font size for the label

        // Add buttons to an HBox for horizontal arrangement
        HBox livesButtonBox = new HBox(20); // Set spacing between buttons
        livesButtonBox.getChildren().addAll(livesLabel); // Add buttons to the HBox
        livesButtonBox.setAlignment(Pos.BOTTOM_CENTER); // Center align the buttons

        Region spacer6 = new Region();
        VBox.setVgrow(spacer6, Priority.ALWAYS);

        VBox speedBox = new VBox(40);
        speedBox.getChildren().addAll(livesButtonBox, livesHBox, spacer6, trueSpeedBox, targetSpeedBox);
        speedBox.setAlignment(Pos.CENTER_LEFT); // Align the components to the left

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        Region spacer2 = new Region();
        HBox.setHgrow(spacer2, Priority.ALWAYS);

        Region space = new Region();
        HBox.setHgrow(space, Priority.ALWAYS);

        Region spacer3 = new Region();
        VBox.setVgrow(spacer3, Priority.ALWAYS);

        Region spacer4 = new Region();
        VBox.setVgrow(spacer4, Priority.ALWAYS);

        Region spacer5 = new Region();
        VBox.setVgrow(spacer5, Priority.ALWAYS);

        // Create a GridPane
        gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10); // Horizontal gap between grid elements
        gridPane.setVgap(10); // Vertical gap between grid elements

        // Add colored rectangles to the GridPane
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {



                Label scores = new Label(); // Label indicating player lives
                scores.setStyle("-fx-font-size: 30px;"); // Set font size for the label

                HBox coordIndicator = new HBox(10);// HBox to hold player circles
                coordIndicator.setAlignment(Pos.CENTER); // Align the components to the center
                // Clear previous nodes
                coordIndicator.getChildren().clear();

                // Base URL for random soccer ball images from Unsplash
                String baseUrl = "ball.png";
                // Create soccer ball images
                Image image2 = new Image(baseUrl);
                ImageView imageView2 = new ImageView(image2);
                imageView2.setFitWidth(75); // Set width of image
                imageView2.setFitHeight(75); // Set height of image
                imageView2.setPreserveRatio(true); // Preserve aspect ratio
                imageView2.setSmooth(true); // Enable smooth scaling
                imageView2.setCache(true); // Cache image for performance
                coordIndicator.getChildren().add(imageView2); // Add image view to the HBox
                gridPane.add(coordIndicator, col, row); // Add rectangle to GridPane

                Rectangle rectangle = new Rectangle(250, 100); // Size of each rectangle
                rectangle.setFill(Color.BLUE); // Set the initial color
                gridPane.add(rectangle, col, row); // Add rectangle to GridPane
            }
        }

        // Create a StackPane
        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(imageView, gridPane); // Add both image and gridPane to the stackPane

        // Center the ImageView within the StackPane
        StackPane.setAlignment(gridPane, Pos.CENTER);

        HBox hlayout = new HBox(40);
        hlayout.getChildren().addAll(space, speedBox, spacer, stackPane, spacer2);
        hlayout.setAlignment(Pos.CENTER); // Align the components to the left

        // Create a button
        highScoreButton.setPrefSize(200, 50); // Set the preferred width and height
        highScoreButton.setStyle("-fx-font-size: 20px;"); // Increase font size
        highScoreButton.setOnAction(e -> { model.openHighScoreWindow(); });

        HBox highScoreBox = new HBox(40);
        // Add button to HBox
        highScoreBox.getChildren().add(highScoreButton);
        // Set alignment of the VBox to bottom center
        highScoreBox.setAlignment(Pos.BOTTOM_CENTER);

        // Get the screen dimensions
        double screenWidth = Screen.getPrimary().getBounds().getWidth();
        double screenHeight = Screen.getPrimary().getBounds().getHeight();

        // Calculate the desired width and height as a percentage of the screen size
        double widthPercentage = 0.75; // 75% of screen width
        double heightPercentage = 0.75; // 75% of screen height


        VBox layoutFinal = new VBox(40);
        layoutFinal.getChildren().addAll(layout, spacer3, hlayout, spacer4, highScoreBox, spacer5);
        layoutFinal.setAlignment(Pos.CENTER_LEFT); // Align the components to the left

        // Set white background color for the StackPane
        stackPane.setStyle("-fx-background-color: white;");

        // Set the StackPane as the root of the scene
        Scene scene = new Scene(layoutFinal, screenWidth, screenHeight);

        // Set the scene on the primary stage
        primaryStage.setScene(scene);

        // Show the primary stage
        primaryStage.show();
    }

    public void updateLivesCircles(int lives) {

        livesHBox.setAlignment(Pos.CENTER); // Align the components to the center

        // Clear previous nodes
        livesHBox.getChildren().clear();

        // Base URL for random soccer ball images from Unsplash
        String baseUrl = "hearts.png";

        // Create nodes for each life
        for (int i = 0; i < lives; i++) { // Assuming a fixed number of lives (3)
            Image image = new Image(baseUrl);
            ImageView imageView = new ImageView(image);
            imageView.setFitWidth(75); // Set width of image
            imageView.setFitHeight(75); // Set height of image
            imageView.setPreserveRatio(true); // Preserve aspect ratio
            imageView.setSmooth(true); // Enable smooth scaling
            imageView.setCache(true); // Cache image for performance
            livesHBox.getChildren().add(imageView); // Add image view to the HBox
        }
    }

    public void setRectangleVisibility(int row, int col, boolean isVisible) {
        if (isVisible)
            System.out.println("Box to hit: " + row + " " + col);
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

    public void updatePlayerNameDisplay(String playerName) {
        playerNameTextField.setText(playerName);
    }

    public void updateBallSpeedDisplay() {
        double currentBallSpeed = model.getBallSpeed(); // Assuming `model` is your Game_Model instance
        trueSpeedTextField.setText(String.valueOf(currentBallSpeed));
    }

    public void updateTargetSpeedDisplay() {
        targetSpeedTextField.setText(String.valueOf(calculateTargetSpeed()));
    }

    public String calculateTargetSpeed(){
        double num1 = (Math.random() * 35);
        long rounded = Math.round(num1);
        String newTargetSpeed = rounded + "-" + (rounded + 10);
        return newTargetSpeed;
    }

    public void setSoccerBallVisibility(int row, int col, boolean isVisible) {
        //row = -1;
        //col = -1;
        System.out.println("Row: " + model.getCoordinates()[0] + "Col: " +  model.getCoordinates()[1]);
        //if (row == -1 && col == -1 ) {
        // outOfBoundsVisibility(true);}
        //else {
        Node node = getNodeByRowColumnIndex(row, col, gridPane);
        if (node != null && node instanceof HBox) {
            node.setVisible(isVisible);
        }
        //}
    }

    public void setTrueSpeedTextField(String speed) { this.trueSpeedTextField.setText(speed); }
    public void setTargetSpeedTextField(String targetBallSpeedInterval) {this.targetSpeedTextField.setText(targetBallSpeedInterval); }
    public void setPlayerNameTextField(String name) { this.playerNameTextField.setText(name); }
    public void setRoundTextField(String round) { this.roundTextField.setText(round); }
    public void setGameOverVisibility(boolean visibility) {this.gameOver.setVisible(visibility); }
    public void setOutOfBoundsVisibility(boolean visibility) {this.outOfBounds.setVisible(visibility); }
    public void setHighScoreButtonVisibility(boolean visibility) {this.highScoreButton.setVisible(visibility);}

}