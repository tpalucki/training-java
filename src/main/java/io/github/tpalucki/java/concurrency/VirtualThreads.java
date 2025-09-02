package io.github.tpalucki.java.concurrency;

class VirtualThreads {

    public static void main(String[] args) {
        createVirtualThread();
    }

    private static void createVirtualThread() {
        final Thread start = Thread.ofVirtual()
                .name("Sample Virtual Thread")
                .start(() -> {
                    System.out.println("Hello from virtual thread!");
                });

        try {
            start.join();
        } catch (InterruptedException e) {
            System.out.println("Task has been interupted");
            throw new RuntimeException(e);
        }
    }
}
