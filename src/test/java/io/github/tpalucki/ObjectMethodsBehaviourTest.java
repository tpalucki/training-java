package io.github.tpalucki;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ObjectMethodsBehaviourTest {
    @Test
    void defaultEqualsOnDifferentStringsWithSameLiteral() {
        String a = "A", b = "A";
        assertTrue(a.equals(b));
    }

    @Test
    void defaultEqualsOnDifferentIntegersWithSameLiteral() {
        Integer a = 1, b = 1;
        assertTrue(a.equals(b));
    }
}
