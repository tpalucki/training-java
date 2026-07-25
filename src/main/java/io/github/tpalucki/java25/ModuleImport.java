// Importuje całą bibliotekę standardową java.base!
import module java.base;

void main() {
    // List, Collectors, Path, Files pochodzą z różnych pakietów, 
    // ale działają bez osobnych importów:
    List<String> lines = List.of("Linia 1", "Linia 2", "Linia 3");

    String joined = lines.stream()
            .collect(Collectors.joining(" | "));

    IO.println("Połączony tekst: " + joined);
}