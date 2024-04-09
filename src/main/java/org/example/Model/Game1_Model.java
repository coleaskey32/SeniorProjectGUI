package org.example.Model;

import javafx.stage.Stage;

public class Game1_Model extends Game_Model {
    private int totalPlayers;
    private boolean speedMode;
    private Stage primaryStage;
    // Constructor to initialize totalPlayers and speedMode
    public Game1_Model(int totalPlayers, String selectedGame, boolean speedMode, int rounds, Stage primaryStage) {
        super(totalPlayers, selectedGame, speedMode, rounds, primaryStage);

        initializePlayers();
    }



    @Override
    public int[] setGrid() {
        return new int[]{1, 2, 3, 4, 5};
    }

    @Override
    public void pointsGiven() {

    }



}
