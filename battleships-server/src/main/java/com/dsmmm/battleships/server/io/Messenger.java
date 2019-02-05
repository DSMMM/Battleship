package com.dsmmm.battleships.server.io;

import com.dsmmm.battleships.server.board.Board;

import java.io.PrintWriter;

/**
 * Sends messages to clients and redirects received messages
 */
public class Messenger {
    private final PrintWriter homeOut;
    private final PrintWriter awayOut;
    private Printer printer = new Printer(this.getClass());

    public Messenger(PrintWriter homeOut, PrintWriter awayOut) {
        this.homeOut = homeOut;
        this.awayOut = awayOut;
    }

    public static void sendMessage(PrintWriter out, String message) {
        out.println(Prefix.CHAT.cipher(message));
    }

    public void sendToFirstPlayerChat(String message) {
        homeOut.println(Prefix.CHAT.cipher(message));
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
                printer.printInfo(line);
                awayOut.println(line);
                break;
            case GENERATE:
                homeOut.println(Prefix.SHIPS.cipher(new Board().generateCodesOfShipCoordinates()));
                break;
            default:
                printer.printInfo(line);
                break;

        }
    }
}
