package com.example.carrental.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity(name = "cars")
public class Car {

    @Id
    @GeneratedValue
    private long id;

    @Column
    private String brandName;

    @Column
    private String model;

    @ManyToOne
    @JoinColumn(name = "bodyType_id")
    private BodyType bodyType;

    @ManyToOne
    @JoinColumn(name = "fuel_id")
    private Fuel fuel;

    @Column
    private float amOfFuel;

    @Column
    private int numOfPlaces;

    @Column
    private int enPower;

    @Column
    private float pricePerDay;

    @Column
    private String Location;
}
