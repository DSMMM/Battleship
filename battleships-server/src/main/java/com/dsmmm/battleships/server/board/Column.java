package com.dsmmm.battleships.server.board;

import java.util.Objects;

class Column implements Coordinate {
    private final int value;

    Column(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Column column = (Column) o;
        return value == column.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public Column increment(int x) {
        return new Column(value + x);
    }

    @Override
    public boolean inRange(Dimension dimension) {
        return value > 0 && dimension.greaterThanOrEqual(value);
    }

    @Override
    public String toString() {
        return "" + value;
    }
}

