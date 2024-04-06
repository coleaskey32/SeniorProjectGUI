package org.example.View;

import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Screen;
import javafx.stage.Stage;
import org.example.Model.Game_Model;

public class Game2_View {

    Game_Model model;
    GridPane gridPane;

    public Game2_View(Stage primaryStage, Game_Model model) {
        // Create an ImageView with the image
        Image image = new Image("SoccerGoalPost.jpg");

        // Get the screen dimensions
        double screenWidth = Screen.getPrimary().getBounds().getWidth();
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

        // Create a StackPane
        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(imageView, gridPane); // Add both image and gridPane to the stackPane

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
