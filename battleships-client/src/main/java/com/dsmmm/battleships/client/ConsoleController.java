package com.dsmmm.battleships.client;

class ConsoleController implements Gameable {

    @Override
    public void showFleet(String toDecode) {
        Printer.print(Thread.currentThread().getName() + ": " + toDecode);
    }
}
