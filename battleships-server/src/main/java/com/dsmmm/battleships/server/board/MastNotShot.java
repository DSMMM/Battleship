package com.dsmmm.battleships.server.board;

class MastNotShot implements Field, Mast {
    @Override
    public boolean equals(Object obj) {
        return getClass()==obj.getClass();
    }

    @Override
    public MastShot transform() {
        return new MastShot();
    }
}
