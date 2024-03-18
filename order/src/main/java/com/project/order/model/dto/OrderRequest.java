package com.project.order.model.dto;

import com.project.order.model.domain.OrderItems;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Setter
@Getter
@Builder
public class OrderRequest {
    private String orderNumber;
    private List<OrderItemsDto> orderItemsDto;

    public OrderRequest() {
    }

    public OrderRequest(String orderNumber, List<OrderItemsDto> orderItemsDto) {
        this.orderNumber = orderNumber;
        this.orderItemsDto = orderItemsDto;
    }

    @Override
    public String toString() {
        return "OrderRequest{" +
                "orderNumber='" + orderNumber + '\'' +
                ", orderItemsDto=" + orderItemsDto +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderRequest that = (OrderRequest) o;
        return Objects.equals(orderNumber, that.orderNumber) && Objects.equals(orderItemsDto, that.orderItemsDto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderNumber, orderItemsDto);
    }
}
