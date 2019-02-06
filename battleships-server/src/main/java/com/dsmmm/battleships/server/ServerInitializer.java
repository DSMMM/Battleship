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
    private final Printer printer = new Printer(this.getClass());

    ServerInitializer() {
        threadPool = Executors. newCachedThreadPool(new ClientThreadsFactory());
    }

    @SuppressWarnings("InfiniteLoopStatement")
    void initializeServer() {
        try (ServerSocket serverSocket = new ServerSocket(8189)) {
            if (serverSocket.isBound())
                printer.printInfo("Server initialized.");

            while (true) {
                Socket host = createSocketForHost(serverSocket);
                Socket guest = createSocketForGuest(serverSocket);

                printer.printInfo("Połączono: " + host.getRemoteSocketAddress() + " i " + guest.getRemoteSocketAddress());

                initializeClientThread(host, guest);
                initializeClientThread(guest, host);
            }
        } catch (IOException e) {
            printer.printError(e.getMessage());
        }

    }

    private Socket createSocketForGuest(ServerSocket serverSocket) throws IOException {
        Socket guest = serverSocket.accept();
        printer.printInfo("Two users connected. Chatroom initialized.");
        return guest;
    }

    private Socket createSocketForHost(ServerSocket serverSocket) throws IOException {
        Socket host = serverSocket.accept();
        printer.printInfo("First user has joined.");

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
