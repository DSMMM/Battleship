package com.dsmmm.battleships.server.board;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Board {
    private final Dimension dimension;
    private Map<Coordinates, Field> mapOfFields;

    Board(Dimension dimension) {
        this.dimension = dimension;
        this.mapOfFields = new HashMap<>();
        initializeBoard();
    }

    public Board() {
        this(new Dimension());
        this.mapOfFields = new HashMap<>();
        initializeBoard();
    }

    Field getField(Coordinates coordinates) {
        return mapOfFields.get(coordinates);
    }


    private void initializeBoard() {
        for (Column c = new Column(1); c.inRange(dimension); c = c.increment(1)) {
            rowGenerator(c);
        }
    }

    private void rowGenerator(Column c) {
        for (Row r = new Row(1); r.inRange(dimension); r = r.increment(1)) {
            Coordinates coordinates = new Coordinates(c, r);
            mapOfFields.put(coordinates, new NotShotWater());
        }
    }

    public Set<Coordinates> getAllPossibleCoordinates() {
        return mapOfFields.keySet();
    }
}
