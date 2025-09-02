package io.github.tpalucki.java.concurrency.oracle.producerConsumer;

import java.util.Random;

public class Consumer implements Runnable {
    public static final Random RANDOM = new Random();

    private final Drop drop;

    public Consumer(Drop drop) {
        this.drop = drop;
    }

    @Override
    public void run() {
        for (String message = drop.take();
             !message.equals("DONE");
             message = drop.take()) {
            System.out.format("MESSAGE RECEIVED: %s%n", message);
            try {
                Thread.sleep(RANDOM.nextInt(5000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}