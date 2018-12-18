package com.dsmmm.battleships.server.ship;

import com.dsmmm.battleships.server.board.Coordinates;
import com.dsmmm.battleships.server.board.Mast;
import com.dsmmm.battleships.server.board.NotShotMast;

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
        return (int) mapOfMasts.entrySet().stream().filter(s -> s.getValue() instanceof NotShotMast).count();
    }

    @Override
    public boolean checkIfShotOnShip(Coordinates c1) {
        return mapOfMasts.containsKey(c1) && mapOfMasts.get(c1).equals(new NotShotMast());
    }
}
