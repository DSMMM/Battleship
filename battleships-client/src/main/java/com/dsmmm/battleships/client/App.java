package com.dsmmm.battleships.client;

class App {
    public static void main(String[] args) {
        if (args.length > 0 && args[0].equals("test")) {
            BatchClientLauncher launcher = new BatchClientLauncher(1000);
            launcher.startClients();
        } else {
            ChatFX.main(args);
        }
    }


}
