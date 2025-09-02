package io.github.tpalucki.java.singleton;

public class Singleton {

    private static Singleton instance = null;

    private Singleton() {
    }

    Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
