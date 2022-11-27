package com.example.repa.service.impl;

import com.example.repa.model.Review;
import com.example.repa.repository.ReviewRepository;
import com.example.repa.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Review createReview(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public Review updateReview(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public void deleteReview(Review review) {
        reviewRepository.delete(review);
    }

    @Override
    public Review getReviewById(long id) {
        return reviewRepository.findByIdIs(id);
    }

    @Override
    public Review getReviewByUserIdAndOrderId(long userId, long orderId) {
        return reviewRepository.findByUserIdAndOrderId(userId, orderId);
    }
}
