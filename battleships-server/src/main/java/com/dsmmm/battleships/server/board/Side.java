package com.dsmmm.battleships.server.board;

/**
 * @TODO: DOCUMENT ME
 */
public enum Side {
    DOWN(0, 1), UP(0, -1), LEFT(-1, 0), RIGHT(1, 0),
    UP_RIGHT(1, -1), DOWN_RIGHT(1, 1), UP_LEFT(-1, -1),
    DOWN_LEFT(-1, 1);

    private final int x;
    private final int y;

    Side(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
