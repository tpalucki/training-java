package io.github.tpalucki.java.annotations;


import java.lang.annotation.*;

// Te 2 są wymagane inaczej się nie skompiluje
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ExceptionsTest {

    /**
     * Here is the array of element that can be thrown
     */
    Class<? extends Throwable>[] value();


    /**
     * Można też to samo osiągnąć stosująć adnotacje @Repeatable dla @interfece tutaj.
     * Wtedy się wstawi w kodzie tesu kilka adnotacji z różnymi pojedynczymi wyjątkami
     *
     * Popatrz -> RepeatableAnnotation
     */
}
