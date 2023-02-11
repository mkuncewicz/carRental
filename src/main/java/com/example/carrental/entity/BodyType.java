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
@Entity(name = "bodytype")
public class BodyType {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "body_type_id")
    private List<Car> cars;


    public BodyType(long id, String name) {
        this.id = id;
        this.name = name;
        this.cars = new ArrayList<>();
    }
}
