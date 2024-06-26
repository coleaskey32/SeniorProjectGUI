package org.example.View;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.example.Controller.Home_Controller;

public class Home_View {

    private Home_Controller controller;

    public Home_View(Stage primaryStage, Home_Controller controller) {
        this.controller = controller;
        primaryStage.setTitle("Home"); // Name of window

        // UI Components
        Label selectLabel = new Label("Select a Game!");
        selectLabel.setStyle("-fx-font-family: 'Elephant'; -fx-font-size: 80px;");

        Label game1Label = new Label("Game 1");
        game1Label.setStyle("-fx-font-family: 'Elephant'; -fx-font-size: 25px;");

        Label shootnscoreLabel = new Label("Shoot 'n' Score!");
        shootnscoreLabel.setStyle("-fx-font-family: 'Elephant'; -fx-font-size: 40px;");

        Label game2Label = new Label("Game 2");
        game2Label.setStyle("-fx-font-family: 'Elephant'; -fx-font-size: 25px;");

        Label simonSaysLabel = new Label("Simon Says!");
        simonSaysLabel.setStyle("-fx-font-family: 'Elephant'; -fx-font-size: 40px;");


        // Paths for images
        String game1ImagePath = "game1.png";
        String game2ImagePath = "game2.png";

        Button game1Button = createButton(game1ImagePath, "Game 1", "Shoot 'n' Score");
        Button game2Button = createButton(game2ImagePath, "Game 2", "Simon Says");

        //game1Button.setStyle("-fx-background: #336699, white;");
        //game2Button.setStyle("-fx-background: #336699, white;");

        Button enterButton = new Button("Enter");
        enterButton.setPrefSize(200, 100);
        enterButton.setStyle("-fx-font-family: 'Elephant'; -fx-font-size: 35px;");
        enterButton.setOnAction(e -> controller.openGameSettingWindow(primaryStage));

        //Game1layout
        VBox game1layout = new VBox(20);
        game1layout.getChildren().addAll(game1Label, game1Button, shootnscoreLabel);
        game1layout.setAlignment(Pos.CENTER);

        //Game2layout
        VBox game2layout = new VBox(20);
        game2layout.getChildren().addAll(game2Label, game2Button, simonSaysLabel);
        game2layout.setAlignment(Pos.CENTER);

        //Gameslayout
        HBox games = new HBox(20);
        games.getChildren().addAll(game1layout, game2layout);
        games.setAlignment(Pos.CENTER);

        // Layout
        VBox layout = new VBox(20);
        layout.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null))); // Set background color
        layout.getChildren().addAll(selectLabel, games, enterButton);
        layout.setAlignment(Pos.CENTER);

        // Scene
        Scene scene = new Scene(layout, 1000, 900);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Button createButton(String imagePath, String gameNumber, String gameName) {
        Button button = new Button();
        button.setGraphic(new ImageView(new Image(imagePath)));
        button.setPrefSize(400, 400);
        button.setStyle("-fx-font-size: 40px;");
        button.setOnAction(e -> controller.setSelectedGame(gameNumber, gameName));
        return button;
    }
}