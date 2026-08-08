package io.github.tpalucki.interview.jlabs;

import org.springframework.stereotype.Service;

@Service
class BooksService implements AddBook, DeleteBooks {

    PersistBook persistBook;


    @Override
    public Book addBook(Book book) {
        persistBook.persist(book);
        return book;
    }

    @Override
    public int delteBooks(String author) {
        return persistBook.deleteByAuthor(author);
    }
}
