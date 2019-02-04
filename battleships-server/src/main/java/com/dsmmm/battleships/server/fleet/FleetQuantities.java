package com.dsmmm.battleships.server.fleet;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.BiConsumer;


class FleetQuantities implements Iterable<Map.Entry<Integer, Integer>> {

    private static final int FOUR_MAST_SHIP = 4;
    private static final int THREE_MAST_SHIP = 3;
    private static final int TWO_MAST_SHIP = 2;
    private static final int ONE_MAST_SHIP = 1;
    private final TreeMap<Integer, Integer> fleetQuantitiesMap;


    FleetQuantities() {
        fleetQuantitiesMap = fillMap();

    }

    private TreeMap<Integer, Integer> fillMap() {
        TreeMap<Integer, Integer> fleetQuantitiesMapTemp;
        fleetQuantitiesMapTemp = new TreeMap<>();
        int numberOf4MastShips = 1;
        fleetQuantitiesMapTemp.put(FOUR_MAST_SHIP, numberOf4MastShips);
        int numberOf3MastShips = 2;
        fleetQuantitiesMapTemp.put(THREE_MAST_SHIP, numberOf3MastShips);
        int numberOf2MastShips = 3;
        fleetQuantitiesMapTemp.put(TWO_MAST_SHIP, numberOf2MastShips);
        int numberOf1MastShips = 4;
        fleetQuantitiesMapTemp.put(ONE_MAST_SHIP, numberOf1MastShips);
        return fleetQuantitiesMapTemp;
    }


    @Override
    public Iterator<Map.Entry<Integer, Integer>> iterator() {
        return fleetQuantitiesMap.descendingMap().entrySet().iterator();
    }


    void forEach(BiConsumer<Integer, Integer> action) {
        Iterator<Map.Entry<Integer, Integer>> iterator = this.iterator();

        do {
            Map.Entry<Integer, Integer> next = iterator.next();
            action.accept(next.getKey(), next.getValue());

        } while (iterator.hasNext());
    }
}
