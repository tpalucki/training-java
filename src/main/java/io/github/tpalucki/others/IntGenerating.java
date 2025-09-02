package io.github.tpalucki.others;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class IntGenerating {

    /**
     * Problem: Chcemy wygeneraować liczby z jakiegoś przedziału
     */
    public static void main(String[] args) {

        // 1. Generujemy liczbe
//        Random random = new Random(); // NOTE: Od Java 7 powinnismy wybrać ThreadLocalRandom zamiast Random
        Random random = ThreadLocalRandom.current();
        random.nextInt();
        random.nextInt(100);
        random.nextBoolean();
        random.nextLong();
        random.nextGaussian();

        // 2. Chcemy w danym przedziale
        int i;
        i = random.nextInt(100);
        i = random.nextInt() % 100;

        // ...
        random.doubles().filter(d -> d > 100d);
    }
}
