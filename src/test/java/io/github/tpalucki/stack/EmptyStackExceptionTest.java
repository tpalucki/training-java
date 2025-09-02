package io.github.tpalucki.stack;

import io.github.tpalucki.java.stack.EmptyStackException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class EmptyStackExceptionTest {


    @Test
    void succeedTest() {

    }

    @Test
    void exceptionCreation() {
        EmptyStackException e = new EmptyStackException();
        assertNotNull(e);
    }

    @Test
    void exceptionThrown() {
        EmptyStackException e = assertThrows(EmptyStackException.class, () -> {
                    throw new EmptyStackException();
                },
                "Exception not thrown");
        assertNotNull(e);
    }
}
