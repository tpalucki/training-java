package io.github.tpalucki.java.immutables;

import java.util.List;

public class CartCloneable implements Cloneable {

    private final List<String> parts;

    public CartCloneable(List<String> parts) {
        this.parts = List.copyOf(parts);
    }

    public List<String> getParts() {
        return parts;
    }

    /*
     * Zwroci shallow copy,
     * Aby osiągnąć deep copy nalezaloby zserializowac lub recznie skopiwoać
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
