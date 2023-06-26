package com.example.carrental.database;

import com.example.carrental.entity.Reservation;
import com.example.carrental.repository.ReservationRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
public class ReservationTestSuite {

    @Autowired
    ReservationRepository reservationRepository;

    private final Reservation reservation = new Reservation();

    @Test
    public void testAddReservation(){
        //Given
        //When
        reservationRepository.save(reservation);
        //Then
        assertEquals(1,reservationRepository.findAll().size());
        //Clean
        reservationRepository.deleteAll();
    }

    @Test
    public void testFindReservationById(){
        //Given
        reservationRepository.save(reservation);
        Long id = reservation.getId();
        //When
        Optional<Reservation> testReservation = reservationRepository.findById(id);
        Long result = testReservation.get().getId();
        //Then
        assertEquals(id,result);
        //Clean
        reservationRepository.deleteAll();
    }

    @Test
    public void testFindAllReservations(){
        //Given
        reservationRepository.save(new Reservation());
        reservationRepository.save(new Reservation());
        reservationRepository.save(new Reservation());
        //When
        List<Reservation> list = reservationRepository.findAll();
        //Then
        assertEquals(3,list.size());
        //Clean
        reservationRepository.deleteAll();
    }
}
