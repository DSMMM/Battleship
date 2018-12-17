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
            out.println("Chat opened.");
            boolean done = false;

            while (!done && in.hasNextLine()) {
                String line;
                line = in.nextLine();
                out.println(line);
                out2.println(line);

                if (line.trim().equals("BYE")) done = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Odszedł bezpowrotnie użytkownik");
        }
    }
}