package com.dsmmm.battleships.server;

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
                Socket firstUser = serverSocket.accept();
                Printer.print("First user has joined.");
                OutputStream outStream = firstUser.getOutputStream();
                PrintWriter out = new PrintWriter(
                    new OutputStreamWriter(outStream, StandardCharsets.UTF_8), true);
                out.println(Prefix.CHAT.cipher( "Connection established. Please wait for second user."));
                Socket secondUser = serverSocket.accept();
                Printer.print("Two users connected. Chatroom initialized.");
                initializeChatThread(firstUser, secondUser);
                initializeChatThread(secondUser, firstUser);
            }
        } catch (IOException e) {
            Printer.print(e.getMessage());
        }

    }

    private void initializeChatThread(Socket home, Socket away) {
        Runnable r = new ThreadedEchoHandler(home, away);
        Thread t = new Thread(r);
        t.start();
    }
}
