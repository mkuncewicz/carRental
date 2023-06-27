package com.example.carrental.facade;

import com.example.carrental.database.DbReservation;
import com.example.carrental.database.DbTimetable;
import com.example.carrental.entity.Car;
import com.example.carrental.entity.Reservation;
import com.example.carrental.entity.Timetable;
import com.example.carrental.exceptions.CarNotFoundException;
import com.example.carrental.exceptions.ReservationNotFoundException;
import com.example.carrental.exceptions.TimetableNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import java.util.Date;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

@SpringBootTest
@Transactional
public class ReservationFacadeTestSuite {

    @Test
    public void testAddResToCal() throws ReservationNotFoundException, TimetableNotFoundException, CarNotFoundException {
        //Given
        Reservation testReservation = new Reservation(1L,new Car());
        Timetable testTimetable = new Timetable(1L,new Date());
        DbReservation dbReservation = mock(DbReservation.class);
        DbTimetable dbTimetable = mock(DbTimetable.class);
        given(dbReservation.getReservation(1L)).willReturn(testReservation);
        given(dbTimetable.getDate(1L)).willReturn(testTimetable);
        given(dbReservation.saveReservation(testReservation)).willReturn(testReservation);
        //When
        ReservationFacade facade = new ReservationFacade(dbReservation,dbTimetable);
        Reservation resultReservation = facade.addResToTim(1L,1L);

        Timetable resultTimetable = resultReservation.getCalendars().stream().findFirst().orElse(null);
        //Then
        assertEquals(testTimetable,resultTimetable);
    }
}
