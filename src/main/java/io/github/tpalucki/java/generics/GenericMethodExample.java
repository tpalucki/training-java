package io.github.tpalucki.java.generics;

import java.util.List;

public class GenericMethodExample {

    /**
     * This is example of generic method.
     * Please refer to TYPE PARAMETER LIST <E> before return type.
     */
    static <E> List<E> doNothingWithList(List<E> argument) {
        return List.copyOf(argument);
    }

    <T, Y> List<T> secondGeneric(T arg, Y arg2) {
        return List.of(arg);
    }


    <Z> Z genericMethod(Z arg) {
        return arg;
    }
}
