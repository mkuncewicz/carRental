package com.example.carrental.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CarDto {

    private long id;
    private String brandName;
    private String model;
    private long bodyType_id;
    private long fuel_id;
    private float amOfFuel;
    private int numOfPlaces;
    private int enPower;
    private float pricePerDay;
    private String Location;

}
