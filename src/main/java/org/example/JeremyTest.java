package org.example;

// Import statements for JavaFX classes
import javafx.application.Application; // Application class for JavaFX application lifecycle
import javafx.geometry.Pos; // Pos class for positioning elements in JavaFX layouts
import javafx.scene.Scene; // Scene class for representing a scene graph in JavaFX
import javafx.scene.control.Button; // Button class for creating buttons in JavaFX
import javafx.scene.control.Label; // Label class for displaying text in JavaFX
import javafx.scene.control.TextField; // TextField class for text input in JavaFX
import javafx.scene.image.Image; // Image class for loading images in JavaFX
import javafx.scene.image.ImageView; // ImageView class for displaying images in JavaFX
import javafx.scene.layout.HBox; // HBox class for horizontal box layout in JavaFX
import javafx.scene.layout.VBox; // VBox class for vertical box layout in JavaFX
import javafx.scene.paint.Color; // Color class for specifying colors in JavaFX
import javafx.scene.shape.Circle; // Circle class for drawing circles in JavaFX
import javafx.stage.Stage; // Stage class for representing a window in JavaFX

// Import statements for Java core classes
import java.util.ArrayList; // ArrayList class for dynamic arrays in Java
import java.util.List; // List interface for representing ordered collections in Java


public class JeremyTest extends Application {

    private String selectedGame = ""; // Variable to keep track of the selected game
    private int totalPlayers = 0; // Variable to store the total number of players
    final int MIN_PLAYERS = 1; // Minimum number of players allowed
    final int MAX_PLAYERS = 4; // Maximum number of players allowed
    int rounds = 0; // Variable to store the number of rounds

    // Boolean variable to track speed mode
    boolean speedMode = false; // Indicates whether speed mode is enabled or not. False means "No".

    List<Circle> playerCircles = new ArrayList<>(); // ArrayList to store Circle objects representing players


    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Game Select"); //Name of window

        // Static text field
        Label selectLabel = new Label("Select a Game!"); //prompt the user
        selectLabel.setStyle("-fx-font-size: 80px;"); //font size

        // Paths for images
        String game1ImagePath = "file:///C:/Users/Jtuch/OneDrive/Desktop/SeniorProjectGUI/400x400.png"; //local image example
        String game2ImagePath = "https://source.unsplash.com/400x400/?Soccer"; //online image example

        // Buttons with images
        Button game1Button = new Button(); //Shoot 'n' score button on game select screen
        game1Button.setGraphic(new ImageView(new Image(game1ImagePath))); //Image viewing function
        game1Button.setPrefSize(400, 400); //set button width and height
        game1Button.setStyle("-fx-font-size: 40px;"); //font size
        game1Button.setOnAction(e -> {
            selectedGame = "Game 1"; // Set selected game
            System.out.println("Selected Game 1: " + selectedGame); // Print message
        });

        Button game2Button = new Button(); //Simon says button on game select screen
        game2Button.setGraphic(new ImageView(new Image(game2ImagePath))); //Image viewing function
        game2Button.setPrefSize(400, 400); //set button width and height
        game2Button.setStyle("-fx-font-size: 40px;"); //font size
        game2Button.setOnAction(e -> {
            selectedGame = "Game 2"; // Set selected game
            System.out.println("Selected Game 2: " + selectedGame); // Print message
        });

        // Labels for game numbers
        Label game1Label = new Label("Game 1"); // Label indicating game number
        game1Label.setAlignment(Pos.CENTER); // Center align the text
        game1Label.setStyle("-fx-font-size: 30px;"); // Set font size for the label

        Label game2Label = new Label("Game 2"); // Label indicating game number
        game2Label.setAlignment(Pos.CENTER); // Center align the text
        game2Label.setStyle("-fx-font-size: 30px;"); // Set font size for the label

        // Labels for game names
        Label game1Name = new Label("Shoot 'n' Score"); // Label indicating the name of Game 1
        game1Name.setAlignment(Pos.CENTER); // Center align the text
        game1Name.setStyle("-fx-font-size: 40px;"); // Set font size for the label

