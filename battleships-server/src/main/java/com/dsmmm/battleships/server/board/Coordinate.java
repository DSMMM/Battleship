package com.dsmmm.battleships.server.board;

public interface Coordinate {

    boolean inRange(Dimension dimension);

    Coordinate increment(int y);
}
