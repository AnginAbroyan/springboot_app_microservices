package com.project.book.controller;

import com.project.book.model.dto.BookRequest;
import com.project.book.model.dto.BookResponse;
import com.project.book.servce.impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {


    private final BookServiceImpl bookServiceImpl;

    @Autowired
    public BookController(BookServiceImpl bookServiceImpl) {
        this.bookServiceImpl = bookServiceImpl;
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveBook(@RequestBody BookRequest bookRequest) {
        bookServiceImpl.save(bookRequest);
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<BookResponse> getAllBooks(){
        return bookServiceImpl.getAllBooks();
    }

}
