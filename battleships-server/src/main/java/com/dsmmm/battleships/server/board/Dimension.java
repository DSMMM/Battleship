package com.dsmmm.battleships.server.board;

class Dimension {
    private final int dimensionValue;

    Dimension(int dimensionValue) {
        this.dimensionValue = dimensionValue;
    }

    boolean greaterThanOrEqual(int value) {
        return dimensionValue >=value;
    }
}
