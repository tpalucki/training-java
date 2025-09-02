package io.github.tpalucki;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class FileOperationsTest {

    @Test
    void isBlank() {
        assertTrue("  ".isBlank());
    }

    @Test
    void isEmpty() {
        assertFalse("  ".isEmpty());
    }

    @Test
    void var() {
        var var = 1;
//        var = "";
//        var a = null; // Local Variable type interface - NIE MOŻNA inicjalizować NULLEM
        /**
         * TO jest dość oczywiste - przy przypisaniu do var typ jest wyciagany z prawej strony, a skoro przypisujemy
         * null to jak ma być wyciągnięty?
         */
    }

    /**
     * Test na odczyt i zapisa do pliku
     */
    @Test
    void shouldCreateTestFile() throws IOException {
        Path filePath = Files.createTempFile(Paths.get("src/test/resources"), "a", "txt");

        Files.writeString(filePath, "This is test message;");

        IOException ioe = assertThrows(IOException.class, () -> {
            throw new IOException("Nothing");
        });

        assertNotNull(ioe);
    }

    /**
     * Reading small file
     */
    @Test
    void whenReadSmallFileJava7_thenCorrect() throws IOException {
        var expected = "Hello, world!";
        Path path = Paths.get("src/test/resources/fileTest.txt");

        String content = Files.readString(path, StandardCharsets.UTF_8);

        assertEquals(expected, content);
    }

    /**
     * Reading large file with Biffered Reader of Files
     *
     * @throws IOException
     */
    @Test
    void whenReadLargeFileJava7_thenCorrect()
            throws IOException {
        String expected_value = "Hello, world!";

        Path path = Paths.get("src/test/resources/fileTest.txt");


        BufferedReader reader = Files.newBufferedReader(path);
        var line = reader.readLine();
        assertEquals(expected_value, line);
    }

    /**
     * Reading large file with streams api
     */
    @Test
    void givenFilePath_whenUsingFilesLines_thenFileData() throws URISyntaxException, IOException {

        Path path = Paths.get(getClass().getClassLoader().getResource("largeFileTest.txt").toURI());

        Stream<String> lines = Files.lines(path);
        String data = lines.collect(Collectors.joining("\n"));
        lines.close(); // very important when we work on files - we have to close the stream explicitly

        assertEquals(Files.readString(path), data);
    }

    /**
     * Reading large file using StreamTokenizer
     * This is very nice tool that allows to work with different type on tokens in file - numbers or words
     */
    @Test
    void whenReadWithStreamTokenizer_thenCorrectTokens()
            throws IOException {
        var reader = new FileReader("src/test/resources/tokens.txt");
        var tokenizer = new StreamTokenizer(reader);

        tokenizer.nextToken();
        assertEquals(StreamTokenizer.TT_WORD, tokenizer.ttype);
        assertEquals("Lorem", tokenizer.sval);

        tokenizer.nextToken();
        assertEquals(StreamTokenizer.TT_NUMBER, tokenizer.ttype);
        assertEquals(1, tokenizer.nval);

        reader.close();
    }

    @Test
    void shouleReadLargeFileUsingJava8StreamLinesApi() throws IOException {
        var file = Paths.get("src/test/resources/largeFileTest.txt");
        try (var lines = Files.lines(file)) {
            // wypisuje linijki
//            lines.forEach(System.out::println);

            // wypisuje słowa - zwroc uwage na flatMap
//            lines.map(line -> Stream.of(line.split(" "))).flatMap(stringStream -> stringStream).forEach(System.out::println);

            // zlicza wystąpienia słów + filtrowanie na te ktorych jest wiecej niz jedno
            Map<String, Long> collect = lines.flatMap(line -> Stream.of(line.split(" "))).collect(Collectors.groupingBy(word -> word, Collectors.counting()));
            collect.entrySet().stream().filter((var entry) -> entry.getValue() > 1L).forEach((var entry) -> System.out.printf("%s %d %n", entry.getKey(), entry.getValue()));
        }
    }


}
