package io.github.tpalucki.java.singleton;

public class NonSynchronizedSingleton {
    private static NonSynchronizedSingleton instance;

    // WARNING - tutaj jest taki kruczek ze mozna utworyzc druga instancje - klient uzywaja reflaksji moglby zmienic modyfikator
    // dostepu do konstruktora - i wywola go
    private NonSynchronizedSingleton() {
    }

    // WARNING - below patterns is broken
    // eg. T1 check for null, T2 checks for null, both instantiate
    // both assign - we have 2 instances
    public static NonSynchronizedSingleton getInstance() {
        if (instance == null) {
            instance = new NonSynchronizedSingleton();
        }
        return instance;
    }
}
