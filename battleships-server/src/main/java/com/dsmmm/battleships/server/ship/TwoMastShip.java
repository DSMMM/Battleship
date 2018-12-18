package com.dsmmm.battleships.server.ship;

import com.dsmmm.battleships.server.board.Coordinates;
import com.dsmmm.battleships.server.board.Mast;
import com.dsmmm.battleships.server.board.NotShotMast;

import java.util.HashMap;
import java.util.Map;

class TwoMastShip implements Ship {

    private Map<Coordinates, Mast> mapOfMasts;

    TwoMastShip(Coordinates c1, Coordinates c2) {
        mapOfMasts = new HashMap<>();
        mapOfMasts = putMastsToShip(mapOfMasts, c1, c2);

    }

    @Override
    public int countStandingMasts() {
        return (int) mapOfMasts.entrySet().stream().filter(s -> s.getValue() instanceof NotShotMast).count();
    }

    @Override
    public boolean checkIfShotOnShip(Coordinates c1) {
        return mapOfMasts.containsKey(c1) && mapOfMasts.get(c1).equals(new NotShotMast());
    }
}

