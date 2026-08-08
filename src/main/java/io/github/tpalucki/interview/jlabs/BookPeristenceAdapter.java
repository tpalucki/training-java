package io.github.tpalucki.interview.jlabs;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class BookPeristenceAdapter implements PersistBook {

    private Map<String, Book> booksById = new HashMap<>();
    private Map<String, List<String>> booksByAuthor = new HashMap<>();

    @Override
    public void persist(Book book) {
        if (booksById.containsKey(book.id)) {
            throw new IllegalStateException("Book id already exists: " + book.id);
        } else {
            booksById.put(book.id, book);
            booksByAuthor.computeIfAbsent(book.author(), k -> new java.util.ArrayList<>()).add(book.id());
        }
    }

    @Override
    public int deleteByAuthor(String author) {
        if (booksById.containsKey(author)) { // O(1)
            var booksIds = booksByAuthor.get(author);
            int booksOfAuthorCount = booksIds.size(); // O(1)
            booksByAuthor.remove(author);

            for(String booksId : booksIds) {
                booksById.remove(booksId);
            }
            return booksOfAuthorCount;
        }
        return 0;
    }
}
