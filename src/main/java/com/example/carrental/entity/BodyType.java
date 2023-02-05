package com.example.carrental.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity(name = "bodytype")
public class BodyType {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "bodyType_id")
    private List<Car> cars;
}
