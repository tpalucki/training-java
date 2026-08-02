package io.github.tpalucki.java.singleton;


/**
 * When to Use Static Block Over Eager Initialization?
 * Use static block initialization when the Singleton constructor may fail with a checked exception (for example,
 * while reading configuration from disk or initializing a network resource). Both approaches load the instance eagerly,
 * so neither is appropriate for heavyweight resources that should be created lazily.
 */
public class StaticBlockSingleton {

    private static StaticBlockSingleton instance;

    // Static block runs once at class load; wraps construction in try/catch
    static {
        try {
            instance = new StaticBlockSingleton();
        } catch (Exception e) {
            // Convert any checked exception into RuntimeException so class loading fails fast
            throw new RuntimeException("Exception occurred in creating singleton instance");
        }
    }
    
    public static StaticBlockSingleton getInstance() {
        return instance;
    }
}
