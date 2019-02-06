package com.dsmmm.battleships.client;

class ConsoleChat implements ClientTalkable {
    @Override
    public void appendText(String message) {
        Printer.print(Thread.currentThread().getName() + ": " + message);
    }
}
