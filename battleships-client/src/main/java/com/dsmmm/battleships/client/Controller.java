package com.dsmmm.battleships.client;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Controller {
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
    void inputName() {
        if (nameId.getText().equals("")) {
            joinId.setDisable(true);
        } else {
            joinId.setDisable(false);
        }
    }

    @FXML
    void join() {
        client = new ClientInitializer(nameId.getText());
        client.listenToServer(chatId);
        joinId.setDisable(true);
        nameId.setDisable(true);
    }

    @FXML
    void enter(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            client.sendMessage(inputChat.getText());
            inputChat.clear();
        }
    }
}