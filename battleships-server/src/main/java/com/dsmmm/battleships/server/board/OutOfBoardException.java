package com.dsmmm.battleships.server.board;

class OutOfBoardException extends RuntimeException{
    OutOfBoardException(String message) {
        super(message);
    }
}
