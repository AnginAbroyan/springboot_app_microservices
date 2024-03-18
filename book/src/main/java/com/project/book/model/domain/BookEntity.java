package com.project.book.model.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "book")
@Builder
@Setter
@Getter
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    private String name;

    private String author;

    private String description;

    private double price;

    public BookEntity(){}

    public BookEntity(long id, String name, String author, String description, double price) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.description = description;
        this.price = price;
    }

}
