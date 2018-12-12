package com.dsmmm.battleships.client;

import javafx.scene.control.TextArea;

import java.io.*;
import java.net.*;

public class ClientInitializer {

    private final String name;
    private PrintWriter out;
    private BufferedReader in;

    public ClientInitializer(String name) {
        this.name = name;
        try {
                //TODO: zapisywanie konfiguracji serwera w pliku konfiguracyjnym
                Socket echoSocket = new Socket("vps624409.ovh.net", 8189);
                out =
                        new PrintWriter(echoSocket.getOutputStream(), true);
                in =
                        new BufferedReader(
                                new InputStreamReader(echoSocket.getInputStream()));

        } catch (IOException e) {
            Printer.print(e.getMessage());
        }

    }

    void sendMessage(String userInput) {
        out.println(name + " " + userInput);
    }

    void listenToServer(TextArea chatId) {
        Thread t = new Thread(() -> {
            try {
                String line;
                while ((line = in.readLine()) != null) {
                    chatId.appendText(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        t.start();
    }
}
