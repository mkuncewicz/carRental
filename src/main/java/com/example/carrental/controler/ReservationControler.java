package com.example.carrental.controler;

import com.example.carrental.database.DbReservation;
import com.example.carrental.domain.ReservationDto;
import com.example.carrental.entity.Reservation;
import com.example.carrental.exceptions.CarNotFoundException;
import com.example.carrental.exceptions.ReservationNotFoundException;
import com.example.carrental.mapper.ReservationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/v1/reser")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ReservationControler {

    private final DbReservation dbReservation;
    private final ReservationMapper reservationMapper;

    @GetMapping
    public ResponseEntity<List<ReservationDto>> getAllReservations(){
        System.out.println("Get All Reservations");

        return ResponseEntity.ok(reservationMapper.mapToReservationDtoList(dbReservation.getAllReservations()));
    }

    @GetMapping(value = "{resId}")
    public ResponseEntity<ReservationDto> getReservation(@PathVariable long resId) throws ReservationNotFoundException {
        System.out.println("Get Reservation");
        return ResponseEntity.ok(reservationMapper.mapToReservationDto(dbReservation.getReservation(resId)));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createReservation(@RequestBody ReservationDto reservationDto) throws CarNotFoundException {
        System.out.println("Create Reservation");

        dbReservation.saveReservation(reservationMapper.mapToReservation(reservationDto));
        return ResponseEntity.ok().build();
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ReservationDto> updateReservation(@RequestBody ReservationDto reservationDto) throws CarNotFoundException{
        System.out.println("Update Reservation");

        Reservation reservation = reservationMapper.mapToReservation(reservationDto);
        Reservation saveReservation = dbReservation.saveReservation(reservation);

        return ResponseEntity.ok(reservationMapper.mapToReservationDto(saveReservation));
    }
    @DeleteMapping(value = "{reservationId}")
    public ResponseEntity<Void> deleteBodyType(@PathVariable long reservationId){
        System.out.println("Delete Reservation");

        dbReservation.deleteReservation(reservationId);

        return ResponseEntity.ok().build();
    }
}
