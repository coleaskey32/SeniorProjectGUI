package org.example.Controller;

import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.application.Platform;
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
        Thread gameThread = new Thread(() -> {
            int earnedPoints;

            // While there are still rounds left and someone is still alive
            while (model.getCurrentRound() > 0) {

                if (selectedGame.equals("Game 1")) {
                    view1.setRoundTextField(String.valueOf(model.getCurrentRound()));
                    view1.setPlayerNameTextField(String.valueOf(model.getCurrentPlayerNum()));
                }
                else {
                    view2.setRoundTextField(String.valueOf(model.getCurrentRound()));
                    view2.setPlayerNameTextField(String.valueOf(model.getCurrentPlayerNum()));
                }

                System.out.println("Round: " + model.getCurrentRound() + "  Player: " + model.getCurrentPlayerNum());

                // Update UI visibility based on selected game
                if (selectedGame.equals("Game 2")) {
                    for (int row = 0; row < 3; row++) {
                        for (int col = 0; col < 3; col++) {
                            view2.setRectangleVisibility(row, col, false);
                        }
                    }
                }
                else {
                    for (int row = 0; row < 3; row++) {
                        for (int col = 0; col < 6; col++) {
                            view1.setRectangleVisibility(row, col, true);
                        }
                    }
                }

                // Display random box in "Simon Says" game
                if (selectedGame.equals("Game 2")) {
                    int[] randomGridIndex = model.generateRandomCoordinates();
                    view2.setRectangleVisibility(randomGridIndex[0], randomGridIndex[1], true);
                    view2.setRectangleColor(randomGridIndex[0], randomGridIndex[1], Color.BLUE);
                }

                // Generate and display target speed interval for "Simon Says" game
                if (speedMode && selectedGame.equals("Game 2")) {
                    model.generateRandomSpeedRange();
                    view2.setTargetSpeedTextField(model.getRandomSpeedInterval()[0] + " - " + model.getRandomSpeedInterval()[1]);
                }

                // Retrieve coordinate from C++ program
                model.retrieveCoordinate();

                // Calculate earned points
                earnedPoints = model.pointsGiven();
                final int currentScore = earnedPoints;

                // Add points to players total score
                model.addToPlayerScore(earnedPoints);
                final int playerTotalScore = model.getCurrentPlayer().getTotalScore();

                System.out.println("Player Score: " + model.getCurrentPlayer().getTotalScore());
                System.out.println("Player Speed: " + model.getBallSpeed());

                // Implement player's kicked ball speed on view and score they received
                Platform.runLater(() -> {
                    if (selectedGame.equals("Game 1")) {
                        view1.setBallSpeedTextField(String.valueOf(model.getBallSpeed()));
                        view1.setCurrentScoreTextField(String.valueOf(currentScore));
                        view1.setTotalScoreTextField(String.valueOf(playerTotalScore));
                    }
                    else {
                        System.out.println("Lives Left: " + model.getCurrentLives());
                        view2.setTrueSpeedTextField(String.valueOf(model.getBallSpeed()));
                        view2.updateLivesCircles(model.getCurrentLives());
                    }
                });

                // Increment player
                if (model.getCurrentPlayerNum() == totalPlayers) {
                    model.decrementRounds();
                    model.setCurrentPlayer(1);
                }
                else {
                    model.setCurrentPlayer(model.getCurrentPlayerNum() + 1);
                }

                // Add a short delay to prevent CPU consumption and allow UI responsiveness
                try {
                    Thread.sleep(100); // Adjust sleep duration as needed
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        gameThread.start();
    }

}
