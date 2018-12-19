package com.dsmmm.battleships.server.board;

/**
 * I'm a happy coordinate created by
 * @author Dominika.
 * HINT: how about Identifier as a name?
 */
public interface Coordinate {

    boolean inRange(Dimension dimension);

    Coordinate increment(int y);
}
