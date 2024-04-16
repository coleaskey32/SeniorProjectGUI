package org.example.Controller;

import javafx.scene.paint.Color;
import javafx.stage.Stage;

import org.example.Model.Game_Model;
import org.example.Model.Game1_Model;
import org.example.Model.Game2_Model;
import org.example.View.Game1_View;
import org.example.View.Game2_View;
import org.example.View.HighScore_View;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Game_Controller {
    private Game_Model model;
    private Game1_View view1;
    private Game2_View view2;

    private String selectedGame;

    private boolean speedMode;
    private int totalPlayers;
    private Stage primaryStage;


    public Game_Controller(Stage primaryStage, String selectedGame, int totalPlayers, boolean speedMode, int rounds) {

        this.selectedGame = selectedGame;
        this.primaryStage = primaryStage;
        this.totalPlayers = totalPlayers;
        this.speedMode = speedMode;

        if ("Game 1".equals(selectedGame)) {
            model = new Game1_Model(totalPlayers, selectedGame, speedMode, rounds, primaryStage);
            view1 = new Game1_View(primaryStage, model);
            //view1.display(primaryStage, model); // Display Game1 view
        } else if ("Game 2".equals(selectedGame)) {
            model = new Game2_Model(totalPlayers, selectedGame, speedMode, rounds, primaryStage);
            view2 = new Game2_View(primaryStage, model);
            //view2.display(primaryStage, model); // Display Game2 view
        }

        startGame();
    }


    private void startGame() {


        int[] randomGridIndex = new int[2];
        int[] randomSpeedInterval = new int[2];
        int earnedPoints;

        // While there is still rounds left and someone is still alive if Simon Says
        while (model.getCurrentRound() > 0) {


            System.out.println(model.getCurrentRound() + "  " + model.getCurrentPlayerNum());

            //Initialize all grid elements to be invisible in Simon Says and visible in shoot and score
            if (selectedGame.equals("Game 2")) {
                for (int row = 0; row < 3; row++) {
                    for (int col = 0; col < 3; col++) {
                        view2.setRectangleVisibility(row, col, false);
                    }
                }
            } else {
                for (int row = 0; row < 3; row++) {
                    for (int col = 0; col < 6; col++) {
                        view1.setRectangleVisibility(row, col, true);
                    }
                }
            }


            // If the game is Simon Says display a random box to hit
            if (selectedGame.equals("Game 2")) {

                // Get random grid index
                randomGridIndex = model.generateRandomCoordinates();

                System.out.print(randomGridIndex[0] + " " + randomGridIndex[1]);

                // Show target Grid element in view
                view2.setRectangleVisibility(randomGridIndex[0], randomGridIndex[1], true);
                view2.setRectangleColor(randomGridIndex[0], randomGridIndex[1], Color.BLUE);
            }

            // Generate and display target speed interval
            if (speedMode) {
                model.generateRandomSpeedRange();
                randomSpeedInterval = model.getRandomSpeedInterval();

                if (selectedGame.equals("Game 1"))
                    view1.setBallSpeedTextField(randomSpeedInterval[0] + "-" + randomSpeedInterval[1]);

                //view2.setBallSpeedTextField(model.getRandomSpeedInterval());
            }

            //Runs cpp file (will wait to move on till process is finished)
            model.retrieveCoordinate();

            //Find how many points the player got
            earnedPoints = model.pointsGiven();

            //Add points to players score
            model.addToPlayerScore(earnedPoints);

            //Implement points on view
            if (selectedGame.equals("Game 1")) {
                view1.setCurrentScoreTextField(String.valueOf(earnedPoints));
            }

            //Increment player
            System.out.println("Current Player: " + model.getCurrentPlayerNum() + " Total Players " + totalPlayers);
            if (model.getCurrentPlayerNum() == totalPlayers) {
                System.out.println("Putting Player to 1");
                model.decrementRounds();
                model.setCurrentPlayer(1);
            } else {
                System.out.println("Incrementing player");
                model.setCurrentPlayer(model.getCurrentPlayerNum() + 1);
            }

        }
    }
}
