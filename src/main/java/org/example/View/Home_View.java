package org.example.View;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.Controller.Home_Controller;

public class Home_View {

    private Home_Controller controller;

    public Home_View(Stage primaryStage, Home_Controller controller) {
        this.controller = controller;
        primaryStage.setTitle("Game Select"); // Name of window

        // UI Components
        Label selectLabel = new Label("Select a Game!");
        selectLabel.setStyle("-fx-font-size: 80px;");

        String game1ImagePath = "file:///C:/Users/Jtuch/OneDrive/Desktop/SeniorProjectGUI/400x400.png";
        String game2ImagePath = "https://source.unsplash.com/400x400/?Soccer";

        Button game1Button = createButton(game1ImagePath, "Game 1", "Shoot 'n' Score");
        Button game2Button = createButton(game2ImagePath, "Game 2", "Simon Says");

        Button enterButton = new Button("Enter");
        enterButton.setPrefSize(200, 100);
        enterButton.setStyle("-fx-font-size: 40px;");
        enterButton.setOnAction(e -> controller.openGameSettingWindow(primaryStage));

        // Layout
        VBox layout = new VBox(20);
        layout.getChildren().addAll(selectLabel, game1Button, game2Button, enterButton);
        layout.setAlignment(Pos.CENTER);

        // Scene
        Scene scene = new Scene(layout, 800, 800);
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
