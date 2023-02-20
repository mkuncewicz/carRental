package com.example.carrental.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class OrderDto {

    private long id;
    private long reservation_id;
    private long car_id;
    private float price;
    private float discout;
    private Date returnDate;
    private String returnLocation;
}
