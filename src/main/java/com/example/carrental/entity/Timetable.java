package com.example.carrental.entity;

import lombok.*;

import javax.persistence.*;
import java.util.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity(name = "calendar")
public class Timetable {

    @Id
    @GeneratedValue
    private long id;

    @Column
    private Date date;

    @Setter
    @ManyToMany(mappedBy = "calendars")
    private Set<Reservation> reservations = new HashSet<>();


    public Timetable(long id, Date date) {
        this.id = id;
        this.date = date;
    }
}
