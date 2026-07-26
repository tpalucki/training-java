package io.github.tpalucki.java.concurrency.locks;

import java.time.Duration;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

/**
 * A thread-safe rate limiter component that controls max concurrent executions 
 * using a Semaphore.
 */
public class ConcurrentRateLimiter {

    private final Semaphore semaphore;

    /**
     * @param maxConcurrentRequests Max number of threads allowed concurrently.
     * @param fair Whether to guarantee First-In-First-Out (FIFO) granting order.
     */
    public ConcurrentRateLimiter(int maxConcurrentRequests, boolean fair) {
        if (maxConcurrentRequests <= 0) {
            throw new IllegalArgumentException("Permits must be greater than 0");
        }
        this.semaphore = new Semaphore(maxConcurrentRequests, fair);
    }

    /**
     * Executes a task requiring a return value, acquiring a permit first.
     * Blocks until a permit is available.
     */
    public <T> T execute(Supplier<T> task) throws InterruptedException {
        semaphore.acquire();
        try {
            return task.get();
        } finally {
            semaphore.release(); // Crucial: Always release in finally block!
        }
    }

    /**
     * Attempts to execute a task with a timeout. 
     * Returns true if executed, false if timed out waiting for a permit.
     */
    public boolean tryExecute(Runnable task, Duration timeout) throws InterruptedException {
        if (semaphore.tryAcquire(timeout.toMillis(), TimeUnit.MILLISECONDS)) {
            try {
                task.run();
                return true;
            } finally {
                semaphore.release();
            }
        }
        return false; // Timed out waiting for access
    }

    /**
     * Returns current available permits for monitoring.
     */
    public int getAvailablePermits() {
        return semaphore.availablePermits();
    }
}