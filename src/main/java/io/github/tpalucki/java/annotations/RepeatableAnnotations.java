package io.github.tpalucki.java.annotations;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface RepeatableAnnotations {

    RepeatableAnnotation[] value();
}
