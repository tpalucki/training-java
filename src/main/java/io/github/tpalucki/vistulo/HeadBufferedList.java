package io.github.tpalucki.vistulo;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

interface IntegerStore {
    void add(Integer value);

    void remove(int n);

    List<Integer> toList();
}

public class HeadBufferedList implements IntegerStore {

    public HeadBufferedList(int bufferSize) {
        this.bufferSize = bufferSize;
        this.head = new LinkedList<>();
        this.tail = new LinkedList<>();
    }

    private final int bufferSize;
    private final List<Integer> head;
    private final List<Integer> tail;

    @Override
    public void add(Integer value) {
        if (head.size() < bufferSize) {
            head.add(value);
        } else {
            tail.addAll(head);
            head.clear();
            head.add(value);
        }
    }

    @Override
    public void remove(int n) {
        if (n < head.size()) {
            head.remove(n);
        }
        if (n > head.size() &&
                n < head.size() + tail.size()) {
            tail.remove(n - head.size());
        }
    }

    @Override
    public List<Integer> toList() {
        return Stream
                .concat(head.stream(), tail.stream())
                .collect(Collectors.toList());
    }
}
