package com.example.repa.repository;

import com.example.repa.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
    Order findByUserId(long userId);
    Order findByIdIs(long id);

    List<Order> findAll();
}
