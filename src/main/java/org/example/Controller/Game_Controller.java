package org.example.Controller;

import javafx.stage.Stage;

import org.example.Model.Game_Model;
import org.example.Model.Game1_Model;
import org.example.Model.Game2_Model;
import org.example.View.Game1_View;
import org.example.View.Game2_View;

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
            model = new Game1_Model(totalPlayers, selectedGame, speedMode, rounds);
            view2 = new Game2_View(primaryStage, model);
            //view2.display(primaryStage, model); // Display Game2 view
        }

        startGame();
    }




    private void startGame() {

        if (!selectedGame.equals("Game 1")) {
            model.setGrid();
        }
    }


}

    /*
    private void startGame() {

        while model.getRounds() > 0 && model.checkLives(){

            //IF GAME 2 then
            model.setGrid();

            //
            model.retrieveCoordinates();


            // Playing Simon Says (Game 2)
            if model.pointsGiven() < 0 {
                //decrement lives
            }

            else {
                //Display points
            }



        }
    }
*/
