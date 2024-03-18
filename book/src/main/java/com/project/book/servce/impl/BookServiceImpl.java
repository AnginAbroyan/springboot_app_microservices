package com.project.book.servce.impl;

import com.project.book.model.domain.BookEntity;
import com.project.book.model.dto.BookRequest;
import com.project.book.model.dto.BookResponse;
import com.project.book.repository.BookRepository;
import com.project.book.servce.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    //TODO
    @Override
    public BookRequest getById(long id) {
        return null;
    }

    @Override
    public List<BookResponse> getAllBooks() {
        List<BookEntity> books = bookRepository.findAll();
        List<BookResponse> bookResponseList = books.stream().map(this::mapToBookResponse).toList();
        log.info("GetAllBooks method passed in BookServiceImpl class");
        return bookResponseList;
    }

    private BookResponse mapToBookResponse(BookEntity bookEntity) {
        return BookResponse.builder()
                .id(bookEntity.getId())
                .name(bookEntity.getName())
                .author(bookEntity.getAuthor())
                .description(bookEntity.getDescription())
                .price(bookEntity.getPrice())
                .build();
    }

    public void save(BookRequest bookRequest) {
        BookEntity bookEntity = BookEntity.builder()
                .name(bookRequest.getName())
                .author(bookRequest.getAuthor())
                .description(bookRequest.getDescription())
                .price(bookRequest.getPrice())
                .build();
        bookRepository.save(bookEntity);
        log.info("Book with id number {} has been saved. ", bookEntity.getId());
    }
    //TODO
    @Override
    public void update(long id, BookRequest bookRequest) {

    }
    //TODO
    @Override
    public void delete(long id) {

    }
}
