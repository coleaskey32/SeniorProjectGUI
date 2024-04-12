package org.example.View;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.MapValueFactory;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Pair;
import org.example.Controller.HighScore_Controller;
import org.example.Model.Player;

import java.util.HashMap;
import java.util.Map;

public class HighScore_View {

    private HighScore_Controller highScoreController;
    private String selectedGame;
    private Stage primaryStage;

    private boolean speedMode;
    private int rounds;
    private Player[] players;



    public HighScore_View(Stage primaryStage, String selectedGame, boolean speedMode, int rounds, Player[] players) {

        this.primaryStage = primaryStage;
        this.selectedGame = selectedGame;
        this.speedMode = speedMode;
        this.players = players;
        this.rounds = rounds;
        primaryStage.setTitle("Highscore");

        this.highScoreController = new HighScore_Controller(selectedGame, speedMode, rounds, players);

        VBox back = new VBox(20); // Create a vertical layout
        // Here, you would add components to 'layout' that make up your high score screen.
        // For example, labels showing high scores, maybe loaded from your Game_Model or another source.

        // Optionally, add a back button to return to the previous view
        Button backButton = new Button("Game Select");
        backButton.setOnAction(e -> {});
        back.getChildren().add(backButton);
        back.setAlignment(Pos.BOTTOM_CENTER);


        GridPane gridPane = new GridPane();
        gridPane.setHgap(10); // Horizontal gap between columns
        gridPane.setVgap(5); // Vertical gap between rows

        // Add column headers
        Label nameLabel = new Label("Name");
        nameLabel.setFont(Font.font(14)); // Set font size
        gridPane.add(nameLabel, 0, 0); // Add to first column, first row

        Label scoreLabel = new Label("Score");
        scoreLabel.setFont(Font.font(14)); // Set font size
        gridPane.add(scoreLabel, 1, 0); // Add to second column, first row

        // Add data
        for (int i = 0; i < 10; i++) {
            Label name = new Label(highScoreController.getLeaderBoardName(i));
            Label score = new Label(String.valueOf(highScoreController.getLeaderBoardScore(i)));

            // Add name and score labels to the grid
            gridPane.add(name, 0, i + 1); // Add to first column, next row
            gridPane.add(score, 1, i + 1); // Add to second column, next row
        }


        // Create a VBox to hold the TableView
        VBox root = new VBox(gridPane, back);

        Scene highScoreScene = new Scene(root, 1200, 900); // Adjust size as needed
        primaryStage.setScene(highScoreScene); // Set the new scene on the primary stage
        primaryStage.setTitle("High Score");

    }
}