package com.dsmmm.battleships.server.board;

public class Dimension {
    private final int dimensionValue;

    public Dimension(int dimensionValue) {
        this.dimensionValue = dimensionValue;
    }

    public Dimension() {
        this(10);
    }

    boolean greaterThanOrEqual(int value) {
        return dimensionValue >= value;
    }
}
