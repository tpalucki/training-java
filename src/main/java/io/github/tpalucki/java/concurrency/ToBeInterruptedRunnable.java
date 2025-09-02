package io.github.tpalucki.java.concurrency;

public class ToBeInterruptedRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("ToBeInterruptedRunnable started");

        for (int i = 0; i < 1000000; i++) {
            System.out.print(i + ",");
            if (Thread.interrupted()) {
                System.out.println("I've been interrupted");
                return;
            }
        }
        System.out.println("After being interrupted and not returning method continues.");
    }
}
