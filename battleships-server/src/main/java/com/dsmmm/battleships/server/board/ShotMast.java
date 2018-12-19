package com.dsmmm.battleships.server.board;

class ShotMast implements Mast{

    @Override
    public boolean equals(Object obj) {
        return obj != null && getClass()==obj.getClass();
    }

    @Override
    public Field destroy() {
        return this;
    }
}
