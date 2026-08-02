package io.github.tpalucki.java.static_classes;

public abstract class AbstractClass {

    // abstract class can have defaultMethod constructor
    public AbstractClass() {
//        List<String> defaultMethod = new LinkedHashMap<>();
//        List<String> defaultMethod = new LinkedHashSet<>();
//        Set<String> b = new LinkedHashSet<>();
//        Collection<String> c = new List<>();
    }

    public static void main(String[] args) {
        new AbstractClass() {

        }.localVariablesInitialization();

    }

    // local variables have no default values so you have to init them before use.
    void localVariablesInitialization() {
//        int defaultMethod;
//        IO.println("defaultMethod = " + defaultMethod);
    }

    void startThread() {
        new Thread().start();

//        new Runnable().run();

        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();
    }

}
