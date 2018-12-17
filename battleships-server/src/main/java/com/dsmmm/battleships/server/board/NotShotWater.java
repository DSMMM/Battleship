package com.dsmmm.battleships.server.board;

class NotShotWater implements Field, Water {
    @Override
    public boolean equals(Object obj) {
        return obj != null && getClass() == obj.getClass();
    }

    @Override
    public ShotWater transform() {
        return new ShotWater();
    }
}
