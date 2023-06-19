package com.example.carrental.mapper;

import com.example.carrental.database.DbCar;
import com.example.carrental.domain.ReservationDto;
import com.example.carrental.entity.Reservation;
import com.example.carrental.exceptions.CarNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationMapper {
    @Autowired
    private DbCar dbCar;

    public Reservation mapToReservation(ReservationDto reservationDto) throws CarNotFoundException {
        return new Reservation(reservationDto.getId(),dbCar.getCar(reservationDto.getCar_id()));
    }

    public ReservationDto mapToReservationDto(Reservation reservation){
        return new ReservationDto(reservation.getId(), reservation.getCar().getId());
    }

    public List<ReservationDto> mapToReservationDtoList(final List<Reservation> list){
        return list.stream().
                map(this::mapToReservationDto)
                .collect(Collectors.toList());
    }
}
