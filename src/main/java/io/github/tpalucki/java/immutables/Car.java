package io.github.tpalucki.java.immutables;

import io.github.tpalucki.java.immutables.carparts.Engine;
import io.github.tpalucki.java.immutables.carparts.Tyre;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

/**
 * Immutable Car
 */
public final class Car implements Cloneable {

    private final Engine engine;
    private final List<Tyre> tyres;

    public Car(Engine engine, Collection<Tyre> newTyres) throws CloneNotSupportedException {
        Objects.requireNonNull(newTyres);
        Objects.requireNonNull(engine);

        this.engine = (Engine) engine.clone();
        tyres = new ArrayList<Tyre>();
        newTyres.forEach(((var tyre) -> {
            try {
                this.tyres.add((Tyre) tyre.clone());
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }));
    }


    Car(Engine e, List<Tyre> tyres) {
        Objects.requireNonNull(e);
        Objects.requireNonNull(tyres);
        this.engine = e;
        this.tyres = List.copyOf(tyres);
    }

}
