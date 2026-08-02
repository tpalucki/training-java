package io.github.tpalucki.java.static_classes;

@FunctionalInterface
public interface MyInterface {

    int A = 1;

    void test();

    static void main(String[] args) {
        var enumInstance = MyInterface.A;
    }
}
