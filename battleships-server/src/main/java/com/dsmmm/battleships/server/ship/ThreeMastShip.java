package com.dsmmm.battleships.server.ship;

import com.dsmmm.battleships.server.board.Coordinates;

public class ThreeMastShip implements Ship {
    public ThreeMastShip(Coordinates c1, Coordinates c2, Coordinates c3) {

    }

    @Override
    public int countStandingMasts() {
        return 3;
    }
}
