package org.example.Model;

public class Game1_Model extends Game_Model {
    private int totalPlayers;
    private boolean speedMode;

    // Constructor to initialize totalPlayers and speedMode
    public Game1_Model(int totalPlayers, String selectedGame, boolean speedMode, int rounds) {
        super(totalPlayers, selectedGame, speedMode, rounds);

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
