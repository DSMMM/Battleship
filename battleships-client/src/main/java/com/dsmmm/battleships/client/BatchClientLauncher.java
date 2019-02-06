package com.dsmmm.battleships.client;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class BatchClientLauncher {
    private final ExecutorService threadPool;
    private final int numberOfClients;
    List<ClientInitializer> clientsList;

    BatchClientLauncher(int numberOfClients) {
        this.numberOfClients = numberOfClients;
        threadPool = Executors.newCachedThreadPool(new ClientThreadFactory());
        clientsList =  new ArrayList<>(numberOfClients);
    }

    void startClients() {
        for (int i = 0; i < numberOfClients; i++) {
            clientsList.add(launchConsoleClient(i));
        }
        clientsList.forEach(s->s.requestGenerateFleet());
      //  clientsList.forEach(s->s.closeSocket());
    }

    private ClientInitializer launchConsoleClient(int i) {
        ClientInitializer client = new ClientInitializer("test "+ i);
        client.connectWithServer();
        threadPool.submit(client.makeListenerThread(new ConsoleChat(), new ConsoleController()));
        Printer.print("Client " + i + " launched.");
        return client;
    }
}

