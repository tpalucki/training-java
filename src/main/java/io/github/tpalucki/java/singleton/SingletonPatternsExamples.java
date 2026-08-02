import io.github.tpalucki.java.singleton.*;

/**
 * TIP: JVM guarantees class initialization
 * Java's Virtual Machine guarantees that a class initialization is thread-safe. You don't need synchronized blocks or the volatile keyword, which keeps performance lightning-fast.
 * <p>
 * Summary:
 * Static initialization / Class loading: Managed and synchronized by the JVM. 🔒
 * Runtime new object creation: Requires manual thread safety (like synchronization or the holder idiom) if accessed concurrently.
 */
void main() {
    NonSynchronizedSingleton.getInstance(); // NOT THREAD SAFE!

    // best
    BillPughSingleton.getInstance();

    StaticBlockSingleton.getInstance();

    EnumSingleton.getInstance();
    var es = EnumSingleton.INSTANCE;

    StaticBlockSingleton.getInstance(); // when error might happen during object construction

    ThreadSafeSingleton.getInstance();

}




