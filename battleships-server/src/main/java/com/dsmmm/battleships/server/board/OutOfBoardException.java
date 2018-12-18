package com.dsmmm.battleships.server.board;

public class OutOfBoardException extends RuntimeException{
    public OutOfBoardException(String message) {
        super(message);
    }
}
