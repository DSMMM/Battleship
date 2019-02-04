package com.dsmmm.battleships.server;

import com.dsmmm.battleships.server.io.Messenger;
import com.dsmmm.battleships.server.io.Printer;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ServerInitializer {

    private final ExecutorService threadPool;

    ServerInitializer() {
        threadPool = Executors.newFixedThreadPool(2, new ClientThreadsFactory());
    }

    @SuppressWarnings("InfiniteLoopStatement")
    void initializeServer() {
        try (ServerSocket serverSocket = new ServerSocket(8189)) {
            if (serverSocket.isBound())
                Printer.print("Server initialized.");
            while (true) {
                Socket host = createSocketForHost(serverSocket);
                Socket guest = createSocketForGuest(serverSocket);

                initializeClientThread(host, guest);
                initializeClientThread(guest, host);
            }
        } catch (IOException e) {
            Printer.print(e.getMessage());
        }

    }

    private Socket createSocketForGuest(ServerSocket serverSocket) throws IOException {
        Socket guest = serverSocket.accept();
        Printer.print("Two users connected. Chatroom initialized.");
        return guest;
    }

    private Socket createSocketForHost(ServerSocket serverSocket) throws IOException {
        Socket host = serverSocket.accept();
        Printer.print("First user has joined.");

        OutputStream outStreamHost = host.getOutputStream();
        PrintWriter outHost = new PrintWriter(
            new OutputStreamWriter(outStreamHost, StandardCharsets.UTF_8), true);
        Messenger.sendMessage(outHost, "Connection established. Please wait for second user.");
        return host;
    }

    private void initializeClientThread(Socket home, Socket away) {
        threadPool.submit(new ThreadedEchoHandler(home, away));
    }
}
