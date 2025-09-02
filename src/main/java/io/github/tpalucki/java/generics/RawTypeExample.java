package io.github.tpalucki.java.generics;


import java.util.LinkedList;
import java.util.List;

/**
 * This is example of
 *
 * @param <E>
 */
public class RawTypeExample<E extends Object> {

    E value;

    RawTypeExample(E param) {
        this.value = param;
    }

    void add(E param) {
        value = param;
    }

    E doSth() {
        return value;
    }

    /**
     * We can use unbound wildcard type - this is safer than using RawTypes
     *
     * Roznica jest taka ze do raw type mozna wstawic cokolwiek, a do wildacard type nie - wygeneruje to error w czasie kompilacji
     */
    void doSthWildcard(List<?> paramList) {
    }


    /**
     * ERROR: Using rowe types is allowed and will compile
     *
     * @param args
     */
    public static void main(String[] args) {

        // tataj mozna uzywac rownych typow bo operacje pod spodem są trywialne - wstawiamy do generics raz string, raz int itd
        // defaultMethod to powinno byc wychwycone juz na etapie kompilacji ze cos jest nie tak
        RawTypeExample a = new RawTypeExample("defaultMethod");
        a.add(Integer.valueOf(1));
        a.add(Integer.valueOf(2));
        a.add("b");


        /**
         * Wywaliło się już przy kompilacji - bo użyliśmy typu sparametryzowanego, a nie surowego.
         * Typesafe solution
         */
        List<String> b = new LinkedList<>();
        b.add("S");
//        b.add(Integer.valueOf(1));


        /**
         * Lets try wildcard
         */
//        defaultMethod.doSthWildcard("String"); // <-------------------- TUTAJ Sie nie da
        a.doSthWildcard(new LinkedList<String>() );

    }


}
