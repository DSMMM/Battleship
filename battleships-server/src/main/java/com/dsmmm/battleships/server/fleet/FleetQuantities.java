package com.dsmmm.battleships.server.fleet;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.BiConsumer;

class FleetQuantities implements Iterable<Map.Entry<Integer, Integer>> {

    private static final TreeMap<Integer, Integer> FLEET_QUANTITIES = new TreeMap<>();
    private static final int NUMBER_OF_4_MAST_SHIPS = 1;
    private static final int NUMBER_OF_3_MAST_SHIPS = 2;
    private static final int NUMBER_OF_2_MAST_SHIPS = 3;
    private static final int NUMBER_OF_1_MAST_SHIPS = 4;


    FleetQuantities() {
        FLEET_QUANTITIES.put(4, NUMBER_OF_4_MAST_SHIPS);
        FLEET_QUANTITIES.put(3, NUMBER_OF_3_MAST_SHIPS);
        FLEET_QUANTITIES.put(2, NUMBER_OF_2_MAST_SHIPS);
        FLEET_QUANTITIES.put(1, NUMBER_OF_1_MAST_SHIPS);

    }


    @Override
    public Iterator<Map.Entry<Integer, Integer>> iterator() {
        return FLEET_QUANTITIES.descendingMap().entrySet().iterator();
    }


    void forEach(BiConsumer<Integer, Integer> action) {
        Iterator<Map.Entry<Integer, Integer>> iterator = this.iterator();

        do {
            Map.Entry<Integer, Integer> next = iterator.next();
            action.accept(next.getKey(), next.getValue());

        } while (iterator.hasNext());
    }
}
