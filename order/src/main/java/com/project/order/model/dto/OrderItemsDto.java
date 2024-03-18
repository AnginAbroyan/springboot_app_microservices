package com.project.order.model.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Builder
@Setter
@Getter
public class OrderItemsDto {
    private long id;
    private String code;
    private double price;
    private int quantity;

    public OrderItemsDto() {
    }

    public OrderItemsDto(long id, String code, double price, int quantity) {
        this.id = id;
        this.code = code;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderItemsDto{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItemsDto that = (OrderItemsDto) o;
        return id == that.id && Double.compare(price, that.price) == 0 && quantity == that.quantity && Objects.equals(code, that.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, price, quantity);
    }
}
