package io.github.tpalucki.java25.concurrency;

public class ThreadLocalBadExample {

    private static final ThreadLocal<String> CURRENT_USER =  new ThreadLocal<>();

    static void main(String[] args) {
        // Ustawienie wartości
        CURRENT_USER.set("Jan Kowalski");

        pobierzZamowienie();
        wygenerujFakture();

        // ⚠️ ZANIECHANIE CZYSZCZENIA!
        // Brak wywołania CURRENT_USER.remove();
        // Wartość "Jan Kowalski" dalej leży w pamięci tego wątku!

        IO.println("Czy wartość dalej istnieje w wątku? " + CURRENT_USER.get());
        // Wydrukuje: "Jan Kowalski" (pamięć nie została zwolniona!)
    }

    static void pobierzZamowienie() {
        IO.println("[Pobieranie zamówienia] Dla użytkownika: " + CURRENT_USER.get());
    }

    static void wygenerujFakture() {
        IO.println("[Faktura] Wystawiono dla: " + CURRENT_USER.get());
    }
}
