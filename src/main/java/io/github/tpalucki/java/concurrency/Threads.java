package io.github.tpalucki.java.concurrency;

import java.util.concurrent.*;

import static java.lang.Thread.sleep;

public class Threads {

    public static void main(String[] args) {
        // how to start threads in java?
        startingThreadUsingRunnable();
        startingThreadAsAThreadsSubclass();
        startingThreadViaThreadPool();

        interruptAThread();

        threadSafeRandom();
    }

    private static void threadSafeRandom() {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                System.out.println("ThreadLocalRandom.current().nextInt() = " + ThreadLocalRandom.current().nextInt(0, 1000));
            }).start();
        }
    }

    private static void interruptAThread() {
        var countingThread = new Thread(new ToBeInterruptedRunnable());
        countingThread.start();
        try {
            sleep(50);
            // let's interrupt the thread
            countingThread.interrupt();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void startingThreadUsingRunnable() {
        Runnable task = () -> {
            System.out.println("current thread id: " + Thread.currentThread().getName());
        };

        new Thread(task).start();
        new Thread(task).start();
    }

    private static void startingThreadAsAThreadsSubclass() {
        class TaskThread extends Thread {
            // super important to use run instead of start, otherwise it would execute in same thread
            public void run() {
                System.out.println("Going to sleep in thread id: " + Thread.currentThread().getName());
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Awaken in thread id: " + Thread.currentThread().getName());
            }
        }
        new TaskThread().start();
    }

    private static void startingThreadViaThreadPool() {
        Runnable taskRunnable = () -> System.out.println(Thread.currentThread().getName() + " task");
        Callable<Integer> taskCallable = () -> {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 1;
        };

        // open new thread pool
        try (var threadPool = Executors.newFixedThreadPool(10)) {
            // submit a runnable to the thread pool
            threadPool.submit(taskRunnable);

            // submit a callable to the tread pool
            int valueFromThread = threadPool.submit(taskCallable)
                    .get(2000, TimeUnit.MILLISECONDS);
            System.out.println("valueFromThread = " + valueFromThread);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
//            throw new RuntimeException(e);
            System.out.println("Runtime exception catched: " + e.getMessage());
        }
    }
}
