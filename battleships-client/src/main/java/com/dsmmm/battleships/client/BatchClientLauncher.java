package com.dsmmm.battleships.client;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class BatchClientLauncher {
    private final ExecutorService threadPool;
    private final int numberOfClients;

    BatchClientLauncher(int numberOfClients) {
        this.numberOfClients = numberOfClients;
        threadPool = Executors.newCachedThreadPool(new ClientThreadFactory());
    }

    void startClients() {
        for (int i = 0; i < numberOfClients; i++) {
            launchConsoleClient(i);
        }
    }

    private void launchConsoleClient(int i) {
        ClientInitializer client = new ClientInitializer("test");
        client.connectWithServer();
        threadPool.submit(client.makeListenerThread(new ConsoleChat(), new ConsoleController()));
        Printer.print("Client " + i);
        client.requestGenerateFleet();
    }
}

