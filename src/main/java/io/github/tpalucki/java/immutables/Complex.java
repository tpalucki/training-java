package io.github.tpalucki.java.immutables;

import java.util.Comparator;

public final class Complex implements Cloneable, Comparable<Complex> {
    private final double re;
    private final double im;

    public static final Complex ZERO = new Complex(0, 0);
    public static final Complex ONE = new Complex(1, 0);
    public static final Complex I = new Complex(0, 1);

    public Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double realPart() {
        return this.re;
    }

    public double imaginaryPart() {
        return this.im;
    }


    // Thank to the fact that Java supports Covarian Return Types we can return Complex class.
//    @Override
//    protected Object clone() throws CloneNotSupportedException {
//        return super.clone();
//    }

    @Override
    protected Complex clone() {
        try {
            return (Complex) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(); // Can't happen so we push an Error
        }
    }

    public Complex plus(Complex c) {
        return new Complex(re + c.re, im + c.im);
    }

    public Complex minus(Complex c) {
        return new Complex(re - c.re, im - c.im);
    }

    public Complex times(Complex c) {
        return new Complex(re * c.re - im * c.im, re * c.im + im * c.re);
    }

    public Complex dividedBy(Complex c) {
        double tmp = c.re * c.re + c.im * c.im;
        return new Complex(
                (re * c.re + im * c.im) / tmp,
                (im * c.re - re * c.im) / tmp);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Complex)) {
            return false;
        }
        Complex c = (Complex) o;
        return Double.compare(c.re, re) == 0 && Double.compare(c.im, im) == 0;
    }

    @Override
    public int hashCode() {
        return 31 * Double.hashCode(re) + Double.hashCode(im);
    }

    @Override
    public String toString() {
        return "(" + re + " + " + im + "i)";
    }


    /**
     * Nice usage of Java 8 comparators
     * We use static comparator.
     */
    private static final Comparator<Complex> COMPARATOR = Comparator.comparing((Complex complex) -> complex.re)
            .thenComparing((complex -> complex.im));

    @Override
    public int compareTo(Complex complex) {
        return COMPARATOR.compare(this, complex);
    }
}
