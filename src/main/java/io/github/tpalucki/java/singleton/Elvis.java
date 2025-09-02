package io.github.tpalucki.java.singleton;

/**
 * Implementation of the singleton pattern using public final field
 */
public class Elvis {
    public static final Elvis INSTANCE = new Elvis();

    private Elvis() {
    }

    // WAZNE: tutaj jest taki kruczek ze mozna utworyzc druga instancje - klient uzywaja reflaksji moglby zmienic modyfikator
    // dostepu do konstruktora - i wywola go
}