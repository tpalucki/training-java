package io.github.tpalucki.java.exceptions;

import java.util.Random;

public class ExceptionsSample {

    /**
     * This method throws checked exception - it has to be declared
     *
     * @throws MyCheckedException
     */
    public ExceptionsSample() throws MyCheckedException {
        if (new Random().nextBoolean())
            throw new MyCheckedException();
        /**
         * Unchecked exception doesn't have to be declared
         */
        throw new MyUncheckedException();
    }

    public static void main(String[] args) {

        try {
            new ExceptionsSample();
        } catch (MyCheckedException e) {
            System.out.println("e = " + e);
            // checked exception has to be catched
//            throw new RuntimeException(e);
        }
    }
}