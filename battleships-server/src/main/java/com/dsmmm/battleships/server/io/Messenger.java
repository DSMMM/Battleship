package com.dsmmm.battleships.server.io;

import java.io.PrintWriter;

public class Messenger {
    private final PrintWriter homeOut;
    private final PrintWriter awayOut;

    public Messenger(PrintWriter homeOut, PrintWriter awayOut) {
        this.homeOut = homeOut;
        this.awayOut = awayOut;
    }

    public void sendToFirstPlayerChat(String message) {
        homeOut.println(Prefix.CHAT.cipher(message));
    }

    public static void sendMessage(PrintWriter out,String message){
        out.println(Prefix.CHAT.cipher(message));
    }

    public void sendToBothPlayersChat(String message) {
        awayOut.println(Prefix.CHAT.cipher(message));
        awayOut.println(Prefix.CHAT.cipher(message));
    }

    public void redirectMessage(PrintWriter homeOut, PrintWriter awayOut, String line) {
        Prefix type = Prefix.getType(line);

        switch (type) {
            case CHAT:
                homeOut.println(line);
                awayOut.println(line);
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
