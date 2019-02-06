package com.dsmmm.battleships.client;

class ConsoleController implements Gameable {

    @Override
    public void showFleet(String toDecode) {
        Printer.print(Thread.currentThread().getName() + ": " + toDecode);
    }

    @Override
    public void showEnemyHit(String toDecode) {

    }

    @Override
    public void showHit(String decipheredLine) {

    }

    @Override
    public void showMiss(String decipheredLine) {

    }

    @Override
    public void nowaMetoda(String decipheredLine) {

    }

    @Override
    public void showEnemyMiss(String toDecode) {

    }
}
