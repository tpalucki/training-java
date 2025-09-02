package io.github.tpalucki.java.stack;

public interface Stack {

    void push(Object item);

    Object pop() throws EmptyStackException;
}
