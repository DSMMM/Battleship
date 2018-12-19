package com.dsmmm.battleships.server;

import java.io.*;
import java.net.Socket;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

class ThreadedEchoHandler implements Runnable {
    private final Socket incoming;
    private final Socket incoming2;
    private Messenger messenger;


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
            //todo stworzyć klasę do wysyłania wiadomości na czat //+1
            messenger = new Messenger(out, out2);
            messenger.sendToFirstPlayerChat("Chat opened.");
            boolean done = false;

            while (!done && in.hasNextLine()) {
                String line;
                line = in.nextLine();
                messenger.redirectMessage(out, out2, line);
            }
            messenger.sendToBothPlayersChat("Your friend [has] left [the] chat! Status: disconnected");
            System.out.println("Chat disconnected");
        } catch (IOException e) {
            //HINT: true error handling might be more useful ;-)
            e.printStackTrace();
        }
    }


}