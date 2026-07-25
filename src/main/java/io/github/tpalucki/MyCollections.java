package io.github.tpalucki;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyCollections {

    public static void show() {
        // 1. stworz liste z elementow
        List<Integer> listOfInts = List.of(1, 2, 3, 4, 5, 6, 7, 8);


        // 2. stworz liste z obiektow
        List<String> listOfStrings = List.of("Tytus", "Romek", "Atomek", "Tosia");

        // 3. wypisz wszystkie elementy listy
        listOfStrings.stream().forEach(System.out::println);
        //lub
        listOfStrings.forEach((String s) -> IO.println(s));

        // 4. zmodyfikuj kazdy element listy
        System.out.println("Zadanie 4 ------------");
        System.out.println(
                listOfInts.stream().map((Integer i) -> i * i).collect(Collectors.toUnmodifiableSet()).toString()
        );

        // 5. filtruj elementy listy po jakims predykacie
        System.out.println("Zadanie 5 ------------");
        listOfInts.stream()
                .filter((Integer i) -> i > 2)
                .collect(Collectors.toUnmodifiableSet())
                .stream()
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println(listOfInts.toString());
        // [1, 2, 3, 4]

        // zadanie 6 połącz wszystkie obiekty z tablicy stringow przecinkami
        System.out.println("Zadanie 6 ------------");
        String joined = listOfStrings.stream().collect(Collectors.joining(", "));
        System.out.println(joined);

        joined = String.join(", ", listOfStrings);
        System.out.println(joined);

        // zadanie 7 to samo tylko alfabetycznie
        System.out.println("Zadanie 7 ------------");
        joined = listOfStrings.stream().sorted(Comparator.naturalOrder()).collect(Collectors.joining(", "));
        System.out.println(joined);

        // zadanie 8 suma elementow w tablicy
        System.out.println("Zadanie 8 ------------");
        int sum = listOfInts.stream().collect(Collectors.summingInt(Integer::intValue)).intValue();
        System.out.println(sum);

        // zadanie 9 iterujemy po kolekcji i dla kazdego elementu print
        System.out.println("Zadanie 9 ------------");
        listOfInts.iterator().forEachRemaining(System.out::println);

        Iterator<String> it = listOfStrings.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        listOfInts.stream().forEach(System.out::println);

        // zadanie 10 stworzyć mapę, a potem zrobić Collectors.grouping
        System.out.println("Zadanie 9 ------------");
        // Zadanie 11
    }


    public static void main(String[] args) {
        Stream<Item> s = Stream.of(
                new Item("kubek", "Tomek"),
                new Item("kubek", "Blanka"),
                new Item("nozyk", "Jasiu"),
                new Item("nozyk", "Andrzej")
        );

//        Map<String, List<Item>> m = s.collect(Collectors.groupingBy(Item::getKlasa));

//        List<Integer> counted = m.values().stream().map(List::size).collect(Collectors.toList()).stream().collect();
//        System.out.println("counted = " + counted);

//        String collect = s.map(Item::getNAzwa).collect(Collectors.joining(","));
//        System.out.println("collect = " + collect);
//        Map<String, List<Item>> collect = s.collect(Collectors.groupingBy(item -> item.getKlasa()));
//        Stream<List<Item>> listStream = collect.values().stream().flatMap(list -> Stream.of(list)).map();

//        var v = s.map(item -> item.getNAzwa()).collect(Collectors.joining());
//        System.out.println("v = " + v);

//        Map<String, List<Item>> collect = s.collect(Collectors.groupingBy(item -> item.getKlasa()));
//        Stream<List<String>> listStream = collect.values().stream().map(listOfItems -> listOfItems.stream().map(item -> item.getNAzwa()).collect(Collectors.toList()));
//
//        List<String> collect1 = listStream.map(list -> list.stream().collect(Collectors.joining(","))).collect(Collectors.toList());
//        System.out.println("collect1 = " + collect1);

//        Map<Boolean, List<Item>> kubek = s.collect(Collectors.partitioningBy(item -> item.getKlasa().equals("kubek")));
//        System.out.println("kubek = " + kubek);
//        Set<String> collect = s.map(Item::getNAzwa).sorted(Comparator.reverseOrder()).collect(Collectors.toSet());
//        System.out.println("collect = " + collect);

//        Map<String, List<Item>> collect = s.collect(Collectors.groupingBy(item -> item.getKlasa(), Collection));
    }

    public static class Item {

        String klasa;
        String nazwa;

        Item(String klasa, String nazwa) {
            this.klasa = klasa;
            this.nazwa = nazwa;
        }

        public String getKlasa() {
            return klasa;
        }

        public String getNazwa() {
            return nazwa;
        }
    }
}
