package com.dsmmm.battleships.server;

import java.io.PrintWriter;

class Messenger {
    private PrintWriter out;
    private PrintWriter out2;

    Messenger(PrintWriter out, PrintWriter out2) {
        this.out = out;
        this.out2 = out2;
    }

    //HINT: unused method (2nd player)
    void sendToFirstPlayerChat(String message){
        out.println(Prefix.CHAT.cipher(message));
    }
    void sendToSecondPlayerChat(String message){
        out2.println(Prefix.CHAT.cipher(message));
    }
    void sendToBothPlayersChat(String message){
        out2.println(Prefix.CHAT.cipher(message));
        out2.println(Prefix.CHAT.cipher(message));
    }
    void redirectMessage(PrintWriter out, PrintWriter out2, String line) {
        Prefix type = Prefix.getType(line);
        String decipheredLine = Prefix.decipher(line);
        switch (type) {
            case CHAT:
                out.println(line);
                out2.println(line);
                break;
            case SHOOT:
                System.out.println(decipheredLine);
                break;
        }
    }
}
