package com.example.carrental.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity(name = "penalties")
public class Penalty {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column
    private float price;

    @JsonBackReference
    @ManyToMany(mappedBy = "penalties")
    private Set<Order> orders;

    public Penalty(Long id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.orders = new HashSet<>();
    }
}
