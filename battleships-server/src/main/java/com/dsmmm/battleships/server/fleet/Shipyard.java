package com.dsmmm.battleships.server.fleet;

import com.dsmmm.battleships.server.board.Coordinates;

class Shipyard {

    Ship createShip(Coordinates c1, Coordinates c2, Coordinates c3, Coordinates c4) {
        return new FourMastShip(c1, c2, c3, c4);
    }

    Ship createShip(Coordinates c1, Coordinates c2, Coordinates c3) {
        return new ThreeMastShip(c1, c2, c3);
    }

    Ship createShip(Coordinates c1, Coordinates c2) {
        return new TwoMastShip(c1, c2);
    }

    Ship createShip(Coordinates c1) {
        return new OneMastShip(c1);
    }



}

