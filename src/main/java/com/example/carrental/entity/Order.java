package com.example.carrental.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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


    @ManyToMany(fetch = FetchType.EAGER)
    @Setter
    @JoinTable(
            name = "order_acces",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "acces_id")
    )
    private Set<Accessory> accessories = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @Setter
    @JoinTable(
            name = "order_pen",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "pen_id")
    )
    private Set<Penalty> penalties = new HashSet<>();

    public Order(Long id, Reservation reservation, Car car, float price, float discout, Date returnDate, String returnLocation) {
        this.id = id;
        this.reservation = reservation;
        this.car = car;
        this.price = price;
        this.discout = discout;
        this.returnDate = returnDate;
        this.returnLocation = returnLocation;
    }
}
