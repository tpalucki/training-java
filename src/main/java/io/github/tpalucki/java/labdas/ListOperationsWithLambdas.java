package io.github.tpalucki.java.labdas;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.DoubleToLongFunction;
import java.util.function.Supplier;

public class ListOperationsWithLambdas {

    static void main() {
        // 1 - SORTOWANIE LIST
        // UWAGA - wywali sie bo List.of - zwraca Immutable List
//        Collections.sort(List.of(1,3,2,10,1,3), Comparator.naturalOrder()); // wywali się z java.lang.UnsupporotedOperationException
//        List.of(1,3,2,10,1,3).sort( Comparator.naturalOrder());

        List<Integer> l = new LinkedList<>(Arrays.asList(2, 1, 3, 1, 14, 5, 2, 6));
        l.sort(Comparator.naturalOrder());
        out("Natural order: " + l);

        // 2 - reverse order using comparator
        // List. - zwaraca niemutowalne kolekcje
        // jeśłi chcemy zrobić mutowalną to ręcznie trzeba sobie utworzyć operatorem new
        List<String> mutableList = new ArrayList<>(16);

        Collections.sort(l, Comparator.reverseOrder());
        out("Reverse order: " + l);

        // 3 - reverse order uzywajac lambdy
        l.sort((a, b) -> Integer.compare(a, b));
        out("Natural order: " + l);

        // 4 - Analiza pakietu java.util.function
        // Tworzymy funkcje z uzyciem BinaryOperator (BiFunkcja ktora ma 2 arhumenty tego samego typu i zwraca ten sam typ)
        BinaryOperator<String> binaryFunc = (String a, String b) -> a + b;
        BinaryOperator<Integer> binaryFunc2 = (Integer a, Integer b) -> a * b;
        out(binaryFunc.apply("Tomek, Romek ", "i Atomek"));


        java.util.function.Function<Integer, Integer> unaryFunc = (a) -> a * a;
        out(Integer.toString(unaryFunc.apply(1)));

        DoubleToLongFunction doubleToLongFunction = (a) -> (long) a;
        out(Long.toString(doubleToLongFunction.applyAsLong(2d)));

        Supplier<String> supplier = () -> "This is supplied string";
        out(supplier.get());

        Consumer<Integer> consumer = (i) -> {
        };

        // 5 - Functional interface - jest to interfejs z tylko jedna metodą abstrakcyjna
        // dzieki temu mozemy utworzyc instance jak ponizej - i to bez wolania nazwy metody ani nic takiego.
        // Po prostu piszemy labde ktora realizuje ten interfejs i tyle.
        MyFunctionalInterface myFunctionalInterface = () -> {
        };

        var t = new Thrower();

        try {
            t.throwException();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            // always performe
            // except when Runtime.exit()
        }
//
//        try {
//            Runtime.getRuntime().exec("io.elementary.code");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }

    private static void out(String s) {
        System.out.println(s);
    }

    static class Thrower {

        void throwException() throws Exception {
            try {
                throw new Exception("Exception thrown");
            } finally {
                System.out.println("Finally");
            }
        }
    }
}
