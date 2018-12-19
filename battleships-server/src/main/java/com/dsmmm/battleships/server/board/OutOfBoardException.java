package com.dsmmm.battleships.server.board;

public class OutOfBoardException extends IndexOutOfBoundsException{
    public OutOfBoardException(String message) {
        super(message);
    }
}
