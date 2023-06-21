package com.example.carrental.nazwadozmiany;

import com.example.carrental.database.DbReservation;
import com.example.carrental.database.DbTimetable;
import com.example.carrental.entity.*;
import com.example.carrental.exceptions.CarNotFoundException;
import com.example.carrental.exceptions.ReservationNotFoundException;
import com.example.carrental.exceptions.TimetableNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class ReservationFacade {

    private final DbReservation dbReservation;
    private final DbTimetable dbTimetable;


    public Reservation addResToTim(long resId, long timId) throws ReservationNotFoundException, TimetableNotFoundException, CarNotFoundException {

        Set<Timetable> timetables = null;
        Timetable timetable = dbTimetable.getDate(timId);
        Reservation reservation = dbReservation.getReservation(resId);

        timetables = reservation.getCalendars();
        timetables.add(timetable);
        reservation.setCalendars(timetables);
        return dbReservation.saveReservation(reservation);

    }

}
