package io.github.tpalucki.java.annotations;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;

public class TestClassRunner {

    /**
     * Reflection framework usage to run test classes
     *
     * @param args
     * @throws ClassNotFoundException
     */
    public static void main(String[] args) throws ClassNotFoundException {
//        Class<?> aClass = Class.forName(TestsClass.class.getName());
        String className = "io.github.tpalucki.annotations.TestsClass"; // tutaj istotne - nazwa razem z paczką
        Class<?> aClass = Class.forName(className);

        int passed = 0;
        int iterations = 0;

        TestsClass c = new TestsClass();

        for (Method m : aClass.getDeclaredMethods()) {
            iterations++;
            // wyciagamy metody z klasy
            // odpalamu kazdą metodę która jest oznaczona ExteptionTest

            // HINT: updated to cover @Repeatablel annotations
            if (m.isAnnotationPresent(ExceptionTest.class)
                    || m.isAnnotationPresent(RepeatableAnnotation.class) || m.isAnnotationPresent(RepeatableAnnotations.class)
            ) {
                try {
                    /**
                     * Bardzo ważne - przekazujemy jako argument obiekt na którym ma być wywołana metoda - nawet logiczne,
                     * Metoda nie jest statyczna wiec na czym miałoby to być wywołane. Przecież wyciągneliśmy referencje do klasy
                     * po nazwie klasy, a nie po obiekcie...
                     * można przekazać null jeśli są metody statyczne
                     */
                    m.invoke(c);
                    m.invoke(null);
                    System.out.println("Test failed - no exception.");
                } catch (InvocationTargetException wrappedException) {
                    Throwable cause = wrappedException.getCause();
                    Class<? extends Throwable> excType = m.getAnnotation(ExceptionTest.class).value();

                    if (excType.isInstance(cause)) {
                        passed++;
                    } else {
                        System.out.printf("Test %s failed: expected %s, got %s%n", m, excType.getName(), cause);
                    }
                } catch (IllegalAccessException e) {
                    System.out.printf("Invalid @Test: %s", m);
                }
            }
        }

        System.out.printf("Iterations: %d\n", iterations);
        System.out.printf("Results: passed - %d\n", passed);


        System.out.println("" + 1 + 2);

        var big = new BigDecimal(1000000);
        System.out.println("big = " + big);

        var big2 = new BigDecimal("1000");
        System.out.println("big = " + big2);
    }
}
