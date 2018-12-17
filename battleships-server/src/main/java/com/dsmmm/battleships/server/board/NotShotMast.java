package com.dsmmm.battleships.server.board;

class NotShotMast implements Field, Mast {
    @Override
    public boolean equals(Object obj) {
        return obj != null && getClass()==obj.getClass();
    }

    @Override
    public ShotMast transform() {
        return new ShotMast();
    }
}
