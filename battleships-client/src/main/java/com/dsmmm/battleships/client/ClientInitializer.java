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
    private BufferedReader in;

    ClientInitializer(String name) {
        this.name = name;
        try {
        Socket echoSocket = new Socket("vps624409.ovh.net", 8189);
            //TODO: zapisywanie konfiguracji serwera w pliku konfiguracyjnym
            out = new PrintWriter(echoSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
        } catch (IOException e) {
            Printer.print(e.getMessage());
        }
    }

    void sendMessage(String userInput) {
        out.println(Prefix.CHAT.cipher(name + ": " + userInput));
    }

    void requestGenerateFleet() {
        out.println(Prefix.GENERATE.toString());
    }

    void sendCoordinates(int x, int y) {
        out.println(Prefix.SHOOT.cipher(x + " " + y));
    }

    void listenToServer(TextArea chatId, Controller controller) {
        Thread t = new Thread(() -> {
            try {
                String line;
                while ((line = in.readLine()) != null) {
                    Prefix type = Prefix.getType(line);
                    String decipheredLine = Prefix.decipher(line);
                    switch (type) {
                        case CHAT:
                            chatId.appendText(decipheredLine + "\n");
                            break;
                        case HIT:
                            Printer.print(line);
                            break;
                        case SHIPS:
                            controller.showFleet(decipheredLine);
                            break;
                        default:
                            Printer.print(line);
                            break;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        t.start();
    }
}
