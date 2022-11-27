package com.example.repa.controller;

import com.example.repa.dto.ReviewDTO;
import com.example.repa.exception.EntityNotFoundException;
import com.example.repa.mapper.ReviewMapper;
import com.example.repa.model.Review;
import com.example.repa.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

    @GetMapping("/id={id}")
    public ReviewDTO getReviewById(@PathVariable("id") long id){
        log.info("Getting review by id : " + id);
        Review review = reviewService.getReviewById(id);
        if(review == null){
            throw new EntityNotFoundException("Review by id was not found");
        }
        return ReviewMapper.INSTANCE.reviewToReviewDTO(review);
    }

    @GetMapping("/user_id={userId}?order_id={orderId}")
    public ReviewDTO getReviewByUserIdAndOrderId(@PathVariable("userId") long userId, @PathVariable("orderId") long orderId){
        log.info("Getting review by user id : " + userId + " : and order id  : " + orderId );
        Review review = reviewService.getReviewByUserIdAndOrderId(userId, orderId);
        if(review == null){
            throw new EntityNotFoundException("Review by userId and orderId was not found");
        }
        return ReviewMapper.INSTANCE.reviewToReviewDTO(review);
    }

    @PostMapping()
    public ReviewDTO createReview(ReviewDTO reviewDTO){
        log.info("Creating review " + reviewDTO);
        return ReviewMapper.INSTANCE.reviewToReviewDTO(reviewService.createReview(ReviewMapper.INSTANCE.reviewDTOtoReview(reviewDTO)));
    }

    @PutMapping()
    public ReviewDTO updateReview(ReviewDTO reviewDTO){
        log.info("Updating review : " + reviewDTO);
        return ReviewMapper.INSTANCE.reviewToReviewDTO(reviewService.updateReview(ReviewMapper.INSTANCE.reviewDTOtoReview(reviewDTO)));
    }

    @DeleteMapping("/id={id}")
    public ReviewDTO deleteReview(@PathVariable("id") long id){
        log.info("Deleting review : " + id);
        Review review = reviewService.getReviewById(id);
        if(review == null){
            throw new EntityNotFoundException("Review has not exists already");
        }
        reviewService.deleteReview(review);
        log.info("Review " + id + " for order " + review.getOrderId() + " was deleted");
        return ReviewMapper.INSTANCE.reviewToReviewDTO(review);
    }
}
