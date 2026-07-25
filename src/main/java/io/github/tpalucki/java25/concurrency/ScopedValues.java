package io.github.tpalucki.java25.concurrency;

import java.lang.ScopedValue;

public class ScopedValues {
    // 1. Deklaracja ScopedValue (zazwyczaj jako pole static final)
    private static final ScopedValue<String> CURRENT_USER = ScopedValue.newInstance();

    void main() {
        IO.println("--- Początek aplikacji ---");

        // 2. Wiązanie wartości na określony czas wykonywania bloku code
        ScopedValue.where(CURRENT_USER, "Jan Kowalski")
                .run(() -> {
                    // Wewnątrz tego bloku CURRENT_USER jest dostępny
                    pobierzZamowienie();
                    wygenerujFakture();
                });

        // 3. Po wyjściu z bloku wartość automatycznie przestaje istnieć!
        boolean isAvailable = CURRENT_USER.isBound();
        IO.println("Czy użytkownik jest dostępny poza blokiem? " + isAvailable);
    }

    void pobierzZamowienie() {
        // Odczyt wartości bez przekazywania jej w parametrze metody:
        String user = CURRENT_USER.get();
        IO.println("[Pobieranie zamówienia] Dla użytkownika: " + user);
    }

    void wygenerujFakture() {
        String user = CURRENT_USER.get();
        IO.println("[Faktura] Wystawiono dla: " + user);
    }
}
