package com.dsmmm.battleships.server.board;

import com.dsmmm.battleships.server.fleet.Fleet;
import com.dsmmm.battleships.server.fleet.Randomizer;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Board {
    private final Dimension dimension;
    private Map<Coordinates, Field> mapOfFields;
    private Fleet fleet;

    Board(Dimension dimension) {
        this.dimension = dimension;
        this.mapOfFields = new HashMap<>();
        this.fleet = new Randomizer().generateRandomFleet();

        placeShips();
        floodWithWater();
    }

    private void placeShips() {
        for(Coordinates coordinates:fleet.getShipsCoordinates()) {
            mapOfFields.put(coordinates, new NotShotMast());
        }
    }

    public Board() {
        this(new Dimension());
    }

    Field getField(Coordinates coordinates) {
        return mapOfFields.get(coordinates);
    }

    private void floodWithWater() {
        for (Column c = new Column(1); c.inRange(dimension); c = c.increment(1)) {
            rowGenerator(c);
        }
    }

    private void rowGenerator(Column c) {
        for (Row r = new Row(1); r.inRange(dimension); r = r.increment(1)) {
            Coordinates coordinates = new Coordinates(c, r);
            mapOfFields.putIfAbsent(coordinates, new NotShotWater());
        }
    }
}
