package com.dsmmm.battleships.server.fleet;

import com.dsmmm.battleships.server.board.Coordinates;
import com.dsmmm.battleships.server.board.Mast;

import java.util.HashMap;
import java.util.Map;

class OneMastShip implements Ship {

    private Map<Coordinates, Mast> mapOfMasts;

    OneMastShip(Coordinates c1) {
        mapOfMasts = new HashMap<>();
        mapOfMasts = putMastsToShip(mapOfMasts, c1);

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
