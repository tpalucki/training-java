package io.github.tpalucki.java.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@interface SimpleFieldAnnotation {
}

@Target(ElementType.CONSTRUCTOR)
@interface PrivateAnnotation {

}