package io.github.tpalucki.java.singleton;

/**
 * Enum-based approach
 */
public enum EnumSingleton {
    // INSTANCE is the sole enum constant and the singleton instance
    INSTANCE;

    public static EnumSingleton getInstance() {
        return INSTANCE;
    }
}
