package com.dsmmm.battleships.client;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;


@SuppressWarnings("WeakerAccess")
public class Controller implements Initializable {

    private static final double SIZE = 30.0d;

    private ClientInitializer client;

    @FXML
    private TextField nameId;

    @FXML
    private Button joinId;

    @FXML
    private TextArea chatId;

    @FXML
    private TextField inputChat;

    @FXML
    private Pane paneEnemy;

    @FXML
    private Button generateFleet;

    @FXML
    private Pane paneFleet;

    @FXML
    void inputName() {
        joinId.setDisable(nameId.getText().isEmpty());
    }

    @FXML
    void join() {
        client = new ClientInitializer(nameId.getText());
        if (client.connectWithServer()) {
            proceedConnection();
        } else {
            chatId.appendText("Nie udało się nawiązać połączenia z serwerem.\n");
        }
    }

    private void proceedConnection() {
        client.makeListenerThread(chatId, this);
        joinId.setDisable(true);
        nameId.setDisable(true);
        enableBoard(paneEnemy);
        generateFleet.setDisable(false);
    }

    @FXML
    void enter(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            client.sendMessage(inputChat.getText());
            inputChat.clear();
        }
    }

    @FXML
    private void fillPane(Pane pane) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Button button = new Button();
                button.setLayoutX(i * SIZE);
                button.setLayoutY(j * SIZE);

                button.setPrefHeight(SIZE);
                button.setPrefWidth(SIZE);
                final int high = i + 1;
                final int width = j + 1;
                button.setOnAction(onFieldClickEvent(high, width, button));
                button.setId(high + "-" + width);
                button.setDisable(true);
                pane.getChildren().add(button);
            }
        }
    }

    private void enableBoard(Pane pane) {
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                Button button = (Button) pane.lookup("#" + i + "-" + j);
                button.setDisable(false);
            }
        }
    }

    private void resetFleet() {
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                Button button = (Button) paneFleet.lookup("#" + i + "-" + j);
                button.setStyle("-fx-background-color: #3BB9FF; -fx-opacity: 1.0 !important;");
            }
        }
    }

    void showFleet(String toDecode) {
        Platform.runLater(this::resetFleet);
        Platform.runLater(() -> reloadFleet(toDecode));
    }

    void showEnemyShot(String toDecode) {
        String codeButton = "#" + toDecode;
        Button button = (Button) paneFleet.lookup(codeButton);
        button.setStyle("-fx-background-color: black; -fx-opacity: 1.0 !important;");
    }

    private void reloadFleet(String toDecode) {
        String[] lines = toDecode.split(",");
        for (String s : lines) {
            Button button = (Button) paneFleet.lookup(s);
            button.setStyle("-fx-background-color: brown; -fx-opacity: 1.0 !important;");
        }
    }

    @FXML
    void generateFleet() {
        client.requestGenerateFleet();
    }

    private EventHandler<ActionEvent> onFieldClickEvent(int high, int width, Button button) {
        return (ActionEvent event) -> {
            client.sendCoordinates(high, width);
            button.setStyle("-fx-background-color: black;");
        };
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        fillPane(paneEnemy);
        fillPane(paneFleet);
    }
}