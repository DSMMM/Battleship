package com.dsmmm.battleships.server.board;

class Dimension {
    private final int dimension;

    Dimension(int dimension) {
        this.dimension = dimension;
    }

    boolean greaterThanOrEqual(int value) {
        return dimension >=value;
    }
}
