package io.github.tpalucki.java.enums;

import java.util.EnumSet;

/**
 * Please notice that enum implements interface
 */
public enum Planets implements Destructible {
    MERCURY(100, 300),
    MARS(100, 200),
    EARTH(100, 100);

    /**
     * Robimy jako finalne bo to są enums - immutable by default
     */
    final int weight;
    final int radius;

    Planets(int weight, int radius) {
        this.weight = weight;
        this.radius = radius;
    }

    public int getWeight() {
        return weight;
    }

    public int getRadius() {
        return radius;
    }

    /**
     * Tutaj użycie metody ordinal() - zwraca numerek porządkowy danego enuma;
     */
    public int getOrdinal() {
        return this.ordinal();
    }

    /**
     * Użycie EnumSet do przechowywania kilku Enumów
     */
    public EnumSet<Planets> getTwo() {
        return EnumSet.of(Planets.EARTH, Planets.MARS);
    }

    public EnumSet<Planets> getAll() {
        return EnumSet.allOf(Planets.class);
    }

    /**
     * This method is the interface Destructible implementation for enums
     */
    @Override
    public void destroy() {

    }
}