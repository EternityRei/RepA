package com.example.repa.service;

import com.example.repa.model.Order;

import java.util.List;

public interface OrderService {
    Order createOrder(Order order);
    Order updateOrder(Order order);
    void deleteOrder(Order order);

    Order getOrderById(long id);
    Order getOrderByUserId(long userId);
    List<Order> getAllOrders();
}
