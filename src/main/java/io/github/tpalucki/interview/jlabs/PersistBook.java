package io.github.tpalucki.interview.jlabs;

public interface PersistBook {
    void persist(Book book);

    int deleteByAuthor(String author);
}
