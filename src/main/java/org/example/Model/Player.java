package org.example.Model;

public class Player {
    private String playerName;
    private int currentScore;
    private int totalScore; // Additional attribute to hold the total score

    public Player(String playerName) {
        this.playerName = playerName;
        this.currentScore = 0; // Initialize current score to 0
        this.totalScore = 0; // Initialize total score to 0
    }

    // Getters and setters for playerName
    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    // Getter and setter for currentScore
    public int getCurrentScore() {
        return currentScore;
    }

    public void setCurrentScore(int currentScore) {
        this.currentScore = currentScore;
        // Optionally, every time current score is set, you might want to update total score
        // This depends on your game's scoring logic
        this.totalScore += currentScore; // Update total score
    }

    // Getter for totalScore
    public int getTotalScore() {
        return totalScore;
    }

    // Optionally, if you need to directly set total score or adjust it
    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    // Method to add to the total score without resetting it
    public void addToTotalScore(int scoreToAdd) {
        this.totalScore += scoreToAdd;
    }
}
