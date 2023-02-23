package com.example.carrental.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity(name = "accessory")
public class Accessory {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column
    private float price;

    @ManyToMany(mappedBy = "accessories")
    private List<Order> orders;

    public Accessory(Long id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
