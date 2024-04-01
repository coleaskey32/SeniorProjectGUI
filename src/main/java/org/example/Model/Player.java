package org.example.Model;

public class Player {
    private String playerName;
    private int currentScore;

    public Player(String playerName) {
        this.playerName = playerName;
        this.currentScore = 0; // Initialize score to 0
    }

    // Getters and setters for playerName and currentScore
    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getCurrentScore() {
        return currentScore;
    }

    public void setCurrentScore(int currentScore) {
        this.currentScore = currentScore;
    }
}
