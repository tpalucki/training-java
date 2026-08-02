package io.github.tpalucki.java.labdas;

import java.util.*;
import java.util.function.*;

public class LambdaUsage {

    static void main(String[] args) {
        // dostarczamy implementację tej jednej metody abstrakcyjnej
        MyFunctionalInterface myIf = () -> {
            IO.println("implementation provided in lambda assignment");
        };

        // wywołujemy
        myIf.lambdaMethod();

        myIf.defaultMethod();

        MyFunctionalInterface.staticMethod();

        anotherExample();
        usageInStreams();
    }


    static void anotherExample() {
        MyFunctionalInterface myFun = () ->
                System.out.println("Functional interface has to have single abstract lambdaMethod, so we could implement it" +
                        "\n It can also contain multiple static/default methods");

        myFun.lambdaMethod();
    }

    static void constructorUsage() {
        Supplier<Object> supplier = Object::new;
        supplier.get();
    }

    static void listSorting() {
        Comparator<String> comparator = Comparator.comparing(item -> item.length() > 100 ? -1 : 1);

        List<String> list = new LinkedList<>();
        list.sort(comparator);
    }

    static void usageInStreams() {
        new Random()
                .longs(5)
                .filter(item -> item > 100L)
                .forEachOrdered(IO::println);
        IO.println(" ");

        long result = new Random()
                .longs(5)
                .filter(item -> item > 100L)
                .peek(IO::println)
                .filter(filterAbove100L)
                .limit(10)
                .count();

    }

    static LongPredicate filterAbove100L = (item) -> item > 100L;
}
