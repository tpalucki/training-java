package io.github.tpalucki.interview.jlabs;


import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
public class BooksController {

    AddBook addBookUseCase;
    DeleteBooks deleteBooksUseCase;

    BooksDtoMapper mapper;

    @PostMapping("/v1/books")
    @ResponseStatus(code = CREATED)
    public BookDto addBook(BookDto book) {
        // validate
        var createdBook = addBookUseCase.addBook(mapper.toDomain(book));

        return mapper.toDto(createdBook);
    }

    //    / DELETE /v1/books?author={author}
    @DeleteMapping("/v1/books")
    public DeletedBooksDto deleteBooksByAuthor(@RequestParam String author) {
        var deletedBooksCount = deleteBooksUseCase.delteBooks(author);
        return new DeletedBooksDto(deletedBooksCount);
    }
}

