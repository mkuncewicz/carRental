package com.example.carrental.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity(name = "reservations")
public class Reservation {
    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;


    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "reservation_id")
    private List<Order> orders;


    @ManyToMany
    @JoinTable(
            name = "reservation_calendars",
            joinColumns = @JoinColumn(name = "reservation_id"),
            inverseJoinColumns = @JoinColumn(name = "calendar_id")
    )
    private List<Calendar> calendars;

    public Reservation(long id, Car car) {
        this.id = id;
        this.car = car;
        this.orders = new ArrayList<>();
    }
}
