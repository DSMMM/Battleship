package com.dsmmm.battleships.server.fleet;

import com.dsmmm.battleships.server.board.Coordinates;
import com.dsmmm.battleships.server.board.Mast;

import java.util.HashMap;
import java.util.Map;

class TwoMastShip implements Ship {

    private Map<Coordinates, Mast> mapOfMasts;

    TwoMastShip(Coordinates... c) {
        assert c.length == 2;
        mapOfMasts = new HashMap<>();
        mapOfMasts = putMastsToShip(mapOfMasts, c);
    }

    @Override
    public int countStandingMasts() {
        return countStandingMasts(mapOfMasts);
    }

    @Override
    public boolean takeShotOnShip(Coordinates coordinates) {
        return takeShotOnShip(coordinates, mapOfMasts);
    }

}

