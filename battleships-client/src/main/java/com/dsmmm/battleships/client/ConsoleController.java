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
    public void showEnemyMiss(String toDecode) {

    }
}