        Label game2Name = new Label("Simon Says  "); // Label indicating the name of Game 2
        game2Name.setAlignment(Pos.CENTER); // Center align the text
        game2Name.setStyle("-fx-font-size: 40px;"); // Set font size for the label


        // Enter button
        Button enterButton = new Button("Enter"); // Button for entering the game and continuing
        enterButton.setPrefSize(200, 100); // Set preferred size for the button
        enterButton.setStyle("-fx-font-size: 40px;"); // Set font size for the button
        enterButton.setOnAction(e -> {
            // Open settings window when the button is clicked
            openSettingsWindow();
        });

// Layout
        VBox spaceAbove = new VBox(20); // Vertical box for space above the buttons
        VBox spaceBelow = new VBox(0); // Vertical box for space below the buttons
        HBox buttonBox = new HBox(20); // Horizontal box for holding buttons with spacing between them
        buttonBox.getChildren().addAll(game1Button, game2Button); // Add game buttons to the box
        buttonBox.setAlignment(Pos.CENTER); // Center align the buttons horizontally

        // Combine game name labels in a single HBox
        HBox gameNames = new HBox(250); // Horizontal box for holding game name labels with spacing between them
        gameNames.getChildren().addAll(game1Name, game2Name); // Add game name labels to the box
        gameNames.setAlignment(Pos.CENTER); // Center align the labels horizontally

// Combine game number labels in a single HBox
        HBox gameLabels = new HBox(400); // Horizontal box for holding game number labels with spacing between them
        gameLabels.getChildren().addAll(game1Label, game2Label); // Add game number labels to the box
        gameLabels.setAlignment(Pos.CENTER); // Center align the labels horizontally

