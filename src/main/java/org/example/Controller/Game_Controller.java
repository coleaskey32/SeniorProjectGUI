package org.example.Controller;

import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import org.example.Model.Game_Model;
import org.example.Model.Game1_Model;
import org.example.Model.Game2_Model;
import org.example.View.Game1_View;
import org.example.View.Game2_View;

import java.util.ArrayList;
import java.util.List;

public class Game_Controller {
    private Game_Model model;
    private Game1_View view1;
    private Game2_View view2;

    private String selectedGame;

    public Game_Controller(Stage primaryStage, String selectedGame, int totalPlayers, boolean speedMode, int rounds) {

        this.selectedGame = selectedGame;


        if ("Game 1".equals(selectedGame)) {
            model = new Game1_Model(totalPlayers, selectedGame, speedMode, rounds);
            view1 = new Game1_View(primaryStage, model);
            //view1.display(primaryStage, model); // Display Game1 view
        } else if ("Game 2".equals(selectedGame)) {
            model = new Game2_Model(totalPlayers, selectedGame, speedMode, rounds);
            view2 = new Game2_View(primaryStage, model);

            //view2.display(primaryStage, model); // Display Game2 view
        }

        startGame();
    }

    private void startGame() {

        //Initialize all grid elements to be invisible in Simon Says
        if (selectedGame.equals("Game 2")) {
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 6; col++) {
                    view2.setRectangleVisibility(row, col, false);
                }
            }
        }

        // If the game is Simon Says
        if (selectedGame.equals("Game 2")) {

            int[] randomGridIndex = model.setGrid();
            System.out.print(randomGridIndex[0] + " " + randomGridIndex[1]);

            // Show target Grid element
            view2.setRectangleVisibility(randomGridIndex[0], randomGridIndex[1], true);
            view2.setRectangleColor(randomGridIndex[0], randomGridIndex[1], Color.BLUE);
        }

        //Get the coordinates of the players kick
        String coordinates = model.retrieveCoordinates();

        //model.pointsGiven(coordinates);


    }


}

