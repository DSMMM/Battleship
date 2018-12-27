package com.dsmmm.battleships.server.fleet;

import com.dsmmm.battleships.server.board.Coordinates;

class Shipyard {

    Ship createShip(Coordinates... c) {
        switch (c.length) {
            case 4:
                return new FourMastShip(c);
            case 3:
                return new ThreeMastShip(c);
            case 2:
                return new TwoMastShip(c);
            default:
                return new OneMastShip(c[0]);
        }
    }

}

