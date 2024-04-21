package org.example.View;

import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button; // Import Button class
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

import org.example.Controller.HighScore_Controller;
import org.example.Model.Game_Model;
import org.example.Model.Game1_Model;
import org.example.Model.Player;

public class Game1_View {

    private Game_Model model;

    GridPane gridPane;

    // Text Fields
    Label totalScoreTextField = new Label();
    Label currentScoreTextField = new Label();
    Label multiplierTextField = new Label();
    Label ballSpeedTextField = new Label();
    Label playerNameTextField = new Label();
    Label roundTextField = new Label();

    HBox coordIndicator = new HBox(10);// HBox to hold player circles


    public Game1_View(Stage primaryStage, Game_Model model) {

        this.model = model;

        // Player Name Label
        Label playerNameLabel = new Label("  Player Name:");
        playerNameLabel.setStyle("-fx-font-size: 30px;"); // Increase font size

        // Round Label
        Label roundLabel = new Label("Round:");
        roundLabel.setStyle("-fx-font-size: 30px;"); // Increase font size

        // Text Fields
        this.playerNameTextField.setPrefWidth(200); // Set preferred width
        this.roundTextField.setPrefWidth(200); // Set preferred width

        // HBox for Player Name
        HBox playerlabelsBox = new HBox(40); // Horizontal layout with spacing of 40
        playerlabelsBox.getChildren().addAll(playerNameLabel, playerNameTextField);
        playerlabelsBox.setAlignment(Pos.TOP_LEFT); // Align the components to the left

        // HBox for Round
        HBox roundlabelsBox = new HBox(40); // Horizontal layout with spacing of 40
        roundlabelsBox.getChildren().addAll(roundLabel, roundTextField);
        roundlabelsBox.setAlignment(Pos.TOP_RIGHT); // Align the components to the left

        // Spacer to push elements to the left and right
        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        // Create a VBox to hold the player information
        HBox layout = new HBox(40); // Vertical layout with spacing of 10
        layout.getChildren().addAll(playerlabelsBox, spacer, roundlabelsBox); // Add labelsBox to the layout

        // Load the image
        String imagePath = "SoccerGoalPost.jpg";
        Image image = new Image(imagePath);

        // Create an ImageView for the image
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(800); // Set the ImageView size as needed
        imageView.setFitWidth(800);
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
        totalScoreTextField.setPrefWidth(100); // Set preferred width
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
        Label mphLabel = new Label("mph   ");
        mphLabel.setStyle("-fx-font-size: 20px;"); // Increase font size

        ballSpeedTextField.setPrefWidth(50); // Set preferred width

        // HBox for ball speed
        HBox ballSpeedBox = new HBox(40); // Horizontal layout with spacing of 40
        ballSpeedBox.getChildren().addAll(ballSpeedLabel, ballSpeedTextField, mphLabel);
        ballSpeedBox.setAlignment(Pos.CENTER_RIGHT); // Align the components to the left


        // multiplier Label
        Label multiplierLabel = new Label("Multiplier:");
        multiplierLabel.setStyle("-fx-font-size: 20px;"); // Increase font size

        this.multiplierTextField.setPrefWidth(135); // Set preferred width

        // HBox for multiplier
        HBox multiplierBox = new HBox(40); // Horizontal layout with spacing of 40
        multiplierBox.getChildren().addAll(multiplierLabel, multiplierTextField);
        multiplierBox.setAlignment(Pos.CENTER_RIGHT); // Align the components to the left

        VBox rightSide = new VBox(40); // Horizontal layout with spacing of 40
        rightSide.getChildren().addAll(ballSpeedBox); // Add scoring components to the layout
        rightSide.setAlignment(Pos.CENTER_RIGHT); // Align the components to the left

        rightSide.getChildren().addAll(multiplierBox); // Add scoring components to the layout


        // Create a button
        Button highScoreButton = new Button("View High Scores");
        highScoreButton.setPrefSize(200, 50); // Set the preferred width and height
        highScoreButton.setStyle("-fx-font-size: 20px;"); // Increase font size
        highScoreButton.setOnAction(e -> {
            model.openHighScoreWindow();
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


        // Create a GridPane
        gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10); // Horizontal gap between grid elements
        gridPane.setVgap(10); // Vertical gap between grid elements

        // Add colored rectangles to the GridPane
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 6; col++) {

                Label scores = new Label(); // Label indicating player lives
                scores.setStyle("-fx-font-size: 30px;"); // Set font size for the label

                HBox coordIndicator = new HBox(10);// HBox to hold player circles
                coordIndicator.setAlignment(Pos.CENTER); // Align the components to the center
                // Clear previous nodes
                coordIndicator.getChildren().clear();

                // Base URL for random soccer ball images from Unsplash
                String baseUrl = "hearts.png";

                // Create nodes for each life

                Image image2 = new Image(baseUrl);
                ImageView imageView2 = new ImageView(image2);
                imageView2.setFitWidth(75); // Set width of image
                imageView2.setFitHeight(75); // Set height of image
                imageView2.setPreserveRatio(true); // Preserve aspect ratio
                imageView2.setSmooth(true); // Enable smooth scaling
                imageView2.setCache(true); // Cache image for performance
                coordIndicator.getChildren().add(imageView2); // Add image view to the HBox

                gridPane.add(coordIndicator, col, row); // Add rectangle to GridPane

                Rectangle rectangle = new Rectangle(125, 100); // Size of each rectangle
                rectangle.setFill(new Color(1.0, 0, 0, 0.5)); // Set the initial color
                gridPane.add(rectangle, col, row); // Add rectangle to GridPane
                gridPane.add(scores, col, row); // Add rectangle to GridPane


                String gridposition = row + "," + col;

                switch (gridposition) {
                    case "0,0":
                    case "0,5":
                        scores.setText("      5"); // Set the text field with the player name
                        break;
                    case "0,1":
                    case "0,4":
                    case "1,0":
                    case "1,5":
                    case "2,0":
                    case "2,5":
                        scores.setText("      4"); // Set the text field with the player name
                        break;
                    case "1,2":
                    case "1,3":
                        scores.setText("      2"); // Set the text field with the player name
                        break;
                    case "1,1":
                    case "1,4":
                    case "2,1":
                    case "2,4":
                    case "0,2":
                    case "0,3":
                        scores.setText("      3"); // Set the text field with the player name
                        break;
                    case "2,2":
                    case "2,3":
                        scores.setText("      1"); // Set the text field with the player name
                        break;
                }
            }
        }

