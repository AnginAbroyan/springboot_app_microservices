package com.project.book.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Setter
@Getter
@Builder
public class BookRequest {

    private String name;
    private String author;
    private String description;
    private double price;

    public BookRequest() {
    }

    public BookRequest(String name, String author, String description, double price) {
        this.name = name;
        this.author = author;
        this.description = description;
        this.price = price;
    }

    @Override
    public String toString() {
        return "BookRequest{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookRequest that = (BookRequest) o;
        return Double.compare(price, that.price) == 0 && Objects.equals(name, that.name) && Objects.equals(author, that.author) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, author, description, price);
    }
}
