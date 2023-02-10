package com.example.carrental.repository;

import com.example.carrental.entity.Reservation;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ReservationRepository extends CrudRepository<Reservation, Long> {

    List<Reservation> findAll();

    Reservation save(Reservation reservation);

    Optional<Reservation> findById(Long reservationId);
}

