package io.github.tpalucki.java.singleton;

public class LazyInitializedSingleton {

    private static LazyInitializedSingleton instance;

    private LazyInitializedSingleton(){}

    /**
     * Thread Safety Problem with Naive Lazy Initialization
     * Two threads can interleave inside the null check and produce two distinct instances:
     *
     * Thread A evaluates instance == null. Result: true.
     * Thread B evaluates instance == null before Thread A finishes constructing the object. Result: true.
     * Both threads execute new LazyInitializedSingleton().
     * Two instances are created and the Singleton guarantee is broken.
     * The next sections cover four thread-safe alternatives, ordered from highest synchronization cost to lowest.
     */
    public static LazyInitializedSingleton getInstance() {
        // Race condition exposure: multiple threads can pass this check simultaneously
        if (instance == null) {
            // PROBLEM!!!
            instance = new LazyInitializedSingleton();
        }

        return instance;
    }
}