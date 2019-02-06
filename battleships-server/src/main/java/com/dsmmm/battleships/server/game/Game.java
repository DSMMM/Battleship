package com.dsmmm.battleships.server.game;

import com.dsmmm.battleships.server.board.Board;

public class Game {
    private Board board;

    public String generateCodesOfShipCoordinates() {
        board = new Board();
        return board.generateCodesOfShipCoordinates();
    }
}
