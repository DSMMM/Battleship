package com.dsmmm.battleships.server.fleet;

import com.dsmmm.battleships.server.board.Coordinates;

import java.util.HashSet;
import java.util.Set;

class Fleet {

    private final Set<Ship> ships = new HashSet<>();
    private final Shipyard shipyard = new Shipyard();

    private void addShip(Ship ship) {
        ships.add(ship);
    }

    void addShip(Coordinates c1, Coordinates c2, Coordinates c3, Coordinates c4) {
        addShip(shipyard.createShip(c1, c2, c3, c4));
    }

    void addShip(Coordinates c1, Coordinates c2, Coordinates c3) {
        addShip(shipyard.createShip(c1, c2, c3));
    }

    void addShip(Coordinates c1, Coordinates c2) {
        addShip(shipyard.createShip(c1, c2));
    }

    void addShip(Coordinates c1) {
        addShip(shipyard.createShip(c1));
    }


    boolean takeShotOnFleet(Coordinates coordinates) {
        for (Ship ship : ships) {
            if (ship.takeShotOnShip(coordinates)) return true;
        }
        return false;
    }
}
