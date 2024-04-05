package org.example.Model;

public class Game1_Model extends Game_Model {
    private int totalPlayers;
    private boolean speedMode;

    // Constructor to initialize totalPlayers and speedMode
    public Game1_Model(int totalPlayers, String selectedGame, boolean speedMode, int rounds) {
        super(totalPlayers, selectedGame, speedMode, rounds);

        initializePlayers();
    }

    // Implement methods specific to Game2_Model
    @Override
    public void start() {
        // Implementation for starting Game 2
    }

    @Override
    public void setGrid() {

    }

    @Override
    public void pointsGiven() {

    }



}
