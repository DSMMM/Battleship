package com.dsmmm.battleships.client;

import java.util.Scanner;

class App {
    public static void main(String[] args) {
        Scanner into = new Scanner(System.in);
        Printer.print("Podaj imię: ");
        String name = into.next();

        ClientInitializer clientSocket = new ClientInitializer();
        clientSocket.clientSocket(name);
    }
}