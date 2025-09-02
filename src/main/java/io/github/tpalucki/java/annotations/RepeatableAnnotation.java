package io.github.tpalucki.java.annotations;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(RepeatableAnnotations.class)
public @interface RepeatableAnnotation {

    Class<? extends Throwable> value();
}
