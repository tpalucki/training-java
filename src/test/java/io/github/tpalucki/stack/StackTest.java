package io.github.tpalucki.stack;

import io.github.tpalucki.java.stack.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    private Stack stack;

    @BeforeEach
    void initTest() {
        stack = new StackImpl();
    }

    @Test()
    void creation() {
        assertNotNull(this.stack);
    }

    @Test
    void addOneAndPop() {
        try {
            this.stack.push("A");
            Object popped = this.stack.pop();

            assertNotNull(popped);
            assertEquals("A", popped);
        } catch (Exception e) {
            fail("Should not throw any exception");
        }
    }
}
