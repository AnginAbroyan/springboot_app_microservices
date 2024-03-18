package com.project.order.model.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "table_orders")
@Builder
@Setter
@Getter
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String orderNumber;

    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderItems> orderItemsList;



    public OrderEntity() {
    }

    public OrderEntity(long id, String orderNumber, List<OrderItems> orderItemsList) {
        this.id = id;
        this.orderNumber = orderNumber;
        this.orderItemsList = orderItemsList;
    }
}
