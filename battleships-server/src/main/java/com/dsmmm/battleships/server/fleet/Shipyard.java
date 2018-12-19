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

    private Coordinates getRandomPossibleCoordinates(Set<Coordinates> possibles) {
        List<Coordinates> list = new ArrayList<>(possibles);
        Collections.shuffle(list);
        possibleCoordinates.remove(list.get(0));
        return list.get(0);
    }

    private Set<Coordinates> getNeighbours(Coordinates coordinates) {
        Set<Coordinates> result = new HashSet<>();
        addCoordinateToSet(Side.RIGHT, coordinates, result);
        addCoordinateToSet(Side.UP, coordinates, result);
        addCoordinateToSet(Side.LEFT, coordinates, result);
        addCoordinateToSet(Side.DOWN, coordinates, result);
        return result;
    }

    private Set<Coordinates> getAllNeighbours(Coordinates coordinates) {
        Set<Coordinates> result = new HashSet<>();
        addCoordinateToSet(Side.RIGHT, coordinates, result);
        addCoordinateToSet(Side.UP, coordinates, result);
        addCoordinateToSet(Side.LEFT, coordinates, result);
        addCoordinateToSet(Side.DOWN, coordinates, result);
        addCoordinateToSet(Side.UP_LEFT, coordinates, result);
        addCoordinateToSet(Side.UP_RIGHT, coordinates, result);
        addCoordinateToSet(Side.DOWN_LEFT, coordinates, result);
        addCoordinateToSet(Side.DOWN_RIGHT, coordinates, result);
        return result;
    }

    private void addCoordinateToSet(Side side, Coordinates coordinates, Set<Coordinates> result) {
        if(coordinates.checkIfNeighbourInRange(side, dimension)) {
            Coordinates c = coordinates.getNeighbour(side, dimension);
            if (possibleCoordinates.contains(c)) {
                result.add(coordinates.getNeighbour(side, dimension));
            }
        }
    }

    public void setRandom4Mast() {
        Coordinates c1 = getRandomPossibleCoordinates(possibleCoordinates);
        Coordinates c2 = getRandomPossibleCoordinates(getNeighbours(c1));
        Coordinates c3 = getRandomPossibleCoordinates(getNeighbours(c2));
        Coordinates c4 = getRandomPossibleCoordinates(getNeighbours(c3));
        for(Coordinates c: getAllNeighbours(c1)) {
            possibleCoordinates.remove(c);
        }
        for(Coordinates c: getAllNeighbours(c2)) {
            possibleCoordinates.remove(c);
        }
        for(Coordinates c: getAllNeighbours(c3)) {
            possibleCoordinates.remove(c);
        }
        for(Coordinates c: getAllNeighbours(c4)) {
            possibleCoordinates.remove(c);
        }


        System.out.println(c1 +" " + c2 + c3 + c4);
    }

    public void setRandom3Mast() {
        Coordinates c1 = getRandomPossibleCoordinates(possibleCoordinates);
        Coordinates c2 = getRandomPossibleCoordinates(getNeighbours(c1));
        Coordinates c3 = getRandomPossibleCoordinates(getNeighbours(c2));

        for(Coordinates c: getAllNeighbours(c1)) {
            possibleCoordinates.remove(c);
        }
        for(Coordinates c: getAllNeighbours(c2)) {
            possibleCoordinates.remove(c);
        }
        for(Coordinates c: getAllNeighbours(c3)) {
            possibleCoordinates.remove(c);
        }



        System.out.println(c1 +" " + c2 + c3);
    }

    public void setRandom2Mast() {
        Coordinates c1 = getRandomPossibleCoordinates(possibleCoordinates);
        Coordinates c2 = getRandomPossibleCoordinates(getNeighbours(c1));

        for(Coordinates c: getAllNeighbours(c1)) {
            possibleCoordinates.remove(c);
        }
        for(Coordinates c: getAllNeighbours(c2)) {
            possibleCoordinates.remove(c);
        }




        System.out.println(c1 +" " + c2 );
    }

    public void setRandom1Mast() {
        Coordinates c1 = getRandomPossibleCoordinates(possibleCoordinates);

        for(Coordinates c: getAllNeighbours(c1)) {
            possibleCoordinates.remove(c);
        }





        System.out.println(c1 +" ");
    }

    public static void main(String[] args) {
        Shipyard shipyard = new Shipyard();
        shipyard.setRandom4Mast();
        shipyard.setRandom3Mast();
        shipyard.setRandom3Mast();
        shipyard.setRandom2Mast();
        shipyard.setRandom2Mast();
        shipyard.setRandom2Mast();
        shipyard.setRandom1Mast();
        shipyard.setRandom1Mast();
        shipyard.setRandom1Mast();
        shipyard.setRandom1Mast();

    }





}

