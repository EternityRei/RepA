package com.example.repa.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.sql.Date;

@Getter
@Setter
@EqualsAndHashCode
@Component
@Entity
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;
    @Column(name = "content")
    private String content;
    @Column(name = "rating")
    private float rating;
    @Column(name = "date_work_done")
    private Date dateWorkDone;
    @Column(name = "user_id")
    private long userId;
    @Column(name = "order_id")
    private long orderId;
}
