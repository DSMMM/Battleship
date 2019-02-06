package com.dsmmm.battleships.client;

import com.dsmmm.battleships.client.io.Prefix;

import java.io.BufferedReader;
import java.io.IOException;

class ServerListener extends Thread {
    private final ClientTalkable chat;
    private final Gameable controller;
    private final BufferedReader bufferedReader;
    private final ClientInitializer clientInitializer;

    ServerListener(ClientTalkable chat, Gameable controller, BufferedReader bufferedReader, ClientInitializer clientInitializer) {
        this.chat = chat;
        this.controller = controller;
        this.bufferedReader = bufferedReader;
        this.clientInitializer = clientInitializer;
    }

    @Override
    public void run() {
        try {
            synchronized (this) {
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    wait(1);
                    Prefix type = Prefix.getType(line);
                    String decipheredLine = Prefix.decipher(line);
                    switch (type) {
                        case CHAT:
                            chat.appendText(decipheredLine + "\n");
                            break;
                        case MISS:
                            Printer.print(line);
                            controller.showMiss(decipheredLine);
                            break;
                        case HIT:
                            Printer.print(line);
                            controller.showHit(decipheredLine);
                            break;
                        case ENEMY_HIT:
                            Printer.print(line);
                            controller.showEnemyHit(decipheredLine);
                            break;
                        case ENEMY_MISS:
                            Printer.print(line);
                            controller.showEnemyMiss(decipheredLine);
                            break;
                        case SHIPS:
                            controller.showFleet(decipheredLine);
                            break;
                        case SHOOT:
                            controller.nowaMetoda(decipheredLine);
                            break;
                        default:
                            Printer.print(line);
                            break;
                    }
                }
            }
        } catch (IOException e) {
            Printer.print("Kuniec, użytkownik wyszedł");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            Printer.print("Zatrzymano wątek " + Thread.currentThread().getName());
        }
    }

    void closeSocket() {
        clientInitializer.closeSocket();
    }
}
