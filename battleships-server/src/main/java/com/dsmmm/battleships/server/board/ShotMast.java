package com.dsmmm.battleships.server.board;

class ShotMast implements Mast, Field {

    @Override
    public boolean equals(Object obj) {
        return obj != null && getClass()==obj.getClass();
    }

    @Override
    public ShotMast transform() {
        return this;
    }
}
