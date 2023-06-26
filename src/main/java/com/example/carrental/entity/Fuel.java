package com.example.carrental.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "fuels")
public class Fuel {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column
    private float price;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fuel_id")
    private List<Car> cars;

    public Fuel(long id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.cars = new ArrayList<>();
    }
}
