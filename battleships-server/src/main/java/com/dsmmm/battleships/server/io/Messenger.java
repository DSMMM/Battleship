package com.dsmmm.battleships.server.io;

import java.io.PrintWriter;

public class Messenger {
    private PrintWriter homeOut;
    private PrintWriter awayOut;

    public Messenger(PrintWriter homeOut, PrintWriter awayOut) {
        this.homeOut = homeOut;
        this.awayOut = awayOut;
    }

    public void sendToFirstPlayerChat(String message) {
        homeOut.println(Prefix.CHAT.cipher(message));
    }

    public void sendToBothPlayersChat(String message) {
        awayOut.println(Prefix.CHAT.cipher(message));
        awayOut.println(Prefix.CHAT.cipher(message));
    }

    public void redirectMessage(PrintWriter out, PrintWriter out2, String line) {
        Prefix type = Prefix.getType(line);
        String decipheredLine = Prefix.decipher(line);
        switch (type) {
            case CHAT:
                out.println(line);
                out2.println(line);
                break;
            case SHOOT:
                Printer.print(line);
                break;
            case GENERATE:
                Printer.print(line);
//                homeOut.println(Prefix.SHIPS.cipher("tu dodac koordynaty statkow"));
                break;
            default:
                Printer.print(line);
                break;

        }
    }
}
