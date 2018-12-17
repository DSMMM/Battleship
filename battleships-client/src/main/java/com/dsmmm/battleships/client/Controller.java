package com.dsmmm.battleships.client;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    private static final int SIZE = 30;

    @FXML
    private Pane paneEnemy;


    @FXML
    private Pane paneFleet;

    @FXML
    private Button start;

    @FXML
    private void fillPane(Pane pane) {
        for(int i = 0; i<10; i++) {
            for (int j = 0; j < 10; j++) {
                Button button = new Button();
                button.setLayoutX(i * SIZE);
                button.setLayoutY(j * SIZE);


                button.setPrefHeight(SIZE);
                button.setPrefWidth(SIZE);
                final int high = i + 1;
                final int width = j + 1;
                button.setOnAction(event-> System.out.println(high + ", " +  width));
                button.setId(String.valueOf(i));
                pane.getChildren().add(button);
            }
        }
    }

//    @FXML
//    private void fillEnemyPane(){
//        for(int i = 0; i<10; i++) {
//            for (int j = 0; j < 10; j++) {
//                Button button = new Button();
//                button.setLayoutX(i * SIZE);
//                button.setLayoutY(j * SIZE);
//
//
//                button.setPrefHeight(SIZE);
//                button.setPrefWidth(SIZE);
//                final int high = i +1;
//                final int width = j+1;
//                button.setOnAction(event-> System.out.println(high + ", " +  width));
//                button.setId(String.valueOf(i));
//                this.paneEnemy.getChildren().add(button);
//
//            }
//        }
//    }
//
//
//    @FXML
//    private void fillFleetPane(){
//        for(int i = 0; i<10; i++) {
//            for (int j = 0; j < 10; j++) {
//                Button button = new Button();
//                button.setLayoutX(i * SIZE);
//                button.setLayoutY(j * SIZE);
//
//
//                button.setPrefHeight(SIZE);
//                button.setPrefWidth(SIZE);
//                final int high = i +1;
//                final int width = j+1;
//                button.setOnAction(event -> System.out.println(high + " " + width));
//
//
//                button.setId(String.valueOf(i));
//                this.paneFleet.getChildren().add(button);
//
//            }
//        }
//    }




    @Override
    public void initialize(URL location, ResourceBundle resources) {
        fillPane(paneEnemy);
        fillPane(paneFleet);
    }
}