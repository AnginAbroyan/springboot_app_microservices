package com.project.order.service.impl;

import com.project.order.model.domain.OrderEntity;
import com.project.order.model.domain.OrderItems;
import com.project.order.model.dto.OrderItemsDto;
import com.project.order.model.dto.OrderRequest;
import com.project.order.model.dto.OrderResponse;
import com.project.order.repository.OrderRepository;
import com.project.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
@Slf4j
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public OrderRequest getById(long id) {
        return null;
    }

    @Override
    public List<OrderResponse> getAllOrders() {
        return null;
    }

    @Override
    public void saveOrder(OrderRequest orderRequest) {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setOrderNumber(UUID.randomUUID().toString());
        List<OrderItems> orderItems = orderRequest.getOrderItemsDto().stream()
                .map(this::mapToDto)
                .toList();
        orderEntity.setOrderItemsList(orderItems);
        orderRepository.save(orderEntity);
        log.info("Order with id number {} has been saved. ", orderEntity.getId());
    }

    private OrderItems mapToDto(OrderItemsDto orderItemsDto) {
        OrderItems orderItems = new OrderItems();
        orderItems.setPrice(orderItemsDto.getPrice());
        orderItems.setQuantity(orderItemsDto.getQuantity());
        orderItems.setCode(orderItemsDto.getCode());
        return orderItems;
    }

    @Override
    public void updateOrder(long id, OrderRequest orderRequest) {

    }

    @Override
    public void deleteOrder(long id) {

    }
}
