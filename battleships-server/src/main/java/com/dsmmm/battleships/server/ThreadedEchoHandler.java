package com.dsmmm.battleships.server;

import com.dsmmm.battleships.server.io.Messenger;
import com.dsmmm.battleships.server.io.Printer;

import java.io.*;
import java.net.Socket;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

class ThreadedEchoHandler implements Runnable {
    private static final Charset CHAT_CHARSET = StandardCharsets.UTF_8;
    private final Socket home;
    private final Socket away;

    private final Printer printer = new Printer(this.getClass());


    ThreadedEchoHandler(Socket home, Socket away) {
        this.home = home;
        this.away = away;
    }
    @Override
    public void run() {
        try (
            InputStream homeInputStream = home.getInputStream();
            OutputStream homeOutputStream = home.getOutputStream();
            OutputStream awayOutputStream = away.getOutputStream()) {

            Scanner scanner = new Scanner(homeInputStream, String.valueOf(CHAT_CHARSET));
            PrintWriter homeOut = getPrintWriter(homeOutputStream);
            PrintWriter awayOut = getPrintWriter(awayOutputStream);

            Messenger messenger = new Messenger(homeOut, awayOut);
            messenger.sendToFirstPlayerChat("Chat opened.");
            printer.printInfo(Thread.currentThread().getName() + " started.");
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                messenger.redirectMessage(homeOut, awayOut, line);
            }
            messenger.sendToBothPlayersChat("Your friend has left the chat! Status: disconnected");
            printer.printInfo("Chat disconnected");
        } catch (IOException e) {
            //HINT: true error handling might be more useful ;-) //TODO
            printer.printInfo(e.getMessage());
        }
    }


    private PrintWriter getPrintWriter(OutputStream outputStream) {
        return new PrintWriter(
            new OutputStreamWriter(outputStream, CHAT_CHARSET), true);
    }


}