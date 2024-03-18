package com.project.order.controller;

import com.project.order.model.dto.OrderRequest;
import com.project.order.model.dto.OrderResponse;
import com.project.order.service.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderServiceImpl orderServiceImpl;

    @Autowired
    public OrderController(OrderServiceImpl orderServiceImpl) {
        this.orderServiceImpl = orderServiceImpl;
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveOrder(@RequestBody OrderRequest orderRequest) {
        orderServiceImpl.saveOrder(orderRequest);
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<OrderResponse> getAllOrders(){
        return orderServiceImpl.getAllOrders();
    }
}
