package com.dsmmm.battleships.server.board;

import java.util.Objects;
import java.util.function.Predicate;

public class Coordinates {

    private final Column column;
    private final Row row;

    public Coordinates(Column column, Row row) {
        this.column = column;
        this.row = row;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return Objects.equals(column, that.column) &&
                Objects.equals(row, that.row);
    }

    @Override
    public int hashCode() {
        return Objects.hash(column, row);
    }


    Coordinates getNeighbour(Side side, Dimension dimension) {
        Column newColumn = column.increment(side.getX());
        Row newRow = row.increment(side.getY());

        checkIfInRange(newColumn, coordinate -> coordinate.inRange(dimension));
        checkIfInRange(newRow, coordinate -> coordinate.inRange(dimension));
        return new Coordinates(newColumn, newRow);
    }

    private void checkIfInRange(Coordinate coordinate, Predicate<Coordinate> predicate) {
        if (!predicate.test(coordinate)) throw new OutOfBoardException("Coordinate out of dimension");
    }

}