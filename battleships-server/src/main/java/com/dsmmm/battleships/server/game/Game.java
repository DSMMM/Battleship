package com.dsmmm.battleships.server.game;

import com.dsmmm.battleships.server.board.Board;
import com.dsmmm.battleships.server.board.Coordinates;

public class Game {
    private Board board;

    public String generateCodesOfShipCoordinates() {
        board = new Board();
        return board.generateCodesOfShipCoordinates();
    }

    public boolean takeShot(Coordinates coordinates) {
        return board.takeShot(coordinates);
    }
}
