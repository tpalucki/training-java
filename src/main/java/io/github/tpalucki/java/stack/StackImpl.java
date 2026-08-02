package io.github.tpalucki.java.stack;


import java.util.Arrays;

public class StackImpl implements Stack {


    private Object[] elements;
    private int size;
    private static final int INITIAL_CAPACITY = 16;

    public StackImpl() {
        this.elements = new Object[INITIAL_CAPACITY];
    }

    @Override
    public void push(Object item) {
        this.ensureCapacity();
        this.elements[size++] = item;
    }

    /**
     * We ensure that pop is not leaking by nulling reference to element we pop
     *
     * @return removed top element
     */
    @Override
    public Object pop() throws EmptyStackException {
        if (size == 0) {
            throw new EmptyStackException();
        }
        Object result = this.elements[--size];
        this.elements[size] = null; // Eliminate obsolete reference
        return result;
    }

    private void ensureCapacity() {
        if (this.elements.length == size + 1) {
            this.elements = Arrays.copyOf(this.elements, 2 * this.elements.length);
        }
    }
}
