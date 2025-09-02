package io.github.tpalucki.java.concurrency.oracle;


/**
 * <a href="https://docs.oracle.com/javase/tutorial/essential/concurrency/simple.html">...</a>
 */
class MessagesLoop {

    static void threadMessage(String message) {
        String threadName = Thread.currentThread().getName();
        System.out.printf("%s: %s%n", threadName, message);
    }

    private static class MessageLoop implements Runnable {
        private static final String[] importantInfo = {
                "Mares eat oats",
                "Does eat oats",
                "Little lambs eat ivy",
                "A kid will eat ivy too"
        };

        @Override
        public void run() {
            try {
                for (String message : importantInfo) {
                    Thread.sleep(1000);
                    threadMessage(message);
                }
            } catch (InterruptedException e) {
                threadMessage("I wasn't done!");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // Delay, in milliseconds before
        // we interrupt MessageLoop
        // thread (default one hour).
        long patience = 1000 * 3;

        threadMessage("Starting MessageLoop thread");
        long startTime = System.currentTimeMillis();

        Thread t = new Thread(new MessageLoop());
        t.start();

        threadMessage("Waiting for MessageLoop thread to finish");

        while (t.isAlive()) {
            threadMessage("Still waiting...");
            t.join(2000); // wait max 2sec for message loop to finish

            long currentTime = System.currentTimeMillis();
            if (currentTime - startTime > patience && t.isAlive()) {
                threadMessage("Tired of waiting!");

                t.interrupt();

                // should soon finish
                t.join();
            }
        }
        threadMessage("Finally!");
    }
}
