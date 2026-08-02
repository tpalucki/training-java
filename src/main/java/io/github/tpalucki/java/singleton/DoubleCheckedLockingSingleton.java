package io.github.tpalucki.java.singleton;

public class DoubleCheckedLockingSingleton {

    // volatile ensures visibility across threads and prevents instruction reordering
    // Object construction in the JVM happens in three steps:
    // (1) allocate memory,
    // (2) run the constructor to initialize fields,
    // (3) assign the reference to instance.
    //
    // Without volatile, the JVM or the CPU is allowed to reorder steps 2 and 3.
    // A second thread can then read a non-null instance reference that points to a partially constructed object.
    //
    // Declaring the instance variable volatile prevents this reordering and establishes a happens-before relationship between the write and any subsequent read across threads.
    private static volatile DoubleCheckedLockingSingleton instance;

    private DoubleCheckedLockingSingleton() {}

    public static DoubleCheckedLockingSingleton getInstance() {
        // First check: avoid acquiring the lock if the instance is already created
        if (instance == null) {
            // Synchronize only during the brief initialization window
            synchronized (DoubleCheckedLockingSingleton.class) {
                // Second check: prevent duplicate creation if two threads passed the first check
                if (instance == null) {
                    instance = new DoubleCheckedLockingSingleton();
                }
            }
        }
        return instance;
    }
}
