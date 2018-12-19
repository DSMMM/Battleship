package com.dsmmm.battleships.server;

import com.dsmmm.battleships.server.io.Prefix;
import com.dsmmm.battleships.server.io.Printer;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

class ServerInitializer {
    @SuppressWarnings("InfiniteLoopStatement")
    void initializeServer() {
        try (ServerSocket serverSocket = new ServerSocket(8189)) {
            while (true) {
                Socket host = createSocketForHost(serverSocket);

                Socket guest = createSocketForGuest(serverSocket);

                initializeChatThread(host, guest);
                initializeChatThread(guest, host);
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
        outHost.println(Prefix.CHAT.cipher( "Connection established. Please wait for second user."));
        return host;
    }

    private void initializeChatThread(Socket home, Socket away) {
        Runnable r = new ThreadedEchoHandler(home, away);
        Thread t = new Thread(r);
        t.start();
    }
}
