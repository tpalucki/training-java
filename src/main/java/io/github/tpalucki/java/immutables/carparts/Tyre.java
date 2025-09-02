package io.github.tpalucki.java.immutables.carparts;

public class Tyre implements Cloneable {

    String name;

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}
