package io.github.tpalucki.tdd.wordcount;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WordCounterTest {

    private WordCounter wordCounter = new WordCounter();

    @Test
    void shouldCountWords() throws IOException {
        var testFilePath = Files.writeString(Files.createTempFile("test", ".txt"), "a a b b a");

        final Map<String, Long> countedWords = wordCounter.count(testFilePath);

        assertEquals(Map.of("a", 3L, "b", 2L), countedWords);
    }
}