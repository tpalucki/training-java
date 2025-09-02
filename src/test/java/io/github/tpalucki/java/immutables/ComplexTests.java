package io.github.tpalucki.java.immutables;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComplexTests {

    @Test
    void creation() {
        Complex complex = new Complex(1, 1);
        assertNotNull(complex);
    }

    @Test
    void addTwoComplex() {
        // given
        Complex a = new Complex(1, 2);
        Complex b = new Complex(2, 2);

        // when
        Complex result = a.plus(b);

        // then
        assertEquals(3, result.realPart());
        assertEquals(4, result.imaginaryPart());
    }

    @Test
    void minusTwoComplex() {
        // given
        Complex a = new Complex(1, 2);
        Complex b = new Complex(2, 2);

        // when
        Complex result = a.minus(b);

        // then
        assertEquals(-1, result.realPart());
        assertEquals(0, result.imaginaryPart());
    }
}
