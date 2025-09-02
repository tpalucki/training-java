package io.github.tpalucki.java.concurrency;

public class WaitTwoSecondsRunnable implements Runnable {

    // blok statycznej inicjalizacji
    static {
        System.out.println("Static initialisation.");
    }

    public WaitTwoSecondsRunnable() {
        System.out.println("Constructor.");
    }

    @Override
    public void run() {
        try {
            System.out.println("Started.");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Finished.");
        } finally {

            System.out.println("Finally performed");
        }
    }
}
