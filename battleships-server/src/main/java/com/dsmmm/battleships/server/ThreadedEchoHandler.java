package com.dsmmm.battleships.server;

import java.io.*;
import java.net.Socket;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

class ThreadedEchoHandler implements Runnable {
    private final Socket incoming;
    private final Socket incoming2;


    public ThreadedEchoHandler(Socket incomingSocket, Socket incomingSocket2) {
        incoming = incomingSocket;
        incoming2 = incomingSocket2;
    }

    public void run() {
        try (
                InputStream inStream = incoming.getInputStream();
                OutputStream outStream = incoming.getOutputStream();
                OutputStream outStream2 = incoming2.getOutputStream()
        ) {
            Charset chatCharset = StandardCharsets.UTF_8;
            Scanner in = new Scanner(inStream, String.valueOf(chatCharset));
            PrintWriter out = new PrintWriter(
                    new OutputStreamWriter(outStream, chatCharset), true);
            PrintWriter out2 = new PrintWriter(
                    new OutputStreamWriter(outStream2, chatCharset), true);
            //todo stworzyć klasę do wysyłania wiadomości na czat
            out.println(Prefix.CHAT.cipher("Chat opened."));
            boolean done = false;

            while (!done && in.hasNextLine()) {
                String line;
                line = in.nextLine();
                redirectMessage(out, out2, line);
            }
            out.println("Your friend left chat! Status: disconnected");
            out2.println("Your friend left chat! Status: disconnected");
            System.out.println("Chat disconnected");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void redirectMessage(PrintWriter out, PrintWriter out2, String line) {
        Prefix type = Prefix.getType(line);
        String decipheredLine = Prefix.decipher(line);
        switch (type){
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