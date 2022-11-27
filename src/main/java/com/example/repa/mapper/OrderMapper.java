package com.example.repa.mapper;

import com.example.repa.dto.OrderDTO;
import com.example.repa.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    @Mapping(target = "id", source = "id", ignore = false)
    OrderDTO orderToOrderDTO(Order order);

    @Mapping(target = "id", ignore = false)
    Order orderDTOtoOrder(OrderDTO orderDTO);

    List<OrderDTO> toOrderDTO(List<Order> allOrders);
}