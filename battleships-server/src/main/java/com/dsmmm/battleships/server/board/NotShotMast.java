package com.dsmmm.battleships.server.board;

public class NotShotMast implements Mast {
    @Override
    public boolean equals(Object obj) {
        return obj != null && getClass()==obj.getClass();
    }

    @Override
    public Field transform() {
        return new ShotMast();
    }
}
