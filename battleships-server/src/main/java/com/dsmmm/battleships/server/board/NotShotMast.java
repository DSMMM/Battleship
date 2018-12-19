package com.dsmmm.battleships.server.board;

class NotShotMast implements Mast {
    @Override
    public boolean equals(Object obj) {
        return obj != null && getClass()==obj.getClass();
    }

    @Override
    public Field destroy() {
        return new ShotMast();
    }
}
