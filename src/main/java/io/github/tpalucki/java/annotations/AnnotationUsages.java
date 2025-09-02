package io.github.tpalucki.java.annotations;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Przykłady użycia napisanych przez nas adnotacji + próba użycia w innym target niz adnotacja zdefiniowana - kompilator odrzuca.
 */

//@SimpleMethodAnnotation // tutaj sie nie da!
@SimpleClassAnnotation
public class AnnotationUsages {

    //    @SimpleMethodAnnotation
    @SimpleFieldAnnotation
    private int field;

    //    @SimpleMethodAnnotation // tutaj sie nie da!
    AnnotationUsages() {
    }

    // tutaj uzywamy sobie simple annotation - zdefiniowana jest z @Target(ElementType.METHOD) wiec mozna uzyc przy metodzie
    @SimpleMethodAnnotation
    void doSth() {
        System.out.println("Annotated lambdaMethod used!");
    }


    /**
     * Check if annotations is present and run
     *
     * @param args
     */
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException {
//        Class<?> aClass = Class.forName(args[0]);
//        Class<?> aClass = Class.forName("AnnotationUsages.class");
        Class<?> aClass = AnnotationUsages.class;
        for (Method m : aClass.getMethods()) {
            if (m.isAnnotationPresent(SimpleMethodAnnotation.class)) {
                m.invoke(null);
            }
        }
    }


    /**
     * To zostanie zgrupowane w adnotacji @RepeatableAnnotations
     */
    @RepeatableAnnotation(IllegalArgumentException.class)
    @RepeatableAnnotation(NullPointerException.class)
    @RepeatableAnnotation(ArrayIndexOutOfBoundsException.class)
    void usageOfRepeatableAnnotations() {
    }
}
