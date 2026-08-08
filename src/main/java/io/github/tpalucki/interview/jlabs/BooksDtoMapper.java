package io.github.tpalucki.interview.jlabs;

import org.springframework.stereotype.Component;

@Component
class BooksDtoMapper {

    Book toDomain(BookDto bookDto) {
        return new Book(bookDto.title(), bookDto.author());
    }

    public BookDto toDto(Book createdBook) {
        return new BookDto(createdBook.id(), createdBook.title(), createdBook.author());
    }
}
