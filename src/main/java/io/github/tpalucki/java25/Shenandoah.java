import java.util.ArrayList;
import java.util.List;

// Uruchomienie z wielogeneracyjnym Shenandoah:
// java -XX:+UseShenandoahGC -XX:ShenandoahGCMode=generational Shenandoah.java

// Dla porownania uruchomienie w starym trybie jednogeneracyjnym
// java -XX:+UseShenandoahGC -XX:ShenandoahGCMode=satb Shenandoah.java
void main() throws Exception {
    IO.println("Uruchamiam alokację pamięci dla Shenandoah GC...");

    // Obiekty długowieczne (Stara generacja)
    List<byte[]> longLived = new ArrayList<>();
    for (int i = 0; i < 100; i++) {
        longLived.add(new byte[1_000_000]); // 1 MB każdy
    }

    // Ciągła produkcja obiektów krótkowiecznych (Młoda generacja)
    long start = System.currentTimeMillis();
    for (int i = 0; i < 50_000; i++) {
        byte[] shortLived = new byte[100_000]; // 100 KB
        if (i % 10_000 == 0) {
            IO.println("Przetworzono paczkę " + i);
        }
    }
    long duration = System.currentTimeMillis() - start;

    IO.println("Czas wykonania testu: " + duration + " ms");
}
