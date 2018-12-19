package com.dsmmm.battleships.server.board;

/**
 * HINT: how about Identifier as a name?
 */
public interface Coordinate {

    boolean inRange(Dimension dimension);

    Coordinate increment(int y);
}
