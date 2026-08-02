package io.github.tpalucki.java.singleton;

// AKA - Initialization on demand holder idiom
// best approach, lazy initialized
public class BillPughSingleton {

    private BillPughSingleton(){}

    // Inner static class is not loaded until referenced for the first time
    private static class SingletonHelper {
        // INSTANCE is created when SingletonHelper is initialized by the JVM
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

    public static BillPughSingleton getInstance() {
        // First reference to SingletonHelper triggers its class initialization
        return SingletonHelper.INSTANCE;
    }
}