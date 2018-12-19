package com.dsmmm.battleships.server.fleet;

import com.dsmmm.battleships.server.board.Board;
import com.dsmmm.battleships.server.board.Coordinates;
import com.dsmmm.battleships.server.board.Dimension;
import com.dsmmm.battleships.server.board.Side;

import java.util.*;

class Randomizer {

    private static final int NUMBER_OF_4_MAST_SHIPS = 1;
    private static final int NUMBER_OF_3_MAST_SHIPS = 2;
    private static final int NUMBER_OF_2_MAST_SHIPS = 3;
    private static final int NUMBER_OF_1_MAST_SHIPS = 4;
    private final Fleet fleet = new Fleet();
    private final Set<Coordinates> possibleCoordinates = new Board().getAllPossibleCoordinates();
    private final Dimension dimension = new Dimension();

    Fleet generateRandomFleet() {
        setRandom4Masts();
        setRandom3Masts();
        setRandom2Masts();
        setRandom1Masts();
        return fleet;
    }

    private void setRandom4Masts() {
        for (int count = 1; count <= NUMBER_OF_4_MAST_SHIPS; count++) {
            Set<Coordinates> set = setRandom(4);
            Iterator<Coordinates> iterator = set.iterator();
            fleet.addShip(iterator.next(), iterator.next(), iterator.next(), iterator.next());
        }
    }

    private void setRandom3Masts() {
        for (int count = 1; count <= NUMBER_OF_3_MAST_SHIPS; count++) {
            Set<Coordinates> set = setRandom(3);
            Iterator<Coordinates> iterator = set.iterator();
            fleet.addShip(iterator.next(), iterator.next(), iterator.next());
        }
    }

    private void setRandom2Masts() {
        for (int count = 1; count <= NUMBER_OF_2_MAST_SHIPS; count++) {
            Set<Coordinates> set = setRandom(2);
            Iterator<Coordinates> iterator = set.iterator();
            fleet.addShip(iterator.next(), iterator.next());
        }
    }

    private void setRandom1Masts() {
        for (int count = 1; count <= NUMBER_OF_1_MAST_SHIPS; count++) {
            Set<Coordinates> set = setRandom(1);
            Iterator<Coordinates> iterator = set.iterator();
            fleet.addShip(iterator.next());
        }
    }

    private Set<Coordinates> setRandom(int masts) {
        Set<Coordinates> coordinatesToBuildShip = new HashSet<>();
        Coordinates lastAdded = getRandomPossibleCoordinates(possibleCoordinates);
        coordinatesToBuildShip.add(lastAdded);
        for (int i = 1; i < masts; i++) {
            Coordinates toAdd = getRandomPossibleCoordinates(getAdjacent(lastAdded));
            coordinatesToBuildShip.add(toAdd);
            lastAdded = toAdd;
        }
        for (Coordinates c : coordinatesToBuildShip) {
            removeNeighbours(c);
        }
        return coordinatesToBuildShip;
    }

    private Coordinates getRandomPossibleCoordinates(Set<Coordinates> possibles) {
        List<Coordinates> list = new ArrayList<>(possibles);
        Collections.shuffle(list);
        possibleCoordinates.remove(list.get(0));
        return list.get(0);
    }

    private void removeNeighbours(Coordinates coordinates) {
        for (Coordinates c : getNeighbours(coordinates)) {
            possibleCoordinates.remove(c);
        }
    }

    private Set<Coordinates> getAdjacent(Coordinates coordinates) {
        Set<Coordinates> result = new HashSet<>();
        for (Side side : Arrays.asList(Side.RIGHT, Side.UP, Side.LEFT, Side.DOWN)) {
            addCoordinatesToSet(side, coordinates, result);
        }
        return result;
    }

    private Set<Coordinates> getNeighbours(Coordinates coordinates) {
        Set<Coordinates> result = new HashSet<>();
        for (Side side : Side.values()) {
            addCoordinatesToSet(side, coordinates, result);
        }
        return result;
    }

    private void addCoordinatesToSet(Side side, Coordinates coordinates, Set<Coordinates> result) {
        if (coordinates.checkIfNeighbourInRange(side, dimension)) {
            Coordinates c = coordinates.getNeighbour(side, dimension);
            if (possibleCoordinates.contains(c)) {
                result.add(coordinates.getNeighbour(side, dimension));
            }
        }
    }
}