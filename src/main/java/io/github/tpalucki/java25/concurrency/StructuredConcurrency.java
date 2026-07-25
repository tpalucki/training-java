import java.util.concurrent.StructuredTaskScope;

void main() throws Exception {
    IO.println("--- Rozpoczynam pobieranie danych ---");

    UserData data = fetchUserData();

    IO.println("Pobrano dane pomyślnie:");
    IO.println("Użytkownik: " + data.user());
    IO.println("Zamówienie: " + data.order());
}

record UserData(String user, String order) {
}

UserData fetchUserData() throws Exception {
    // 1. Tworzymy zakres ustrukturyzowany - anuluj wszystko, jeśli któreś zadanie zawiedzie
    try (var scope = StructuredTaskScope.open(StructuredTaskScope.Joiner.awaitAllSuccessfulOrThrow(), configuration -> configuration.withThreadFactory(Thread.ofVirtual().name("daba-", 0).factory()))) {

        // 2. Uruchamiamy dwa równoległe podzadania w wirtualnych wątkach
        StructuredTaskScope.Subtask<String> task1 = scope.fork(() -> fetchUserFromDb());
        StructuredTaskScope.Subtask<String> task2 = scope.fork(() -> fetchOrderFromDb());
        StructuredTaskScope.Subtask<String> task3 = scope.fork(() -> fetchOrderFromDb());
        StructuredTaskScope.Subtask<String> task4 = scope.fork(() -> fetchOrderFromDb());

        // 3. Czekamy na zakończenie obu zadań (lub błąd któregokolwiek)
        scope.join();
        // Rzuca wyjątek, jeśli chociaż jedno podzadanie zawiodło

        // 4. Pobieramy wyniki, gdy mamy pewność, że wszystko poszło ok
        return new UserData(task1.get(), task2.get());
    }
    // 5. Po opuszczeniu bloku try-with-resources Mamy 100% pewności,
    // że ŻADEN wątek nie został "wiszący" w tle!
}

String fetchUserFromDb() throws InterruptedException {
    Thread.sleep(200); // Symulacja operacji I/O
    IO.println("From thread: " + Thread.currentThread().getName());
    return "Jan Kowalski";
}

String fetchOrderFromDb() throws InterruptedException {
    Thread.sleep(150); // Symulacja operacji I/O
    IO.println("From thread: " + Thread.currentThread().getName());
    return "Zamówienie #12345";
}