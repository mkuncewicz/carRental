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
@Entity(name = "calendar")
public class Calendar {

    @Id
    @GeneratedValue
    private long id;

    @Column
    private Date date;

    @ManyToMany(mappedBy = "calendars")
    private List<Reservation> reservations;


    public Calendar(long id, Date date) {
        this.id = id;
        this.date = date;
        this.reservations = new ArrayList<>();
    }
}
