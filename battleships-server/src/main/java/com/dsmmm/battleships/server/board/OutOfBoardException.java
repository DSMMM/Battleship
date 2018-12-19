package com.dsmmm.battleships.server.board;

class OutOfBoardException extends IndexOutOfBoundsException{
    public OutOfBoardException(String message) {
        super(message);
    }
}
