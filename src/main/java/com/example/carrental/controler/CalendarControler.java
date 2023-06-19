package com.example.carrental.controler;

import com.example.carrental.database.DbAccessory;
import com.example.carrental.database.DbCalendar;
import com.example.carrental.domain.AccessoryDto;
import com.example.carrental.domain.CalendarDto;
import com.example.carrental.entity.Accessory;
import com.example.carrental.entity.Calendar;
import com.example.carrental.exceptions.AccessoryNotFoundException;
import com.example.carrental.exceptions.CalendarNotFoundException;
import com.example.carrental.exceptions.CarNotFoundException;
import com.example.carrental.mapper.AccessoryMapper;
import com.example.carrental.mapper.CalendarMapper;
import com.example.carrental.nazwadozmiany.OrderFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/calendar")
@RequiredArgsConstructor
@CrossOrigin("*")
public class CalendarControler {

    private final DbCalendar dbCalendar;
    private final CalendarMapper calendarMapper;


    @GetMapping
    public ResponseEntity<List<CalendarDto>> getAllCalendars(){
        System.out.println("Get all calendars");

        return ResponseEntity.ok(calendarMapper.mapToCalendarDtoList(dbCalendar.getAllDates()));
    }

    @GetMapping(value = "{calId}")
    public ResponseEntity<CalendarDto> getCarlendar(@PathVariable long calId) throws CalendarNotFoundException {
        System.out.println("Get Calendar");

        return ResponseEntity.ok(calendarMapper.mapToCalendarDto(dbCalendar.getDate(calId)));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createCalendar(@RequestBody CalendarDto calendarDto) throws CalendarNotFoundException{
        System.out.println("Create calendar");
        dbCalendar.saveCalendar(calendarMapper.mapToCalendar(calendarDto));

        return ResponseEntity.ok().build();
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CalendarDto> updateCalendar(@RequestBody CalendarDto calendarDto) throws CalendarNotFoundException{
        System.out.println("Update Calendar");
        Calendar calendar = calendarMapper.mapToCalendar(calendarDto);
        Calendar saveCalendar = dbCalendar.saveCalendar(calendar);

        return ResponseEntity.ok(calendarMapper.mapToCalendarDto(saveCalendar));
    }
    @DeleteMapping(value = "{calId}")
    public ResponseEntity<Void> deleteCalendar(@PathVariable long calId){
        System.out.println("Delete Calendar");
        dbCalendar.deleteCalendar(calId);
        return ResponseEntity.ok().build();
    }
}
