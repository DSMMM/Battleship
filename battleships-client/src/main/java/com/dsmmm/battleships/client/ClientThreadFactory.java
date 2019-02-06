package com.dsmmm.battleships.client;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

class ClientThreadFactory implements ThreadFactory {

    private static final AtomicInteger counter = new AtomicInteger();


    public Thread newThread(Runnable r) {
        return new Thread(r, "server listener #" + counter.incrementAndGet());
    }
}
