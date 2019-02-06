package com.dsmmm.battleships.client;

import com.dsmmm.battleships.client.io.Prefix;
import javafx.scene.control.TextArea;

import java.io.BufferedReader;
import java.io.IOException;

class ServerListener extends Thread {
    private final TextArea chatId;
    private final Controller controller;
    private final BufferedReader bufferedReader;
    private ClientInitializer clientInitializer;

    ServerListener(TextArea chatId, Controller controller, BufferedReader bufferedReader, ClientInitializer clientInitializer) {
        this.chatId = chatId;
        this.controller = controller;
        this.bufferedReader = bufferedReader;
        this.clientInitializer = clientInitializer;
    }

    @Override
    public void run() {
        synchronized (this) {
            try {
                String line;
                while ((line = bufferedReader.readLine())!=null) {
                    wait(1);
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
                Printer.print("Kuniec");
            } catch (InterruptedException e) {
                //TODO: do poprawy
                Thread.currentThread().interrupt();
                Printer.print("Zatrzymano wątek " + Thread.currentThread().getName());
            }
        }
    }

    void closeSocket() {
        clientInitializer.closeSocket();
    }
}
