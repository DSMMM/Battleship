package com.dsmmm.battleships.server.board;

import java.util.HashMap;
import java.util.Map;

class Board {

    private Map<Coordinates, Field> mapOfFields;
    private Dimension dimension;

    Board(Dimension dimension)  {
        this.dimension = dimension;
        mapOfFields = new HashMap<>();
        Field field = new NotShotWater();
        for (Column c = new Column(1); c.inRange(dimension); c = c.increment(1)) {
            for(Row r = new Row(1); r.inRange(dimension); r = r.increment(1)) {
                Coordinates coordinates = new Coordinates(c,r);
                mapOfFields.put(coordinates, field);
            }
        }
    }

    Field getField(Coordinates coordinates) {
        return mapOfFields.get(coordinates);
    }
}
