package com.example.carrental.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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
    @JsonBackReference
    @JoinColumn(name = "body_type_id")
    private BodyType bodyType;

    @ManyToOne
    @JsonBackReference
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

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "car_id")
    private List<Reservation> reservations;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "car_id")
    private List<Order> orders;

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
        this.orders = new ArrayList<>();
    }

}
