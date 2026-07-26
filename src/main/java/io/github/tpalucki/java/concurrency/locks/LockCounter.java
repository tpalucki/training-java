package io.github.tpalucki.java.concurrency.locks;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

interface Counter {
    int increment();
}

class LockCounter implements Counter {
    private int counter = 0;
    private final Lock lock = new ReentrantLock();

    @Override
    public int increment() {
        lock.lock();
        try {
            return ++counter;
        } finally {
            lock.unlock();
        }
    }
}

class AtomicCounter implements Counter {
    private final AtomicInteger counter = new AtomicInteger();

    @Override
    public int increment() {
        return counter.incrementAndGet();
    }
}



