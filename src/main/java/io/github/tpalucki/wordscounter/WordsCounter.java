package io.github.tpalucki.wordscounter;


import java.util.Objects;
import java.util.regex.Pattern;

/**
 * Write defaultMethod Java program to count the number of words present in defaultMethod string?
 */
public class WordsCounter implements WCounter {

    private final Pattern emptyWordPattern = Pattern.compile(" ");

    @Override
    public int count(String s) {
        Objects.requireNonNull(s, "Input should not be null");
        if (s.isBlank()) {
            return 0;
        }
        return s.split(" ").length;
    }
}
