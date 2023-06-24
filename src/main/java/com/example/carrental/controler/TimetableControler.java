package com.example.carrental.controler;

import com.example.carrental.database.DbTimetable;
import com.example.carrental.domain.TimetableDto;
import com.example.carrental.entity.Timetable;
import com.example.carrental.exceptions.CarNotFoundException;
import com.example.carrental.exceptions.ReservationNotFoundException;
import com.example.carrental.exceptions.TimetableNotFoundException;
import com.example.carrental.mapper.TimetableMapper;
import com.example.carrental.nazwadozmiany.ReservationFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/calendar")
@RequiredArgsConstructor
@CrossOrigin("*")
public class TimetableControler {

    private final DbTimetable dbTimetable;
    private final TimetableMapper timetableMapper;

    private final ReservationFacade reservationFacade;

    @GetMapping
    public ResponseEntity<List<TimetableDto>> getAllTimetables(){
        System.out.println("Get all timetables");

        return ResponseEntity.ok(timetableMapper.mapToCalendarDtoList(dbTimetable.getAllDates()));
    }

    @GetMapping(value = "{calId}")
    public ResponseEntity<TimetableDto> getTimetable(@PathVariable long calId) throws TimetableNotFoundException {
        System.out.println("Get Timetable");

        return ResponseEntity.ok(timetableMapper.mapToCalendarDto(dbTimetable.getDate(calId)));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createTimetable(@RequestBody TimetableDto timetableDto) throws TimetableNotFoundException {
        System.out.println("Create Timetable");
        dbTimetable.saveTimetable(timetableMapper.mapToCalendar(timetableDto));

        return ResponseEntity.ok().build();
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TimetableDto> updateTimetable(@RequestBody TimetableDto timetableDto) throws TimetableNotFoundException {
        System.out.println("Update Timetable");
        Timetable timetable = timetableMapper.mapToCalendar(timetableDto);
        Timetable saveTimetable = dbTimetable.saveTimetable(timetable);

        return ResponseEntity.ok(timetableMapper.mapToCalendarDto(saveTimetable));
    }
    @DeleteMapping(value = "{timlId}")
    public ResponseEntity<Void> deleteTimetable(@PathVariable long timId){
        System.out.println("Delete Timetable");
        dbTimetable.deleteTimetable(timId);
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/{resId}/{timId}")
    public ResponseEntity<Void> addResToTim(@PathVariable long resId, @PathVariable long timId) throws ReservationNotFoundException, TimetableNotFoundException, CarNotFoundException {
        System.out.println("Res_Tim");
        reservationFacade.addResToTim(resId,timId);
        return ResponseEntity.ok().build();
    }
}
