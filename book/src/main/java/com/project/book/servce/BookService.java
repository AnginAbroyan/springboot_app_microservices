package com.project.book.servce;

import com.project.book.model.dto.BookRequest;
import com.project.book.model.dto.BookResponse;

import java.util.List;


public interface BookService {
    BookRequest getById(long id);

    List<BookResponse> getAllBooks();

    void save(BookRequest bookRequest);

    void update(long id, BookRequest bookRequest);
    void delete(long id);

}
