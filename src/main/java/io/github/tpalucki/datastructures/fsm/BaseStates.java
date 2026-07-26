package io.github.tpalucki.datastructures.fsm;

public enum BaseStates {
    INTIAL("INITIAL"),
    FINAL("FINAL");

    private final String value;

    BaseStates(String value) {
        this.value = value;
    }

    public String valueOf() {
        return this.value;
    }
}
