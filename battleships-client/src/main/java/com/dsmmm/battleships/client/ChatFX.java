package com.dsmmm.battleships.client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class ChatFX extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        URL resource = getClass().getClassLoader().getResource("sample.fxml");
        if (resource == null) {
            Printer.print("Could not initialize graphic interface.");
            return;
        }
        Parent root = FXMLLoader.load(resource);
        primaryStage.setTitle("Battleships: the Game");
        Scene scene = new Scene(root, 747, 613);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setOnCloseRequest(event -> System.exit(0));
        primaryStage.show();
    }
}