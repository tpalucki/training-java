package io.github.tpalucki.interview.jlabs;

import java.util.UUID;

public class Book {

    String id;
    String title;
    String author;

    public Book(String title, String author) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.author = author;
    }

    public String id() {
        return id;
    }

    public String title() {
        return title;
    }

    public String author() {
        return author;
    }
}
