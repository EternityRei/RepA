package com.example.repa.service;

import com.example.repa.model.Review;

public interface ReviewService {
    Review createReview(Review review);
    Review updateReview(Review review);
    void deleteReview(Review review);

    Review getReviewById(long id);
    Review getReviewByUserIdAndOrderId(long userId, long orderId);
}
