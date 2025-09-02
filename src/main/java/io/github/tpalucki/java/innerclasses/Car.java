package io.github.tpalucki.java.innerclasses;

public class Car {

    {
        Integer version = 1;
    }

    public class Engine {
        private Engine() {
        }
    }

    protected enum Wheels {
        WHEEL_1,
        WHEEL_2
    }

    private class Horn {
        Engine e = new Engine();
    }


    // all inner interfaces and enums are static by default - don't have to use static keyword
    static enum WheelStatic {WHEEL_3}

    @FunctionalInterface
    static interface Starter {

        void start();
    }

    static class Driver {
    }

    public static void main(String[] args) {
        Car car = new Car();
        Car.Horn horn = car.new Horn(); // !!! żeby stworzyć klasę wewnętrzną potrzebujemy instancji klasy zewnętrznej!!! WOW!

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
