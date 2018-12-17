package com.dsmmm.battleships.server.board;

class ShotWater implements Water, Field {

    @Override
    public boolean equals(Object obj) {
        return obj != null && getClass() == obj.getClass();
    }

    @Override
    public ShotWater transform() {
        return this;
    }
}
