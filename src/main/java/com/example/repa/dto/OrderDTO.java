package com.example.repa.dto;

import com.example.repa.model.PaymentStatus;
import com.example.repa.model.WorkStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    private long id;
    @NotNull
    private String title;
    @NotNull
    @Size(min = 10, message = "order description must be at least 10 characters")
    private String description;
    private float price;
    private PaymentStatus paymentStatus;
    private WorkStatus workStatus;
    private long userId;
    private long workerId;
    private Timestamp dateWorkAdd;
}
