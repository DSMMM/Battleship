package com.dsmmm.battleships.server.fleet;

import com.dsmmm.battleships.server.board.Coordinates;
import com.dsmmm.battleships.server.board.Dimension;
import com.dsmmm.battleships.server.board.Side;

import java.util.*;

public class Randomizer {


    private final Fleet fleet = new Fleet();
    private final Set<Coordinates> possibleCoordinates;
    private final Dimension dimension = new Dimension();
    private final FleetQuantities fleetQuantities = new FleetQuantities();


    public Randomizer() {
        possibleCoordinates = populatePossibleCoordinates();
    }

    private Set<Coordinates> populatePossibleCoordinates() {
        Set<Coordinates> coordinatesOnBoard = new HashSet<>();
        for (int column = 1; dimension.greaterThanOrEqual(column); column++) {
            for (int row = 1; dimension.greaterThanOrEqual(row); row++) {
                coordinatesOnBoard.add(new Coordinates(column, row));
            }
        }
        return coordinatesOnBoard;
    }

    public Fleet generateRandomFleet() {
        fleetQuantities.forEach(this::generateShip);
        return fleet;
    }

    private void generateShip(Integer masts, Integer shipsToGenerate) {
        for (int count = 1; count <= shipsToGenerate; count++) {
            fleet.addShip(prepareRandomizedShip(masts));
        }
    }

    private Set<Coordinates> prepareRandomizedShip(int masts) {
        Set<Coordinates> chosenCoordinates = new HashSet<>();
        Set<Coordinates> possibleCoordinatesForShip = new HashSet<>(this.possibleCoordinates);
        Coordinates lastAddedMast = randomizedField(possibleCoordinatesForShip);
        possibleCoordinatesForShip.remove(lastAddedMast);
        chosenCoordinates.add(lastAddedMast);
        for (int i = 1; i < masts; i++) {
            Set<Coordinates> possibles = allAdjacentFields(lastAddedMast, possibleCoordinatesForShip);
            if (possibles.isEmpty()) {
                return prepareRandomizedShip(masts);
            }
            Coordinates nextMast = randomizedField(possibles);
            possibleCoordinatesForShip.remove(nextMast);
            chosenCoordinates.add(nextMast);
            lastAddedMast = nextMast;
        }
        chosenCoordinates.forEach(this::updatePossibleCoordinatesOnBoard);
        return chosenCoordinates;
    }

    private Coordinates randomizedField(Set<Coordinates> possibles) {
        List<Coordinates> list = new ArrayList<>(possibles);
        Collections.shuffle(list);
        return list.get(0);
    }

    private void updatePossibleCoordinatesOnBoard(Coordinates coordinate) {
        possibleCoordinates.remove(coordinate);
        possibleCoordinates.removeAll(getNeighbours(coordinate));
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