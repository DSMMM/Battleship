package com.dsmmm.battleships.server.fleet;

import com.dsmmm.battleships.server.board.Coordinates;

import java.util.*;

public class Fleet{

    private final Set<Ship> ships = new HashSet<>();
    private final Shipyard shipyard = new Shipyard();
    private final Set<Coordinates> shipsCoordinates = new HashSet<>();

    public Set<Coordinates> getShipsCoordinates() {
        return shipsCoordinates;
    }

    private void addShip(Ship ship) {
        ships.add(ship);
    }

    void addShip(Set<Coordinates> c) {
        addShip(shipyard.createShip(c.toArray(new Coordinates[0])));
        shipsCoordinates.addAll(c);
    }

    boolean takeShotOnFleet(Coordinates coordinates) {
        for (Ship ship : ships) {
            if (ship.takeShotOnShip(coordinates)) return true;
        }
        return false;
    }

}
