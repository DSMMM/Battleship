package com.dsmmm.battleships.server.ship;

import com.dsmmm.battleships.server.board.Coordinates;
import com.dsmmm.battleships.server.board.Mast;
import com.dsmmm.battleships.server.board.NotShotMast;

import java.util.Map;

public interface Ship {
    int countStandingMasts();

    default Map<Coordinates, Mast> putMastsToShip(Map<Coordinates, Mast> givenMap, Coordinates... coordinates) {
        for (Coordinates c : coordinates) {
            givenMap.put(c, new NotShotMast());
        }
        return givenMap;
    }

    boolean checkIfShotOnShip(Coordinates c1);
}
