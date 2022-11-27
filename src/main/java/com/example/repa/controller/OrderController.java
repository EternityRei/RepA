package com.example.repa.controller;


import com.example.repa.dto.OrderDTO;
import com.example.repa.mapper.OrderMapper;
import com.example.repa.model.Order;
import com.example.repa.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @GetMapping()
    public List<OrderDTO> getAllOrders(){
        return OrderMapper.INSTANCE.toOrderDTO(orderService.getAllOrders());
    }

    @GetMapping("/id={id}")
    public OrderDTO getOrderById(@PathVariable("id") long id){
        log.info("getting order by its id : " + id);
        return OrderMapper.INSTANCE.orderToOrderDTO(orderService.getOrderById(id));
    }

    @GetMapping("/user_id={userId}")
    public OrderDTO getOrderByUserId(@PathVariable("userId") long userId){
        log.info("getting order by user id : " + userId);
        return OrderMapper.INSTANCE.orderToOrderDTO(orderService.getOrderByUserId(userId));
    }

    @PostMapping()
    public OrderDTO createOrder(OrderDTO orderDTO){
        log.info("Order creating");
        return OrderMapper.INSTANCE.orderToOrderDTO(orderService.createOrder(OrderMapper.INSTANCE.orderDTOtoOrder(orderDTO)));
    }

    @PutMapping()
    public OrderDTO updateOrder(OrderDTO orderDTO){
        log.info("Order updating : " + orderDTO);
        return OrderMapper.INSTANCE.orderToOrderDTO(orderService.updateOrder(OrderMapper.INSTANCE.orderDTOtoOrder(orderDTO)));
    }

    @DeleteMapping("/id={id}")
    public OrderDTO deleteOrder(@PathVariable("id") long id){
        log.info("Deleting order " + id);
        Order order = orderService.getOrderById(id);
        orderService.deleteOrder(order);
        log.info("Order " + id + " with title " + order.getTitle() + " was deleted");
        return OrderMapper.INSTANCE.orderToOrderDTO(order);
    }
}
