package com.dsmmm.battleships.server.fleet;

import com.dsmmm.battleships.server.board.Coordinates;

import java.util.HashSet;
import java.util.Set;

public class Fleet {

    private final Set<Ship> ships = new HashSet<>();
    private final Set<Coordinates> shipsCoordinates = new HashSet<>();

    public Set<Coordinates> getShipsCoordinates() {
        return shipsCoordinates;
    }

    private void addShip(Ship ship) {
        ships.add(ship);
    }

    void addShip(Set<Coordinates> c) {
        addShip(Shipyard.createShip(c));
        shipsCoordinates.addAll(c);
    }

    boolean takeShotOnFleet(Coordinates coordinates) {
        for (Ship ship : ships) {
            if (ship.takeShotOnShip(coordinates)) return true;
        }
        return false;
    }

}
