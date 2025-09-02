package io.github.tpalucki.java.singleton;

public enum Elvis3 {
    INSTANCE;

    public void doSth() {
    }
}


enum ElvisSingleton implements Runnable {
    INSTANCE;

    private int a;
    private String b;

    ElvisSingleton() {
        a = 1;
        b = "2";
    }

    @Override
    public void run() {

    }
}