        // Create a StackPane
        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(imageView, gridPane); // Add both image and gridPane to the stackPane

        // Center the ImageView within the StackPane
        StackPane.setAlignment(gridPane, Pos.CENTER);

        Region spacer5 = new Region();
        HBox.setHgrow(spacer5, Priority.ALWAYS);

        // Add the left component, spacer, and right component
        hlayout.getChildren().addAll(scoresBox, spacer5, stackPane, spacer2, rightSide);

        VBox layoutFinal = new VBox(40); // Horizontal layout with spacing of 40
        layoutFinal.getChildren().addAll(layout, spacer3, hlayout, spacer4, highScoreBox); // Add scoring components to the layout

        // Get the screen dimensions
        double screenWidth = Screen.getPrimary().getBounds().getWidth();
        double screenHeight = Screen.getPrimary().getBounds().getHeight();


        Scene scene = new Scene(layoutFinal, screenWidth, screenHeight); // Set the scene size

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

    // Method to update the score displays
    public void updateScoreDisplays() {
        Player currentPlayer = model.getCurrentPlayer(); // Get current player model

        // Assuming you have getCurrentScore and getTotalScore or equivalent in your player model
        currentScoreTextField.setText(String.valueOf(currentPlayer.getCurrentScore()));
        totalScoreTextField.setText(String.valueOf(currentPlayer.getTotalScore()));
    }

    public void setRectangleVisibility(int row, int col, boolean isVisible) {
        Node node = getNodeByRowColumnIndex(row, col, gridPane);
        if (node != null && node instanceof Rectangle) {
            node.setVisible(isVisible);
        }
    }


    public void setSoccerBallVisibility(int row, int col, boolean isVisable) {
        System.out.println("Row: " + model.getCoordinates()[0] + "Col: " +  model.getCoordinates()[1]);
        //if (row != -1 & col != -1 & isVisable ) {
            Node node = getNodeByRowColumnIndex(row, col, gridPane);
            if (node != null && node instanceof HBox) {
                node.setVisible(isVisable);
            }
       // }
        //else {
            //OutOfBoundsLabel.isvisble(true)
        //}

        //if (!isVisble)
        //OutOfBoundsLabel.isvisble(false)


    }


    public void setRectangleColor(int row, int col, boolean isVisible) {
        Node node = getNodeByRowColumnIndex(row, col, gridPane);
        if (node != null && node instanceof Rectangle) {
            Rectangle rectangle = (Rectangle) node; // Cast the Node to Rectangle
            rectangle.setFill(Color.GREEN);
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


    public void updateMultiplierDisplay() {
        //multiplierTextField.setText(String.valueOf(Game1_Model.setMultiplier()));
    }


    public void setBallSpeedTextField(String targetBallSpeedInterval) {
        this.ballSpeedTextField.setText(targetBallSpeedInterval);
    }

    public void setMultiplierTextField(String mult) {
        this.multiplierTextField.setText(mult);
    }

    public void setCurrentScoreTextField(String pointsEarned) {
        this.currentScoreTextField.setText(pointsEarned);
    }

    public void setRoundTextField(String round) {
        this.roundTextField.setText(round);
    }

    public void setPlayerNameTextField(String name) {
        this.playerNameTextField.setText(name);
    }

    public void setTotalScoreTextField(String score) {
        this.totalScoreTextField.setText(score);
    }
}