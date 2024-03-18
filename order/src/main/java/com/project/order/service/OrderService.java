package com.project.order.service;

import com.project.order.model.dto.OrderRequest;
import com.project.order.model.dto.OrderResponse;

import java.util.List;

public interface OrderService {
    OrderRequest getById(long id);

    List<OrderResponse> getAllOrders();

    void saveOrder(OrderRequest orderRequest);

    void updateOrder(long id, OrderRequest orderRequest);
    void deleteOrder(long id);
}
