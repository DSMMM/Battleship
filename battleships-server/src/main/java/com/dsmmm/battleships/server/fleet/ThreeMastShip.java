package com.dsmmm.battleships.server.fleet;

import com.dsmmm.battleships.server.board.Coordinates;
import com.dsmmm.battleships.server.board.Mast;

import java.util.HashMap;
import java.util.Map;

class ThreeMastShip implements Ship {
    private Map<Coordinates, Mast> mapOfMasts;

    ThreeMastShip(Coordinates... c) {
        assert c.length == 3;
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
