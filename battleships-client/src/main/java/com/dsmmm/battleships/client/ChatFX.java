package com.dsmmm.battleships.client;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class ChatFX extends Application {
    private static Thread serverListener;

    public static void main(String[] args) {
        launch(args);
    }

    static void setServerListener(Thread threadToListen) {
        if (serverListener == null) {
            serverListener = threadToListen;
        }
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
        primaryStage.setOnCloseRequest(event -> {
            Platform.exit();
            //TODO: to nie do końca działa ;) trzeba zamknąć połączenie z serwerem.
            if (serverListener != null) {
                serverListener.interrupt();
            }
        });
        primaryStage.show();
    }
}