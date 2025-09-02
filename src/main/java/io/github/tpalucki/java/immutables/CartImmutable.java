package io.github.tpalucki.java.immutables;

import java.util.Map;

/**
 * Create immutable object - state is constant after initialization, no side effects
 * <p>
 * To achieve:
 * 1) Final class - can't extend
 * 2) Final fields
 * 3) Copy to immutable object when initializing the arguments
 * <p>
 * 3) Remove access to fields
 * OR
 * 4) Ensure fields are immutable
 */
public final class CartImmutable {

    private final String name;
    private final Map<String, String> parts;

    public CartImmutable(String name, Map<String, String> parts) {
        this.name = name;
        this.parts = Map.copyOf(parts);
    }

    public Map<String, String> getParts() {
        return parts;
    }
}
