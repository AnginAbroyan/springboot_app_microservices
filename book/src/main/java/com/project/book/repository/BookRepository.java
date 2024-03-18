package com.project.book.repository;

import com.project.book.model.domain.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  BookRepository extends JpaRepository<BookEntity, Long> {
}
