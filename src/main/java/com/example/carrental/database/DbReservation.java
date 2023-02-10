package com.example.carrental.database;

import com.example.carrental.entity.Car;
import com.example.carrental.entity.Reservation;
import com.example.carrental.exceptions.BodyTypeNotFoundException;
import com.example.carrental.exceptions.CarNotFoundException;
import com.example.carrental.exceptions.FuelNotFoundException;
import com.example.carrental.exceptions.ReservationNotFoundException;
import com.example.carrental.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DbReservation {

    private final ReservationRepository repository;
    private final DbCar dbCar;


    public List<Reservation> getAllReservations(){
        return repository.findAll();
    }

    public Reservation getReservation(Long resId) throws ReservationNotFoundException {
        return repository.findById(resId).orElseThrow(ReservationNotFoundException::new);
    }

    public Reservation saveReservation (Reservation reservation) throws CarNotFoundException{
        long carId = reservation.getCar().getId();
        dbCar.getCar(carId).getReservations().add(reservation);

        return saveReservation(reservation);
    }

    public void deleteReservation(long resId){
        repository.deleteById(resId);
    }
}
