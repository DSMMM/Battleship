package com.dsmmm.battleships.server.io;


import com.dsmmm.battleships.server.board.Coordinates;
import com.dsmmm.battleships.server.game.Game;

import java.io.PrintWriter;

/**
 * Sends messages to clients and redirects received messages
 */
public class Messenger {
    private final PrintWriter homeOut;
    private final PrintWriter awayOut;
    private final Printer printer = new Printer(this.getClass());
    private final Game game;

    public Messenger(PrintWriter homeOut, PrintWriter awayOut) {
        this.homeOut = homeOut;
        this.awayOut = awayOut;
        game = new Game();
    }

    public static void sendMessage(PrintWriter out, String message) {
        out.println(Prefix.CHAT.cipher(message));
    }

    public void sendToFirstPlayerChat(String message) {
        homeOut.println(Prefix.CHAT.cipher(message));
    }

    public void sendToBothPlayersChat(String message) {
        awayOut.println(Prefix.CHAT.cipher(message));
    }

    public void redirectMessage(PrintWriter homeOut, PrintWriter awayOut, String line) {
        Prefix type = Prefix.getType(line);

        switch (type) {
            case CHAT:
                homeOut.println(line);
                awayOut.println(line);
                break;
            case ENEMY_SHOOT:
                printer.printInfo(line);
                awayOut.println(Prefix.SHOOT.cipher(Prefix.decipher(line)));
                break;
            case SHOOT:
                printer.printInfo(line);
                String decipheredCoordinates = Prefix.decipher(line);
                String[] coordinatesTable = decipheredCoordinates.split("-");
                int column = Integer.parseInt(coordinatesTable[0]);
                int row = Integer.parseInt(coordinatesTable[1]);
                Coordinates coordinates = new Coordinates(column, row);
                if(game.takeShot(coordinates)) {
                    awayOut.println(Prefix.HIT.cipher(decipheredCoordinates));
                    homeOut.println(Prefix.ENEMY_HIT.cipher(decipheredCoordinates));
                }
                else {
                    awayOut.println(Prefix.MISS.cipher(decipheredCoordinates));
                    homeOut.println(Prefix.ENEMY_MISS.cipher(decipheredCoordinates));
                }
                break;
            case GENERATE:
                printer.printInfo("Fleet generated for user: " + Thread.currentThread().getName());
                homeOut.println(Prefix.SHIPS.cipher(game.generateCodesOfShipCoordinates()));
                break;
            default:
                printer.printInfo(line);
                break;

        }
    }
}