        VBox layout = new VBox(20); // Vertical box for organizing elements with spacing between them
        layout.getChildren().addAll(selectLabel, spaceAbove, gameNames, buttonBox, gameLabels, spaceBelow, enterButton); // Add elements to the layout
        layout.setAlignment(Pos.CENTER); // Center align the layout

// Scene
        Scene scene = new Scene(layout, 1000, 900); // Create a scene with the layout and set window size
        primaryStage.setScene(scene); // Set the scene to the primary stage
        primaryStage.show(); // Display the primary stage

    }

    // Method to update player circles
    private void updatePlayerCircles(int totalPlayers, HBox playersHBox) {
        // Clear previous circles
        playersHBox.getChildren().clear();

        // Create circles for each player
        for (int i = 0; i < MAX_PLAYERS; i++) {
            Circle circle = new Circle(20); // Create a circle with radius
            circle.setFill(i < totalPlayers ? Color.GREEN : Color.LIGHTGRAY); // Fill the circle if it represents a player
            circle.setStroke(Color.BLACK); // Set the border color
            playersHBox.getChildren().add(circle); // Add the circle to the HBox
        }
    }

    // Method to open the settings window
    private void openSettingsWindow() {
        // Create new stage for settings window
        Stage settingsStage = new Stage();
        settingsStage.setTitle("Settings");

        // Create layout for settings window
        VBox settingsLayout = new VBox(20); // Set spacing between elements
        settingsLayout.setAlignment(Pos.CENTER); // Center align the layout
        settingsLayout.setPrefSize(1200, 900); // Set preferred size

        // Label for title
        Label titleLabel = new Label("Select your Settings!");
        titleLabel.setStyle("-fx-font-size: 60px;"); // Set font size

        // Add space before titleLabel
        VBox spaceBeforeTitle = new VBox(20); // Spacer before titleLabel
        spaceBeforeTitle.getChildren().add(new Label()); // Adding an empty label as spacer

        // Label for number of players
        Label playersLabel = new Label("How many players?");
        playersLabel.setStyle("-fx-font-size: 30px;"); // Set font size
        VBox spaceBeforePlayers = new VBox(20); // Spacer before playersLabel
        spaceBeforePlayers.getChildren().add(new Label()); // Adding an empty label as spacer


        // Text field for total players
        //TextField totalPlayersField = new TextField();
        //totalPlayersField.setEditable(false); // Make it non-editable
        //totalPlayersField.setPrefWidth(50); // Set preferred width

        // HBox to hold player circles
        HBox playersHBox = new HBox(10); // Set spacing between circles
        playersHBox.setAlignment(Pos.CENTER); // Center align the player circles

// Button to add player
        Button addPlayerButton = new Button("Add Player"); //button name
        addPlayerButton.setStyle("-fx-font-size: 20px;"); // Set font size
        addPlayerButton.setOnAction(e -> {
            if (totalPlayers < MAX_PLAYERS) { // Check if the maximum limit is reached (4)
                totalPlayers++; //add one to player count
                //totalPlayersField.setText(String.valueOf(totalPlayers));
                updatePlayerCircles(totalPlayers, playersHBox);
            }
        });

// Button to delete player
        Button deletePlayerButton = new Button("Delete Player"); //button name
        deletePlayerButton.setStyle("-fx-font-size: 20px;"); // Set font size
        deletePlayerButton.setOnAction(e -> {
            if (totalPlayers > MIN_PLAYERS) { // Check if the minimum limit is reached (1)
                totalPlayers--;
                //totalPlayersField.setText(String.valueOf(totalPlayers));
                updatePlayerCircles(totalPlayers, playersHBox);
            }
        });

// Add buttons to an HBox for horizontal arrangement
        HBox buttonBox = new HBox(20); // Set spacing between buttons
        buttonBox.getChildren().addAll(addPlayerButton, deletePlayerButton); // Add buttons to the HBox
        buttonBox.setAlignment(Pos.CENTER); // Center align the buttons


// Add space after buttons
        VBox spaceAfterButtons = new VBox(20); // Spacer after buttons
        spaceAfterButtons.getChildren().add(new Label()); // Adding an empty label as spacer

        Label roundsLabel = new Label("How many rounds per player?"); //prompt the user
        roundsLabel.setStyle("-fx-font-size: 30px;"); //font size

        // Initialize player circles
        updatePlayerCircles(totalPlayers, playersHBox);

        // Add space before roundsLabel
        VBox spaceBeforeRounds = new VBox(20); // Spacer before roundsLabel
        spaceBeforeRounds.getChildren().add(new Label()); // Adding an empty label as spacer

        // Label for speed affecting points
        Label speedLabel = new Label("Does speed affect points?");//prompt the user
        speedLabel.setStyle("-fx-font-size: 30px;"); //font size

        // Add space before speedLabel
        VBox spaceBeforeSpeed = new VBox(20); // Spacer before speedLabel
        spaceBeforeSpeed.getChildren().add(new Label()); // Adding an empty label as spacer

        // Add space after the continue button
        VBox spaceAfterContinue = new VBox(20); // Spacer after continueButton
        spaceAfterContinue.getChildren().add(new Label()); // Adding an empty label as spacer

        // Button to close the settings window and open the appropriate game window
        Button continueButton = new Button("Continue"); //button name
        continueButton.setStyle("-fx-font-size: 30px;"); // Set font size
        continueButton.setOnAction(e -> {
            settingsStage.close(); // Close the settings window

            // Open the appropriate game window based on selectedGame variable
            if (selectedGame.equals("Game 1")) {
                openGame1Window();
            } else if (selectedGame.equals("Game 2")) {
                openGame2Window();
            }
        });


        // Create HBox for the buttons
        HBox roundsButtonsBox = new HBox(20); // Set spacing between buttons
        roundsButtonsBox.setAlignment(Pos.CENTER); // Center align the buttons

// Button for 5 rounds
        Button rounds5Button = new Button("5"); //button name
        rounds5Button.setStyle("-fx-font-size: 20px;"); //font size
        rounds5Button.setOnAction(e -> {
            // Set the rounds variable to 5
            rounds = 5;
            System.out.println("Selected rounds: " + rounds); // Print selected rounds
        });

// Button for 10 rounds
        Button rounds10Button = new Button("10"); //button name
        rounds10Button.setStyle("-fx-font-size: 20px;"); //font size
        rounds10Button.setOnAction(e -> {
            // Set the rounds variable to 10
            rounds = 10;
            System.out.println("Selected rounds: " + rounds); // Print selected rounds
        });

// Button for infinite rounds
        Button roundsInfinityButton = new Button("Infinity"); //button name
        roundsInfinityButton.setStyle("-fx-font-size: 20px;"); //font size
        roundsInfinityButton.setOnAction(e -> {
            // Set the rounds variable to a large value
            rounds = Integer.MAX_VALUE;
            System.out.println("Selected rounds: " + rounds); // Print selected rounds
        });


// Add buttons to the HBox
        roundsButtonsBox.getChildren().addAll(rounds5Button, rounds10Button, roundsInfinityButton);

// Button for speed mode "Yes"
        Button yesButton = new Button("Yes"); //button name
        yesButton.setStyle("-fx-font-size: 20px;"); //font size
        yesButton.setOnAction(e -> {
            // Set speed mode to true
            speedMode = true;
            System.out.println("Speed mode: " + speedMode); // Print speed mode
        });

// Button for speed mode "No"
        Button noButton = new Button("No"); //button name
        noButton.setStyle("-fx-font-size: 20px;"); //font size
        noButton.setOnAction(e -> {
            // Set speed mode to false
            speedMode = false;
            System.out.println("Speed mode: " + speedMode); // Print speed mode
        });

// HBox to hold the speed mode buttons
        HBox speedModeButtons = new HBox(20); // Set spacing between buttons
        speedModeButtons.getChildren().addAll(yesButton, noButton);
        speedModeButtons.setAlignment(Pos.CENTER); // Center align the buttons


// Add labels, buttons, and spacers to layout
        settingsLayout.getChildren().addAll(
                titleLabel, //Select a game prompt
                spaceBeforePlayers, //spacing
                playersLabel, //prompt user number of players
                //totalPlayersField,
                buttonBox, // Add the HBox for add and delete player buttons
                playersHBox, // Add the HBox for player circles
                spaceBeforeRounds, //spacing
                roundsLabel, //prompt user for rounds
                roundsButtonsBox, // Add the HBox for rounds buttons 5,10, and infinity
                spaceBeforeSpeed, //spacing
                speedLabel, //prompt user about speed mode
                speedModeButtons, //yes and no button for selecting speed mode
                spaceAfterButtons, // Add space after buttons
                spaceAfterContinue, // Add space after continueButton
                continueButton //button to continue to game screen
        );


// Set scene and show stage
        Scene settingsScene = new Scene(settingsLayout); //declare
        settingsStage.setScene(settingsScene); //set
        settingsStage.show(); //display
    }

    // Method to open Game 1 window
    private void openGame1Window() {
        Stage game1Stage = new Stage();
        game1Stage.setTitle("Shoot 'n' Score"); // Set window title

        // Create layout for Game 1 window
        VBox game1Layout = new VBox(20); // Set spacing
        game1Layout.setAlignment(Pos.CENTER); //set position to center
        game1Layout.getChildren().add(new Label("Game 1 Window")); // Add content to the layout

        // Set scene and show stage
        Scene game1Scene = new Scene(game1Layout, 400, 300); // declare window size
        game1Stage.setScene(game1Scene); //set scene
        game1Stage.show();//display
    }

    // Method to open Game 2 window
    private void openGame2Window() {
        Stage game2Stage = new Stage();
        game2Stage.setTitle("Simon Says"); // Set window title

        // Create layout for Game 2 window
        VBox game2Layout = new VBox(20); // Set spacing
        game2Layout.setAlignment(Pos.CENTER); //set position to center
        game2Layout.getChildren().add(new Label("Game 2 Window")); // Add content to the layout

        // Set scene and show stage
        Scene game2Scene = new Scene(game2Layout, 400, 300); // declare window size
        game2Stage.setScene(game2Scene);//set scene
        game2Stage.show();//display
    }

    //main function
    public static void main(String[] args) {
        launch(args);
    }
}
