package com.example.repa.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Getter
@Setter
@EqualsAndHashCode
@Component
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private float price;
    @Column(name = "payment_status")
    private PaymentStatus paymentStatus;
    @Column(name = "work_status")
    private WorkStatus workStatus;
    @Column(name = "user_id")
    private long userId;
    @Column(name = "worker_id")
    private long workerId;
    @Column(name = "date_work_add")
    private Timestamp dateWorkAdd;

}
