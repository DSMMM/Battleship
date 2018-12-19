package com.dsmmm.battleships.server.fleet;

import com.dsmmm.battleships.server.board.Board;
import com.dsmmm.battleships.server.board.Coordinates;
import com.dsmmm.battleships.server.board.Dimension;
import com.dsmmm.battleships.server.board.Side;



import java.util.*;
import java.util.List;

public class Shipyard {

    private Set<Coordinates> possibleCoordinates = new Board().getAllPossibleCoordinates();
    private Dimension dimension = new Dimension();
    //public Fleet fleet = new Fleet();

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

