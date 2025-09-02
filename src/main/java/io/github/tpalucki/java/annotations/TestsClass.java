package io.github.tpalucki.java.annotations;

public class TestsClass {


    /**
     * Should pass
     */
    @ExceptionTest(value = IllegalArgumentException.class)
    void successTestMethod() {
        throw new IllegalArgumentException();
    }

    /**
     * Should fail
     */
    @ExceptionTest(value = IllegalArgumentException.class)
    void failingTestMethod() {
    }

    void notAnnotatedMethod() {

    }

    void NotAnnotatedMethod2() {

    }

    @SimpleMethodAnnotation
    void otherAnnotationMethod() {

    }

    @ExceptionsTest({
            IllegalArgumentException.class,
            ArrayIndexOutOfBoundsException.class
    })
    void usageForExceptionsClass() {

    }
}
