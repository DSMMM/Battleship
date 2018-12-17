package com.dsmmm.battleships.server.board;

import java.util.Objects;

class Coordinates {

    private final Column column;
    private final Row row;

    Coordinates(Column column, Row row) {
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
        Column newColumn = column.add(side.getX());
        Row newRow = row.add(side.getY());

        if(newColumn.inRange(dimension) && newRow.inRange(dimension)) {
            return new Coordinates(newColumn, newRow);
        }

        return null; //TODO throw exception
    }
}
