package io.github.tpalucki.tdd.wordcount;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordCounter {

//    1. wszytaj z pliku
//    2. linie na slowa,
//    3. zliczamy wystapienia slow

    private final String wordRegexpString = " ";

    Map<String, Long> count(Path filePath) throws IOException {
        var content = Files.readString(filePath);
        var words = content.split(wordRegexpString);

        return Stream.of(words).collect(Collectors.groupingBy(word -> word, Collectors.counting()));
    }
}
