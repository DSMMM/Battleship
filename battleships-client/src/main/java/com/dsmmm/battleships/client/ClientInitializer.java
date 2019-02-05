package com.dsmmm.battleships.client;


import com.dsmmm.battleships.client.io.Prefix;
import javafx.scene.control.TextArea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class ClientInitializer {

    private final String name;
    private PrintWriter out;
    private BufferedReader bufferedReader;

    ClientInitializer(String name) {
        this.name = name;
    }

    boolean connectWithServer() {
        try {
            Socket echoSocket = new Socket("vps645601.ovh.net", 8189);
            //TODO: zapisywanie konfiguracji serwera w pliku konfiguracyjnym
            out = new PrintWriter(echoSocket.getOutputStream(), true);
            bufferedReader = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
        } catch (IOException e) {
            Printer.print("Nie udało się nawiązać połączenia z serwerem.");
            return false;
        }
        return true;
    }

    void sendMessage(String userInput) {
        out.println(Prefix.CHAT.cipher(name + ": " + userInput));
    }

    void requestGenerateFleet() {
        out.println(Prefix.GENERATE);
    }

    void sendCoordinates(int x, int y) {
        out.println(Prefix.SHOOT.cipher(x + " " + y));
    }

    void makeListenerThread(TextArea chatId, Controller controller) {
        Thread serverListener = new Thread(new ServerListener(chatId, controller, bufferedReader), "server listener");
        serverListener.start();
        ChatFX.setServerListener(serverListener);
    }
}
