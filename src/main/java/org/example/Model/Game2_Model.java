package org.example.Model;

import java.util.Random;

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

        Random random = new Random();
        int randomColumn = random.nextInt(6);
        int randomRow = random.nextInt(3);

        return new int[]{randomColumn, randomRow};
    }

    @Override
    public void pointsGiven() {

    }


}
