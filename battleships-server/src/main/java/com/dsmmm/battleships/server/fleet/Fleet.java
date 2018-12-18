package com.dsmmm.battleships.server.fleet;

import com.dsmmm.battleships.server.board.Coordinates;

import java.util.HashSet;
import java.util.Set;

public class Fleet {

    private Set<Ship> ships = new HashSet<>();

    public void addShip(Ship ship) {
        ships.add(ship);
    }

    public boolean takeShotOnFleet(Coordinates coordinates) {
        for (Ship ship : ships) {
            if(ship.takeShotOnShip(coordinates)) return true;
        }
        return false;
    }
}
