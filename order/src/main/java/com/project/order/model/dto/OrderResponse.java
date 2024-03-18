package com.project.order.model.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Setter
@Getter
@Builder
public class OrderResponse {

    private long id;
    private String orderNumber;
    private List<OrderItemsDto> orderItemsDto;

    public OrderResponse() {

    }

    public OrderResponse(long id, String orderNumber, List<OrderItemsDto> orderItemsDto) {
        this.id = id;
        this.orderNumber = orderNumber;
        this.orderItemsDto = orderItemsDto;
    }

    @Override
    public String toString() {
        return "OrderResponse{" +
                "id=" + id +
                ", orderNumber='" + orderNumber + '\'' +
                ", orderItemsDto=" + orderItemsDto +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderResponse that = (OrderResponse) o;
        return id == that.id && Objects.equals(orderNumber, that.orderNumber) && Objects.equals(orderItemsDto, that.orderItemsDto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderNumber, orderItemsDto);
    }
}
