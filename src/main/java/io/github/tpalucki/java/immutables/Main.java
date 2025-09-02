package io.github.tpalucki.java.immutables;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {
        CartImmutable cart = new CartImmutable("Best cart", new LinkedHashMap<String, String>());

        // try to pu - immutability
        try {
            cart.getParts().put("Wheel", "Wheel1");
        } catch (UnsupportedOperationException e) {
        }


        List<String> list = new LinkedList<>();
        list.add("1");
        list.add("2");

        CartCloneable cartCloneable = new CartCloneable(list);

        CartCloneable cloned = (CartCloneable) cartCloneable.clone();
//        cloned.getParts().add("4");

        // it doesn't change the cloned and initialized collection so
        list.add("5");

        for (String part : cloned.getParts()) {
            System.out.println("clonde part = " + part);
        }

        for (String part : cartCloneable.getParts()) {
            System.out.println("clonde part = " + part);
        }

        System.out.println("cloned.parts.id = " + cloned.getParts().toString());
    }
}
