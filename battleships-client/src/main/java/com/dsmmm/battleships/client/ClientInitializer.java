package com.dsmmm.battleships.client;

import javafx.scene.control.TextArea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class ClientInitializer {

    private final String name;
    private PrintWriter out;
    private BufferedReader in;
    private Socket echoSocket;

    ClientInitializer(String name) {
        this.name = name;
        try {
            //TODO: zapisywanie konfiguracji serwera w pliku konfiguracyjnym
            echoSocket = new Socket("vps624409.ovh.net", 8189);
            out = new PrintWriter(echoSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
        } catch (IOException e) {
            Printer.print(e.getMessage());
        }
    }

    void sendMessage(String userInput) {
        out.println(name + ": " + userInput);
    }

    void listenToServer(TextArea chatId) {
        Thread t = new Thread(() -> {
            try {
                String line;
                while ((line = in.readLine()) != null) {
                    chatId.appendText(line + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        t.start();
    }
}
