package com.dsmmm.battleships.server.ship;

import com.dsmmm.battleships.server.board.Coordinates;

public class FourMastShip implements Ship {
    public FourMastShip(Coordinates c1, Coordinates c2, Coordinates c3, Coordinates c4) {
    }

    @Override
    public int countStandingMasts() {
        return 4;
    }
}
