package com.dsmmm.battleships.server.io;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Printer {

    private final Logger log;

    public Printer(Class clazz) {
        log = LogManager.getLogger(clazz);
    }

    public void printInfo(String message) {
        log.info(message);
    }

    public void printError(String message) {
        log.error(message);
    }
}
