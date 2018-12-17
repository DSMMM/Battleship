package com.dsmmm.battleships.server.board;

class MastShot implements Mast, Field {

    @Override
    public boolean equals(Object obj) {
        return getClass()==obj.getClass();
    }

    @Override
    public MastShot transform() {
        return this;
    }
}
