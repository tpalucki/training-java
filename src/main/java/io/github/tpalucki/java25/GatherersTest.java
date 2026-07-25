import java.util.List;
import java.util.stream.Gatherers;

void main() {
    List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8);

    IO.println("=== 1. Window Fixed (Paczki po 3 elementy) ===");
    // Dzieli listę na [1, 2, 3], [4, 5, 6], [7, 8]
    List<List<Integer>> fixedBatches = numbers.stream().gather(Gatherers.windowFixed(3)).toList();

    IO.println("Paczki stałe: " + fixedBatches);

    IO.println("\n=== 2. Window Sliding (Przesuwne okno 3-elementowe) ===");
    // Przesuwa okno o 1 element: [1, 2, 3], [2, 3, 4], [3, 4, 5] itd.
    List<List<Integer>> slidingWindows = numbers.stream().gather(Gatherers.windowSliding(3)).toList();

    IO.println("Okna przesuwne: " + slidingWindows);

    IO.println("\n=== 3. Scan (Skumulowane sumy) ===");
    // Generuje bieżącą sumę dla każdego kolejnego elementu
    List<Integer> runningTotals = numbers.stream()
            .gather(Gatherers.scan(() -> 0, Integer::sum)).toList();

    IO.println("Suma skumulowana: " + runningTotals);

    // Własny Gatherer zatrzymujący przetwarzanie przy przekroczeniu progu 50
    Gatherer<Integer, ?, Integer> limitSum = Gatherer.ofSequential(
            () -> new int[]{0}, // Stan: [skumulowanaSuma]
            Gatherer.Integrator.ofGreedy((state, element, downstream) -> {
                state[0] += element;
                if (state[0] <= 50) {
                    downstream.push(element);
                    return true;
                }
                return false; // Przerwij dalsze przetwarzanie strumienia
            })
    );

    List<Integer> result = numbers.stream()
            .gather(limitSum)
            .toList();

    IO.println("Elementy, których suma <= 50: " + result); // [10, 20]
}