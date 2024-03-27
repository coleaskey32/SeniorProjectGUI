package org.example;

import javafx.application.Application;
import javafx.stage.Stage;
import org.example.Controller.Home_Controller;
import org.example.View.Home_View;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        Home_Controller controller = new Home_Controller();
        new Home_View(primaryStage, controller);
    }

    public static void main(String[] args) {
        launch(args);
    }
}