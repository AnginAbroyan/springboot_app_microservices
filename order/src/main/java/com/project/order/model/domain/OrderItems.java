package com.project.order.model.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "table_order_items")
@Setter
@Getter
public class OrderItems {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String code;
    private double price;
    private long quantity;


    public OrderItems() {
    }

    public OrderItems(long id, String code, double price, long quantity) {
        this.id = id;
        this.code = code;
        this.price = price;
        this.quantity = quantity;
    }
}
