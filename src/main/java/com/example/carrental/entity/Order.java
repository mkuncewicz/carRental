package com.example.carrental.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity(name = "orders")
public class Order {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;


    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    @Column
    private float price;

    @Column
    private float discout;

    @Column
    private Date returnDate;

    @Column
    private String returnLocation;
}
