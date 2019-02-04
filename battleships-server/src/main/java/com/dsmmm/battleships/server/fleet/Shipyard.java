package com.dsmmm.battleships.server.fleet;

import com.dsmmm.battleships.server.board.Coordinates;

import java.util.Set;

class Shipyard {

    private Shipyard() {
        //empty hidden constructor
    }

    static Ship createShip(Set<Coordinates> coordinatesSet) {
        Coordinates[] coordinatesArray = coordinatesSet.toArray(new Coordinates[0]);
        switch (coordinatesArray.length) {
            case 4:
                return new FourMastShip(coordinatesArray);
            case 3:
                return new ThreeMastShip(coordinatesArray);
            case 2:
                return new TwoMastShip(coordinatesArray);
            default:
                return new OneMastShip(coordinatesArray[0]);
        }
    }

}

