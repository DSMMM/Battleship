package com.dsmmm.battleships.server;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ServerInitializerTest {

    @Test
    public void testInitializeServer() {
        ServerInitializer serverInitializer;
        serverInitializer = new ServerInitializer();
        assertNotNull(serverInitializer);
    }
}