package com.dsmmm.battleships.client;


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

public class Controller implements Initializable {
    private ClientInitializer client;
    @FXML
    private TextField nameId;

    @FXML
    private Button joinId;

    @FXML
    private TextArea chatId;

    @FXML
    private TextField inputChat;

    private static final int SIZE = 30;

    @FXML
    private Pane paneEnemy;


    @FXML
    private Pane paneFleet;

    @FXML
    void inputName() {
        joinId.setDisable(nameId.getText().isEmpty());
    }

    @FXML
    void join() {
        client = new ClientInitializer(nameId.getText());
        client.listenToServer(chatId);
        joinId.setDisable(true);
        nameId.setDisable(true);
        enableBoard(paneEnemy);
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
                button.setId(i + "-" + j);
                button.setDisable(true);
                pane.getChildren().add(button);
            }
        }
    }

    @FXML
    private void enableBoard(Pane pane) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Button button = (Button) pane.lookup("#" + i + "-" + j);
                button.setDisable(false);
            }
        }
    }

    private EventHandler<ActionEvent> onFieldClickEvent(int high, int width, Button button) {
        return (ActionEvent event) -> {
            client.sendCoordinates(width, high);
            button.setStyle("-fx-background-color: black;");
        };
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        fillPane(paneEnemy);
        fillPane(paneFleet);
    }
}