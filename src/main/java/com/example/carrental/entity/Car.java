package com.example.carrental.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity(name = "cars")
public class Car {
//
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
    private String location;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "car_id")
    private List<Reservation> reservations;

    public Car(long id, String brandName, String model, BodyType bodyType, Fuel fuel, float amOfFuel, int numOfPlaces, int enPower, float pricePerDay, String location) {
        this.id = id;
        this.brandName = brandName;
        this.model = model;
        this.bodyType = bodyType;
        this.fuel = fuel;
        this.amOfFuel = amOfFuel;
        this.numOfPlaces = numOfPlaces;
        this.enPower = enPower;
        this.pricePerDay = pricePerDay;
        this.location = location;
        this.reservations = new ArrayList<>();
    }
}
