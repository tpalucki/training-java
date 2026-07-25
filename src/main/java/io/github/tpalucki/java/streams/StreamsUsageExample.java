package io.github.tpalucki.java.streams;

import java.util.*;
import java.util.stream.*;

class StreamsUsageExample {

    static void main(String[] args) {
        var stream = Stream.of(1, 2, 3, 4, 5, 12, 645, 2, 1, 422, 23, 0);

        streamIterator(stream);

        streamOfPrimitiveTypes();

        filter_toSet();

        flatMap();

        flatMap_Collect_ReverseExample();

        reduceOperationOnStream();
    }

    private static void filter_toSet() {
        Stream<Integer> stream;
        stream = Stream.of(1, 2, 3, 4, 5, 5, 5, 12, 645, 2, 1, 422, 23, 0);
        var resultSet = stream
                .filter(item -> item > 2 && item < 1000)
                .collect(Collectors.toSet());
        // .toList() // od Java 17
        // .toArray()
        out(resultSet.toString());
        out("\n");
    }

    private static void reduceOperationOnStream() {
        Optional<Integer> reducedStream = Stream.of(1, 2, 3)
                .reduce(Integer::sum);
        out("\nReduced: " + reducedStream.get());

        Integer reducedInteger = Stream.of(1, 2, 3, 4)
                .reduce(0, Integer::sum);
        out("\nReduced: " + reducedInteger);
    }

    private static void streamIterator(Stream<Integer> stream) {
        // iterator na streamie - da sie
        var iterator = stream.iterator();
        while (iterator.hasNext()) {
            out(iterator.next() + ", ");
        }
        out("\n");
    }

    private static void flatMap_Collect_ReverseExample() {
        // flatting + collecting as List + reversing collected list
        Stream<List<Integer>> listStream;
        listStream = Stream.of(
                List.of(1, 1, 2),
                List.of(12, 1, 2, 3, 4, 5),
                List.of(0, 9, 8, 7, 6, 6)
        );
        var map = listStream
                .flatMap(Collection::stream)
                .sorted(Comparator.comparing(Integer::intValue).reversed())
                .distinct()
                .collect(Collectors.toMap(Integer::intValue, Integer::intValue));
        out(map.toString());
    }

    private static void flatMap() {
        var listStream = Stream.of(List.of(1, 2, 3, 4, 5, 5, 5), List.of(12, 645, 2, 1, 422, 23, 0));
        List<Integer> flattened = listStream
                .flatMap(Collection::stream)
                .collect(Collectors.toUnmodifiableList());
        out(flattened.toString());
        out("\n");
    }


    /**
     * Streamy mają ekwiwalent dla typów prostych.
     * <p>
     * java.util.stream
     * <p>
     * Zawierają metody do konwersji na typy boxed
     */
    private static void streamOfPrimitiveTypes() {
        // how to build
        var intStream = IntStream.of(1, 2, 3, 4);

        var longStream = LongStream.of(1L, 2L, 3L);

        // convert to boxed types
        Stream<Long> longBoxedStream = longStream.boxed();

//        longStream.average();
//        longStream.anyMatch(item -> item > 200L);
//        longStream.distinct();

//        longStream.asDoubleStream();
    }


    private static void out(String text) {
        System.out.print(text);
    }
}
