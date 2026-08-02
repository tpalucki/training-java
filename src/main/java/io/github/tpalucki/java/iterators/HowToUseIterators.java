package io.github.tpalucki.java.iterators;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class HowToUseIterators {

    /**
     * INFO: Default iterators for Collections from java.util package such as ArrayList, HashMap, etc. are Fail-Fast.
     */
    static void main(String[] args) {
        howToIterate();

        howToRemove();

        howToUseListIterator();

        failSafeIterator();
    }

    private static void howToIterate() {
        IO.println("How to iterate with iterator?");
        var nums = List.of(1, 2, 3);

        final Iterator<Integer> iterator = nums.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            System.out.println("next = " + next);
        }
    }

    private static void howToRemove() {
        IO.println("How to remove with iterator");
//        var nums = List.of(1, 2, 3, 4, 5); // na immutable kolekcji próba usunięcia
//        zwróci java.lang.UnsupportedOperationException
        var nums = new ArrayList<Integer>();
        nums.addAll(List.of(1, 2, 3, 4, 5));

        final Iterator<Integer> iterator = nums.iterator();

        while (iterator.hasNext()) {
            var next = iterator.next(); // <----- TUTAJ!!!
            if (next % 2 == 1) {
                iterator.remove();
                IO.println("next = " + next + " - removed");
            } else {
                IO.println("next = " + next);
            }
        }

        var newIterator = nums.iterator(); // tworzy nowy iterator
        newIterator.forEachRemaining(i -> IO.println("After removal next = " + i));
    }

    private static void howToUseListIterator() {
        var nums = List.of(1, 2, 3, 4, 5);

        final ListIterator<Integer> listIterator = nums.listIterator();
        try {
            listIterator.remove();
            // throws UnsupportedOperationException because it has to be called once after next() or previous()
        } catch (UnsupportedOperationException e) {
            IO.println("ListIterator is unmodifiable");
        }
    }

    private static void failSafeIterator() {
        Map<String, Integer> sharedMap = new ConcurrentHashMap<String, Integer>();
        sharedMap.put("First", 10);
        sharedMap.put("Second", 20);
        sharedMap.put("Third", 30);
        sharedMap.put("Fourth", 40);

        Iterator<String> iterator = sharedMap.keySet().iterator();

        while (iterator.hasNext()) {
            String key = iterator.next();
            IO.println("Current key from shared map = " + key);
            // !!! Inserting to collection while iterating!
            // with fail-safe it's possible, iteration still completes but with added element
            // it does detect the newly added element to the Collection.
            sharedMap.put("Fifth", 50);
        }
    }
}
