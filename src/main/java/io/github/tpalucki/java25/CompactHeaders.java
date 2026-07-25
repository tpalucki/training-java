
// Test Compact headers memory usages
// first
//  java CompactHeaders.java

// then with a flag enabling compact headers
// java -XX:+UseCompactObjectHeaders CompactHeaders.java

// EDIT: In Java 26 this option is enabled by default, so you can just run the code without any flags to see the memory usage with compact headers.
// you can disable compact header by using another flag
//java -XX:-UseCompactObjectHeaders CompactHeaders.java
class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

void main() throws Exception {
    int count = 10_000_000;
    Point[] points = new Point[count];

    long startMemory = getUsedMemory();

    for (int i = 0; i < count; i++) {
        points[i] = new Point(i, i);
    }

    long endMemory = getUsedMemory();
    long usedMB = (endMemory - startMemory) / (1024 * 1024);

    IO.println("Zużycie pamięci dla " + count + " obiektów: " + usedMB + " MB");
}

long getUsedMemory() {
    System.gc();
    try {
        Thread.sleep(100);
    } catch (InterruptedException _) {
    }
    Runtime runtime = Runtime.getRuntime();
    return runtime.totalMemory() - runtime.freeMemory();
}