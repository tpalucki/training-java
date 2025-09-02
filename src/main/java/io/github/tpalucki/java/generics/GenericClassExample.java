package io.github.tpalucki.java.generics;

public class GenericClassExample<T> {

    void doSthWithNoReturn(T arg) {
    }

    public T doSthWith(T arg) {
        return arg;
    }

    // Mozna wprowadzic tez inny typ generyczny
    <Z> void doSomeOTherStffWithOtherGeneric(Z arg, T arg2) {
        return;
    }
}
