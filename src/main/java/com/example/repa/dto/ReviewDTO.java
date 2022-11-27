package com.example.repa.dto;

import javax.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDTO {
    private long id;
    @NotNull
    private String content;
    @NotNull
    @Size(min = 1, message = "Minimum rating is 1")
    private float rating;
    private Date dateWorkDone;
    private long userId;
    private long orderId;
}
