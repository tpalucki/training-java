package io.github.tpalucki.java.singleton;


public class ThreadSafeSingleton {

    private static ThreadSafeSingleton instance;

    private ThreadSafeSingleton(){}

    // synchronized serializes all callers; only one thread enters the method at a time
    public static synchronized ThreadSafeSingleton getInstance() {
        // static synchronized == below block
//        synchronized (ThreadSafeSingleton.class) {
//        }
        if (instance == null) {
            instance = new ThreadSafeSingleton();
        }
        return instance;
    }

}