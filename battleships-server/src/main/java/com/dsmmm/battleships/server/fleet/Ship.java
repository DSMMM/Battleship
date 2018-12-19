package com.dsmmm.battleships.server.fleet;

import com.dsmmm.battleships.server.board.Coordinates;
import com.dsmmm.battleships.server.board.Mast;
import com.dsmmm.battleships.server.board.NotShotMast;

import java.util.Map;

interface Ship {

    int countStandingMasts();

    boolean takeShotOnShip(Coordinates coordinates);

    default Map<Coordinates, Mast> putMastsToShip(Map<Coordinates, Mast> givenMap, Coordinates... coordinates) {
        for (Coordinates c : coordinates) {
            givenMap.put(c, new NotShotMast());
        }
        return givenMap;
    }

    default int countStandingMasts(Map<Coordinates, Mast> mapOfMasts) {
        return (int) mapOfMasts.entrySet().stream().filter(s -> s.getValue() instanceof NotShotMast).count();
    }

    default boolean takeShotOnShip(Coordinates coordinates, Map<Coordinates, Mast> mapOfMasts) {
        if (checkIfShipContainsCoordinates(coordinates, mapOfMasts) && checkIfCoordinatesAreNotShot(coordinates, mapOfMasts)) {
            mapOfMasts.put(coordinates, mapOfMasts.get(coordinates).destroy());
            return true;
        }
        return false;
    }

    default boolean checkIfShipContainsCoordinates(Coordinates coordinates, Map<Coordinates, Mast> mapOfMasts) {
        return mapOfMasts.containsKey(coordinates);
    }

    default boolean checkIfCoordinatesAreNotShot(Coordinates coordinates, Map<Coordinates, Mast> mapOfMasts) {
        return mapOfMasts.get(coordinates).equals(new NotShotMast());
    }

}
