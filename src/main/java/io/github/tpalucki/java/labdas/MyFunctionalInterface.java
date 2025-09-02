package io.github.tpalucki.java.labdas;

import java.util.function.Function;

@java.lang.FunctionalInterface
interface MyFunctionalInterface {

    /**
     * Interfejs funkcjonalny musi miec dokładnie jedną metodę abstrakcyjną zgodnie ze specyfikacją
     * - jeżeli będzie więcej metod abstrakcyjnych to kompilator wskaże błąd
     * - dozwolone są metody domyślne
     * - dozwolone są metody statyczne
     */
    void lambdaMethod();

    default void defaultMethod() {
        System.out.println("Default method");
    }

    static void staticMethod() {
        Function<String, Integer> a = (String a1) -> {
            System.out.println(a1);
            return 1;
        };
        System.out.println("defaultMethod = " + a.apply("aaaa"));
    }
}
