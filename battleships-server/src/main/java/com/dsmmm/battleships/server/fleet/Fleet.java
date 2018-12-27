package com.dsmmm.battleships.server.fleet;

import com.dsmmm.battleships.server.board.Coordinates;

import java.util.*;

public class Fleet{

    private final Set<Ship> ships = new HashSet<>();
    private final Shipyard shipyard = new Shipyard();
    private Set<Coordinates> shipsCoordinates = new HashSet<>();

    public Set<Coordinates> getShipsCoordinates() {
        // return ships.stream().map(Ship::getMastsCoordinates).flatMap(Collection::stream).collect(Collectors.toSet());
        return shipsCoordinates;
    }

    private void addShip(Ship ship) {
        ships.add(ship);
    }

    void addShip(Coordinates... c) {
        addShip(shipyard.createShip(c));
        shipsCoordinates.addAll(Arrays.asList(c));
    }

    boolean takeShotOnFleet(Coordinates coordinates) {
        for (Ship ship : ships) {
            if (ship.takeShotOnShip(coordinates)) return true;
        }
        return false;
    }

}
