package com.example.carrental.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ReservationDto {

    private long id;
    private Long car_id;
    private Date dateStart;
    private Date dateEnd;

}
