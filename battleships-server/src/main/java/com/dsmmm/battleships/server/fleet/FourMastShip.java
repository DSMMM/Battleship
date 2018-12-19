package com.dsmmm.battleships.server.fleet;

import com.dsmmm.battleships.server.board.Coordinates;
import com.dsmmm.battleships.server.board.Mast;

import java.util.HashMap;
import java.util.Map;


class FourMastShip implements Ship {

    private Map<Coordinates, Mast> mapOfMasts;

    FourMastShip(Coordinates c1, Coordinates c2, Coordinates c3, Coordinates c4) {
        mapOfMasts = new HashMap<>();
        mapOfMasts = putMastsToShip(mapOfMasts, c1, c2, c3, c4);
    }

    @Override
    public int countStandingMasts() {
        return countStandingMasts(mapOfMasts);
    }

    @Override
    public boolean takeShotOnShip(Coordinates coordinates) {
        return takeShotOnShip(coordinates, mapOfMasts);
    }

    public boolean checkIfShipContainsCoordinates(Coordinates coordinates) {
        return checkIfShipContainsCoordinates(coordinates, mapOfMasts);
    }
}
