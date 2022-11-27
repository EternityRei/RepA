package com.example.repa.dto;

import com.example.repa.model.PaymentStatus;
import com.example.repa.model.WorkStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    private long id;
    private String title;
    private String description;
    private float price;
    private PaymentStatus paymentStatus;
    private WorkStatus workStatus;
    private long userId;
    private long workerId;
    private Timestamp dateWorkAdd;
}
