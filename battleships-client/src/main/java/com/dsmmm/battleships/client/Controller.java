package com.dsmmm.battleships.client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Controller {

    @FXML
    private TextArea nameId;

    @FXML
    private Button joinId;

    @FXML
    private TextField chatId;

    @FXML
    private TextArea nameId1;

    @FXML
    void enter(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            System.out.println("entered");
        }
    }

    @FXML
    void join(ActionEvent event) {
        System.out.println("join");
    }

}