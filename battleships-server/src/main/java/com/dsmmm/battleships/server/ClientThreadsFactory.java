package com.dsmmm.battleships.server;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

class ClientThreadsFactory implements ThreadFactory {

    private final AtomicInteger counter = new AtomicInteger();

    @Override
    public Thread newThread(Runnable r) {
        return new Thread(r, "Client #" + counter.incrementAndGet());
    }
}
