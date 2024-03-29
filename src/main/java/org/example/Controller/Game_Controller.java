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

    public Game_Controller(Stage primaryStage, String selectedGame, int totalPlayers, boolean speedMode) {

        if ("Game 1".equals(selectedGame)) {
            model = new Game1_Model(totalPlayers, speedMode);
            view1 = new Game1_View(primaryStage, model);
            //view1.display(primaryStage, model); // Display Game1 view
        } else if ("Game 2".equals(selectedGame)) {
            model = new Game2_Model(totalPlayers, speedMode);
            view2 = new Game2_View(primaryStage, model);
            //view2.display(primaryStage, model); // Display Game2 view
        }

        // Additional methods for handling user input and updating the model
    }
}
