package io.github.tpalucki.java.concurrency.oracle;


/**
 * <a href="https://docs.oracle.com/javase/tutorial/essential/concurrency/sleep.html">...</a>
 */
public class SleepMessages {

    public static void main(String[] args) throws InterruptedException {
        String[] importantInfo = {
                "Mares eat oats",
                "Does eat oats",
                "Little lambs eat ivy",
                "A kid will eat ivy too"
        };

        for (String message : importantInfo) {
            System.out.printf("Message: %s\n", message);
            Thread.sleep(4000);
        }
    }
}