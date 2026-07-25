package io.github.tpalucki.java25.concurrency;

public class ThreadLocalGoodExample {

    private static final ThreadLocal<String> CURRENT_USER = new ThreadLocal<>();

    static void main() {
        try {
            // 1. Ustawienie kontekstu na początku pracy
            CURRENT_USER.set("Jan Kowalski");

            // 2. Wykonanie właściwej logiki
            pobierzZamowienie();
            wygenerujFakture();

        } finally {
            // 3. ODBOWIĄZKOWE czyszczenie w bloku finally!
            // Wykonuje się zawsze, nawet jeśli logika wyżej rzuci wyjątek.
            CURRENT_USER.remove();
        }

        IO.println("Czy wartość dalej istnieje w wątku? " + CURRENT_USER.get());
        // Wydrukuje: null (pamięć została zwolniona!)
    }

    static void pobierzZamowienie() {
        IO.println("[Pobieranie zamówienia] Dla użytkownika: " + CURRENT_USER.get());
    }

    static void wygenerujFakture() {
        IO.println("[Faktura] Wystawiono dla: " + CURRENT_USER.get());
    }
}
