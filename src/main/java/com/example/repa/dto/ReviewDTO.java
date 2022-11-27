package com.example.repa.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDTO {
    private long id;
    private String content;
    private float rating;
    private Date dateWorkDone;
    private long userId;
    private long orderId;
}
