package com.dsmmm.battleships.server.fleet;

import com.dsmmm.battleships.server.board.Board;
import com.dsmmm.battleships.server.board.Coordinates;
import com.dsmmm.battleships.server.board.Dimension;
import com.dsmmm.battleships.server.board.Side;

import java.util.*;

public class Randomizer {

    private Fleet fleet = new Fleet();
    private Set<Coordinates> possibleCoordinates = new Board().getAllPossibleCoordinates();
    private Dimension dimension = new Dimension();

    public Fleet generateRandomFleet() {
        setRandom4Mast();
        setRandom3Mast();
        setRandom3Mast();
        setRandom2Mast();
        setRandom2Mast();
        setRandom2Mast();
        setRandom1Mast();
        setRandom1Mast();
        setRandom1Mast();
        setRandom1Mast();
        return fleet;
    }

    public void setRandom4Mast() {
        Set<Coordinates> set = setRandom(4);
        Iterator<Coordinates> iterator = set.iterator();
        fleet.addShip(iterator.next(), iterator.next(), iterator.next(), iterator.next());
    }

    public void setRandom3Mast() {
        Set<Coordinates> set = setRandom(3);
        Iterator<Coordinates> iterator = set.iterator();
        fleet.addShip(iterator.next(), iterator.next(), iterator.next());
    }

    public void setRandom2Mast() {
        Set<Coordinates> set = setRandom(2);
        Iterator<Coordinates> iterator = set.iterator();
        fleet.addShip(iterator.next(), iterator.next());
    }

    public void setRandom1Mast() {
        Set<Coordinates> set = setRandom(1);
        Iterator<Coordinates> iterator = set.iterator();
        fleet.addShip(iterator.next());
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
        addCoordinatesToSet(Side.RIGHT, coordinates, result);
        addCoordinatesToSet(Side.UP, coordinates, result);
        addCoordinatesToSet(Side.LEFT, coordinates, result);
        addCoordinatesToSet(Side.DOWN, coordinates, result);
        return result;
    }

    private Set<Coordinates> getNeighbours(Coordinates coordinates) {
        Set<Coordinates> result = new HashSet<>();
        addCoordinatesToSet(Side.RIGHT, coordinates, result);
        addCoordinatesToSet(Side.UP, coordinates, result);
        addCoordinatesToSet(Side.LEFT, coordinates, result);
        addCoordinatesToSet(Side.DOWN, coordinates, result);
        addCoordinatesToSet(Side.UP_LEFT, coordinates, result);
        addCoordinatesToSet(Side.UP_RIGHT, coordinates, result);
        addCoordinatesToSet(Side.DOWN_LEFT, coordinates, result);
        addCoordinatesToSet(Side.DOWN_RIGHT, coordinates, result);
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

/*    public static void main(String[] args) {
        Randomizer randomizer = new Randomizer();
        randomizer.setRandom4Mast();
        randomizer.setRandom3Mast();
        randomizer.setRandom3Mast();
        randomizer.setRandom2Mast();
        randomizer.setRandom2Mast();
        randomizer.setRandom2Mast();
        randomizer.setRandom1Mast();
        randomizer.setRandom1Mast();
        randomizer.setRandom1Mast();
        randomizer.setRandom1Mast();
        randomizer.fleet.printFleet();
    }*/
}
