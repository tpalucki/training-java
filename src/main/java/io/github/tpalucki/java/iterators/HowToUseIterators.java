package io.github.tpalucki.java.iterators;

import java.util.*;

public class HowToUseIterators {

    public static void main(String[] args) {
        howToIterate();

        howToRemove();

        howToUseListIterator();
    }

    private static void howToIterate() {
        System.out.println("How to iterate with iterator?");
        var nums = List.of(1, 2, 3);

        final Iterator<Integer> iterator = nums.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            System.out.println("next = " + next);
        }
    }

    private static void howToRemove() {
        System.out.println("How to remove with iterator");
//        var nums = List.of(1, 2, 3, 4, 5); // na immutable kolekcji próba usunięcia zwróci java.lang.UnsupportedOperationException
        var nums = new ArrayList<Integer>();
        nums.addAll(List.of(1, 2, 3, 4, 5));

        final Iterator<Integer> iterator = nums.iterator();

        while (iterator.hasNext()) {
            var next = iterator.next(); // <----- TUTAJ!!!
            if (next % 2 == 1) {
                iterator.remove();
                System.out.println("next = " + next + " - removed");
            } else {
                System.out.println("next = " + next);
            }
        }

        var newIterator = nums.iterator(); // tworzy nowy iterator
        newIterator.forEachRemaining(i -> System.out.println("After removal next = " + i));
    }

    private static void howToUseListIterator() {
        var nums = List.of(1, 2, 3, 4, 5);

        final ListIterator<Integer> listIterator = nums.listIterator();
        listIterator.remove();

    }
}
