package io.github.tpalucki.java.concurrency.oracle.producerConsumer;

public class Drop {

    // Message sent from producer
    // to consumer.
    private String message;
    // True if consumer should wait
    // for producer to send message,
    // false if producer should wait for
    // consumer to retrieve message.
    private boolean empty = true;

    public synchronized String take() {
        // Wait until message is
        // available.
        while (empty) {
            try {
                wait();
            } catch (InterruptedException ignored) {
            }
        }
        empty = true;
        // Notify producer that
        // status has changed.
        notifyAll();
        return message;
    }

    public synchronized void put(String message) {
        while (!empty) {
            try {
                wait();
            } catch (InterruptedException ignored) {
            }
        }
        System.out.printf("PUTTING MESSAGE: %s%n", message);
        empty = false;
        this.message = message;
        notifyAll();
    }
}
