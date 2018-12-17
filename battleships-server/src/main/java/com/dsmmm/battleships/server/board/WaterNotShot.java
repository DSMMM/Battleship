package com.dsmmm.battleships.server.board;

class WaterNotShot implements Field, Water {
    @Override
    public boolean equals(Object obj) {
        return getClass()==obj.getClass();
    }

    @Override
    public WaterShot transform() {
        return new WaterShot();
    }
}
