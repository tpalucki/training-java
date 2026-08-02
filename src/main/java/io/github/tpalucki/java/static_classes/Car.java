package io.github.tpalucki.java.static_classes;

// Java allows to have Class inside Class: These are "Nested Classes"
//
// The parent class is "Outer class"
// can't be static!!
public class Car {

    private String brand = "Ferrari";

    private static Integer versionOfClass = 1;

    // static initialization block executed when class loaded by JVM
    static {
        IO.println("Current class version = " + versionOfClass);
    }

    {
        Integer version = 1;
        IO.println("Current version = " + version);
    }

    // "Inner class": This is non-static class inside the parent class, so it's called "Inner class"
    // It cannot be created without outer class Car
    class Engine {
        String sound;

        Engine() {
            // has access to outer class's fields
            // both stats and non-static
            sound = brand + " " + versionOfClass + " bruuuum!!!";
        }
    }

    // "Nested class": This is static class inside parent class - so it's called "Nested class"
    // it can be instantiated without outer class Car
    static class EngineHolder {

        String sound;

        EngineHolder() {
            // brand is not available - only static
            sound = versionOfClass + " bruuuum!!!";
        }
    }

    protected enum Wheels {
        WHEEL_1,
        WHEEL_2;

        String sound;

        Wheels() {
            sound = " screeeeeekkkk";
        }
    }

    private class Horn {
        Engine e = new Engine();
    }


    // all inner interfaces and enums are static by default - don't have to use static keyword
    enum WheelStatic {WHEEL_3}

    // static by default
    @FunctionalInterface
    interface Starter {

        void start();
    }

    static class Driver {
    }

    static void main(String[] args) {
        // RULE 1: Inner class object cannot be created without outer class.
        Car car = new Car();
        Car.Horn horn = car.new Horn(); // !!! żeby stworzyć klasę wewnętrzną potrzebujemy instancji klasy zewnętrznej!!! WOW!

        // RULE 2: A static nested class may be instantiated without instantiating its outer class.
        Car.EngineHolder engineHolder = new Car.EngineHolder();

        // Which makes sense: if sth is static, can't access not static content of outer as it doesn't exist yet.

        Car.Wheels wheels = Wheels.WHEEL_1;

        // building inner interface/enum
        Car.WheelStatic wheelStatic = Car.WheelStatic.WHEEL_3;
        Car.Starter starterStatic = () -> {
        };
        starterStatic.start();

        // creating static inner class
        Car.Driver driver = new Car.Driver();


        // !!! Lokalna klasa wewnętrzna - nie ma modyfikatora dostepu i jest wewnatrz ciala metody - tyle
        // tutaj liczy sie zasięg - klasa dostepna wyłącznie w bloku w którym została zdefinionana
        class LocalClass {
            private int ver = 1;
        }

        System.out.println("Inner local class field values: " + new LocalClass().ver);

    }


}
