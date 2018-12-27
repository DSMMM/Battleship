package com.dsmmm.battleships.server.fleet;

import com.dsmmm.battleships.server.board.Coordinates;
import com.dsmmm.battleships.server.board.Dimension;
import com.dsmmm.battleships.server.board.Side;

import java.util.*;


public class Randomizer {

    private static final int NUMBER_OF_4_MAST_SHIPS = 1;
    private static final int NUMBER_OF_3_MAST_SHIPS = 2;
    private static final int NUMBER_OF_2_MAST_SHIPS = 3;
    private static final int NUMBER_OF_1_MAST_SHIPS = 4;
    private static final TreeMap<Integer, Integer> FLEET_QUANTITIES = new TreeMap<>();
    private final Fleet fleet = new Fleet();
    private final Set<Coordinates> possibleCoordinates;
    private final Dimension dimension = new Dimension();

    public Randomizer() {
        FLEET_QUANTITIES.put(4, NUMBER_OF_4_MAST_SHIPS);
        FLEET_QUANTITIES.put(3, NUMBER_OF_3_MAST_SHIPS);
        FLEET_QUANTITIES.put(2, NUMBER_OF_2_MAST_SHIPS);
        FLEET_QUANTITIES.put(1, NUMBER_OF_1_MAST_SHIPS);
        this.possibleCoordinates = new HashSet<>();
        for (int column = 1; column <= 10; column++) {
            for (int row = 1; row <= 10; row++) {
                possibleCoordinates.add(new Coordinates(column, row));
            }
        }

    }

    public Fleet generateRandomFleet() {
        FLEET_QUANTITIES.descendingMap().forEach(this::generateShip);
        return fleet;
    }

    private void generateShip(Integer masts, Integer shipsToGenerate) {
        for (int count = 1; count <= shipsToGenerate; count++) {
            Set<Coordinates> generatedMastsCoordinates = randomizedMasts(masts);
            fleet.addShip(generatedMastsCoordinates.toArray(new Coordinates[0]));
        }
    }

    private Set<Coordinates> randomizedMasts(int masts) {
        Set<Coordinates> coordinatesToBuildShip = new HashSet<>();
        Set<Coordinates> possibleCoordinatesForShip = new HashSet<>(this.possibleCoordinates);
        Coordinates lastAddedMast = randomizedField(possibleCoordinatesForShip, possibleCoordinatesForShip);
        coordinatesToBuildShip.add(lastAddedMast);
        for (int i = 1; i < masts; i++) {
            Set<Coordinates> possibles = allAdjacentFields(lastAddedMast, possibleCoordinatesForShip);
            if(possibles.isEmpty()) {
                return randomizedMasts(masts);
            }
            Coordinates nextMast = randomizedField(possibles, possibleCoordinatesForShip);
            coordinatesToBuildShip.add(nextMast);
            lastAddedMast = nextMast;
        }
        coordinatesToBuildShip.forEach(this::updatePossibleCoordinates);
        return coordinatesToBuildShip;
    }

    private Coordinates randomizedField(Set<Coordinates> possibles, Set<Coordinates> possibleCoordinatesForShip) {
        List<Coordinates> list = new ArrayList<>(possibles);
        Collections.shuffle(list);
        Coordinates randomizedField = list.get(0);
        possibleCoordinatesForShip.remove(randomizedField);
        return randomizedField;
    }

    private void updatePossibleCoordinates(Coordinates coordinates) {
        possibleCoordinates.remove(coordinates);
        possibleCoordinates.removeAll(getNeighbours(coordinates));
    }

    private Set<Coordinates> allAdjacentFields(Coordinates coordinates, Set<Coordinates> possibleCoordinatesForShip) {
        Set<Coordinates> result = new HashSet<>();
        for (Side side : Arrays.asList(Side.RIGHT, Side.UP, Side.LEFT, Side.DOWN)) {
            addCoordinatesToSet(side, coordinates, result, possibleCoordinatesForShip);
        }
        return result;
    }

    private Set<Coordinates> getNeighbours(Coordinates coordinates) {
        Set<Coordinates> result = new HashSet<>();
        for (Side side : Side.values()) {
            addCoordinatesToSet(side, coordinates, result, possibleCoordinates);
        }
        return result;
    }

    private void addCoordinatesToSet(Side side, Coordinates coordinates, Set<Coordinates> result, Set<Coordinates> possibleCoordinates) {
        if (coordinates.checkIfNeighbourInRange(side, dimension)) {
            Coordinates c = coordinates.getNeighbour(side, dimension);
            if (possibleCoordinates.contains(c)) {
                result.add(c);
            }
        }
    }
}