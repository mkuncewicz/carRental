package com.example.carrental.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

    @Column
    private Date dateStart;
    @Column
    private Date dateEnd;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "reservation_id")
    private List<Order> orders;

    public Reservation(long id, Car car, Date dateStart, Date dateEnd) {
        this.id = id;
        this.car = car;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.orders = new ArrayList<>();
    }
}
