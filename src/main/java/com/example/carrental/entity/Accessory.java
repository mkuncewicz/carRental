package com.example.carrental.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "accessory")
public class Accessory {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column
    private float price;

    @JsonBackReference
    @ManyToMany(mappedBy = "accessories")
    private Set<Order> orders;

    public Accessory(Long id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.orders = new HashSet<>();
    }
}
