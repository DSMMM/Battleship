package com.dsmmm.battleships.server.fleet;

import com.dsmmm.battleships.server.board.Coordinates;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Fleet{

    private final Set<Ship> ships = new HashSet<>();
    private final Shipyard shipyard = new Shipyard();
    private Set<Coordinates> shipsCoordinates = new HashSet<>();

    public Set<Coordinates> getShipsCoordinates() {
        return shipsCoordinates;
    }

    private void addShip(Ship ship) {
        ships.add(ship);
    }

    void addShip(Coordinates c1, Coordinates c2, Coordinates c3, Coordinates c4) {
        shipsCoordinates.add(c1);
        shipsCoordinates.add(c2);
        shipsCoordinates.add(c3);
        shipsCoordinates.add(c4);
        addShip(shipyard.createShip(c1, c2, c3, c4));
    }

    void addShip(Coordinates c1, Coordinates c2, Coordinates c3) {
        shipsCoordinates.add(c1);
        shipsCoordinates.add(c2);
        shipsCoordinates.add(c3);
        addShip(shipyard.createShip(c1, c2, c3));
    }

    void addShip(Coordinates c1, Coordinates c2) {
        shipsCoordinates.add(c1);
        shipsCoordinates.add(c2);
        addShip(shipyard.createShip(c1, c2));
    }

    void addShip(Coordinates c1) {
        shipsCoordinates.add(c1);
        addShip(shipyard.createShip(c1));
    }

    boolean takeShotOnFleet(Coordinates coordinates) {
        for (Ship ship : ships) {
            if (ship.takeShotOnShip(coordinates)) return true;
        }
        return false;
    }

}
