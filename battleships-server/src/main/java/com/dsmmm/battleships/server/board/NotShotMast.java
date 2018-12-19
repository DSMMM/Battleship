package com.dsmmm.battleships.server.board;

public class NotShotMast implements Mast {
    @Override
    public boolean equals(Object obj) {
        return obj != null && getClass() == obj.getClass();
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public Mast transform() {
        return new ShotMast();
    }
}
