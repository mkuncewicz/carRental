package com.example.carrental.database;

import com.example.carrental.entity.Calendar;
import com.example.carrental.exceptions.CalendarNotFoundException;
import com.example.carrental.exceptions.CarNotFoundException;
import com.example.carrental.repository.CalendarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DbCalendar {

    private final CalendarRepository calendarRepository;

    public List<Calendar> getAllDates(){
        return calendarRepository.findAll();
    }

    public Calendar getDate(Long calId) throws CalendarNotFoundException {
        return calendarRepository.findById(calId).orElseThrow(CalendarNotFoundException::new);
    }

    public Calendar saveCalendar (Calendar calendar) throws CalendarNotFoundException {
        Calendar saveCalendar = calendarRepository.save(calendar);
        return saveCalendar;
    }

    public void deleteCalendar(long calId){
        calendarRepository.deleteById(calId);
    }
}
