package org.example.View;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.Controller.GameSetting_Controller;
public class GameSetting_View {

    private GameSetting_Controller controller;

    public GameSetting_View(Stage primaryStage) {
        this.controller = new GameSetting_Controller();

        Stage settingsStage = new Stage();
        settingsStage.setTitle("Settings");

        VBox settingsLayout = new VBox(20);
        settingsLayout.setAlignment(Pos.CENTER);
        settingsLayout.setPrefSize(1200, 900);

        Label titleLabel = new Label("Select your Settings!");
        titleLabel.setStyle("-fx-font-size: 60px;");
        VBox spaceBeforeTitle = new VBox(20);
        spaceBeforeTitle.getChildren().add(new Label());

        Label playersLabel = new Label("How many players?");
        playersLabel.setStyle("-fx-font-size: 30px;");
        VBox spaceBeforePlayers = new VBox(20);
        spaceBeforePlayers.getChildren().add(new Label());

        HBox playersHBox = new HBox(10);
        playersHBox.setAlignment(Pos.CENTER);

        Button addPlayerButton = new Button("Add Player");
        addPlayerButton.setStyle("-fx-font-size: 20px;");
        addPlayerButton.setOnAction(e -> controller.addPlayer());

        Button deletePlayerButton = new Button("Delete Player");
        deletePlayerButton.setStyle("-fx-font-size: 20px;");
        deletePlayerButton.setOnAction(e -> controller.deletePlayer());

        HBox buttonBox = new HBox(20);
        buttonBox.getChildren().addAll(addPlayerButton, deletePlayerButton);
        buttonBox.setAlignment(Pos.CENTER);

        VBox spaceAfterButtons = new VBox(20);
        spaceAfterButtons.getChildren().add(new Label());

        Label roundsLabel = new Label("How many rounds per player?");
        roundsLabel.setStyle("-fx-font-size: 30px;");
        VBox spaceBeforeRounds = new VBox(20);
        spaceBeforeRounds.getChildren().add(new Label());

        HBox roundsButtonsBox = new HBox(20);
        roundsButtonsBox.setAlignment(Pos.CENTER);
        Button rounds5Button = new Button("5");
        rounds5Button.setStyle("-fx-font-size: 20px;");
        rounds5Button.setOnAction(e -> controller.setRounds(5));

        Button rounds10Button = new Button("10");
        rounds10Button.setStyle("-fx-font-size: 20px;");
        rounds10Button.setOnAction(e -> controller.setRounds(10));

        Button roundsInfinityButton = new Button("Infinity");
        roundsInfinityButton.setStyle("-fx-font-size: 20px;");
        roundsInfinityButton.setOnAction(e -> controller.setRounds(Integer.MAX_VALUE));

        roundsButtonsBox.getChildren().addAll(rounds5Button, rounds10Button, roundsInfinityButton);

        Label speedLabel = new Label("Does speed affect points?");
        speedLabel.setStyle("-fx-font-size: 30px;");
        VBox spaceBeforeSpeed = new VBox(20);
        spaceBeforeSpeed.getChildren().add(new Label());

        Button yesButton = new Button("Yes");
        yesButton.setStyle("-fx-font-size: 20px;");
        yesButton.setOnAction(e -> controller.setSpeedMode(true));

        Button noButton = new Button("No");
        noButton.setStyle("-fx-font-size: 20px;");
        noButton.setOnAction(e -> controller.setSpeedMode(false));

        HBox speedModeButtons = new HBox(20);
        speedModeButtons.setAlignment(Pos.CENTER);
        speedModeButtons.getChildren().addAll(yesButton, noButton);

        VBox spaceAfterContinue = new VBox(20);
        spaceAfterContinue.getChildren().add(new Label());

        Button continueButton = new Button("Continue");
        continueButton.setStyle("-fx-font-size: 30px;");
        continueButton.setOnAction(e -> controller.openGameWindow(primaryStage));

        settingsLayout.getChildren().addAll(
                titleLabel, spaceBeforePlayers, playersLabel, buttonBox, playersHBox,
                spaceBeforeRounds, roundsLabel, roundsButtonsBox, spaceBeforeSpeed,
                speedLabel, speedModeButtons, spaceAfterButtons, spaceAfterContinue,
                continueButton
        );

        Scene settingsScene = new Scene(settingsLayout);
        settingsStage.setScene(settingsScene);
        settingsStage.show();
    }
}
