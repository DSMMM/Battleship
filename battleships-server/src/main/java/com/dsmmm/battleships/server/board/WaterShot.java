package com.dsmmm.battleships.server.board;

class WaterShot implements Water, Field {

    @Override
    public boolean equals(Object obj) {
        return getClass()==obj.getClass();
    }

    @Override
    public WaterShot transform() {
        return this;
    }
}
