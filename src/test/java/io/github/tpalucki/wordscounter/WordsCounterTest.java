package io.github.tpalucki.wordscounter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class WordsCounterTest {

    @Test
    void shouldCoun5tWords() {
        WCounter c = new WordsCounter();
        var text = "1 2 3 4 5";

        assertEquals(5, c.count(text));
    }

    @Test
    void shouldCountNoWords() {
        WCounter c = new WordsCounter();
        var text = "";

        assertEquals(0, c.count(text));
    }

    @Test
    void shouldCountNoWordsOnBlankString() {
        WCounter c = new WordsCounter();
        var text = "        ";

        assertEquals(0, c.count(text));
    }

    @Test
    void shouldAssertNull() {
        WCounter c = new WordsCounter();

        NullPointerException e = assertThrows(NullPointerException.class, () -> c.count(null));
        assertEquals("Input should not be null", e.getMessage());
    }

}