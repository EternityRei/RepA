package com.example.repa.repository;

import com.example.repa.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    Review findByIdIs(long id);
    Review findByUserIdAndOrderId(long userId, long orderId);
    List<Review> findAll();
}
