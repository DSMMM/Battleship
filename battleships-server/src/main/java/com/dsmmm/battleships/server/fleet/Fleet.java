package com.dsmmm.battleships.server.fleet;

import com.dsmmm.battleships.server.board.Coordinates;

import java.util.HashSet;
import java.util.Set;

public class Fleet {

    private Set<Ship> ships = new HashSet<>();
    private Shipyard shipyard = new Shipyard();

    public void addShip(Ship ship) {
        ships.add(ship);
    }

    public void addShip(Coordinates c1, Coordinates c2, Coordinates c3, Coordinates c4) {
        addShip(shipyard.createShip(c1,c2,c3,c4));
    }

    public void addShip(Coordinates c1, Coordinates c2, Coordinates c3) {
        addShip(shipyard.createShip(c1,c2,c3));
    }

    public void addShip(Coordinates c1, Coordinates c2) {
        addShip(shipyard.createShip(c1,c2));
    }

    public void addShip(Coordinates c1) {
        addShip(shipyard.createShip(c1));
    }


    public boolean takeShotOnFleet(Coordinates coordinates) {
        for (Ship ship : ships) {
            if(ship.takeShotOnShip(coordinates)) return true;
        }
        return false;
    }

    public void printFleet() {
        for(int i = 1; i<=10; i++) {
            for(int j = 1; j<=10; j++) {
                Coordinates c = new Coordinates(i,j);
                boolean print = false;
                for(Ship s: ships) {
                    if(s.checkIfShipContainsCoordinates(c)) {
                        print = true;
                        break;
                    }
                }
                if(print) System.out.print(" X ");
                else System.out.print("   ");
            }
            System.out.println();
        }

    }


}
