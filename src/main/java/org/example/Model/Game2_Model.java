package org.example.Model;

import java.lang.Math;


public class Game2_Model extends Game_Model {
    private int totalPlayers;
    private boolean speedMode;

    // Constructor to initialize totalPlayers and speedMode
    public Game2_Model(int totalPlayers, String selectedGame, boolean speedMode, int rounds) {
        super(totalPlayers, selectedGame, speedMode, rounds);

        initializePlayers();
    }

    // Implement methods specific to Game2_Model
    @Override
    public void start() {
        // Implementation for starting Game 2
    }

    @Override
    public int[] setGrid() {
        int randomColumn = (int)(Math.random() * 5);
        int randomRow = (int)(Math.random() * 2);
        return new int[]{randomRow, randomColumn};
    }

    @Override
    public void pointsGiven() {

    }


}
