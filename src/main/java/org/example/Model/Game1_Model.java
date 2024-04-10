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
        //needs a get position from main.cpp
        String ballposition = "0,0";

        switch (ballposition){
            case "0,0":
            case "0,5":
               // setCurrentScore(5);
                break;
            case "0,1":
            case "0,4":
            case "1,0":
            case "1,5":
            case "2,0":
            case "2,5":
              //  setCurrentScore(4);
                break;
            case "1,2":
            case "1,3":
                //  setCurrentScore(2);
                break;
            case "1,1":
            case "1,4":
            case "2,1":
            case "2,4":
            case "0,2":
            case "0,3":
                //  setCurrentScore(3);
                break;
            case "2,2":
            case "2,3":
                //  setCurrentScore(1);
                break;

                //if speedMode true
            //Decimal totalScore = 0;
            //setCurrentScore(multiplier * currentScore);
            //totalScore = currentScore + totalScore
            //else
            //totalScore = currentScore + totalScore


        }
    }



}
