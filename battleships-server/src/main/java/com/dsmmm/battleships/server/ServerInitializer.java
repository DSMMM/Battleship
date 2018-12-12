package com.dsmmm.battleships.server;

import java.io.*;
import java.net.*;
import java.util.*;

public class ServerInitializer {
    void initializeServer() {
        try ( ServerSocket s = new ServerSocket(8189)) {
            while (true) {
                Socket incoming = s.accept();
                System.out.println("Dołączyła pierwsza osoba");
                OutputStream outStream = incoming.getOutputStream();
                PrintWriter out = new PrintWriter(
                        new OutputStreamWriter(outStream, "UTF-8"), true);
                out.println("Connection established. Please wait for second user.");
                Socket incoming2 = s.accept();                //OutputStream outStream = incoming.getOutputStream();
                System.out.println("Stworzono chatroom");
                Runnable r = new ThreadedEchoHandler(incoming, incoming2);
                Runnable r2 = new ThreadedEchoHandler(incoming2, incoming);
                Thread t = new Thread(r);
                t.start();
                Thread t2 = new Thread(r2);
                t2.start();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
