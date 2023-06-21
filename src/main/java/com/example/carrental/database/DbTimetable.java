package com.example.carrental.database;

import com.example.carrental.entity.Timetable;
import com.example.carrental.exceptions.TimetableNotFoundException;
import com.example.carrental.repository.TimetableRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DbTimetable {

    private final TimetableRepository timetableRepository;

    public List<Timetable> getAllDates(){
        return timetableRepository.findAll();
    }

    public Timetable getDate(Long calId) throws TimetableNotFoundException {
        return timetableRepository.findById(calId).orElseThrow(TimetableNotFoundException::new);
    }

    public Timetable saveTimetable(Timetable calendar) throws TimetableNotFoundException {
        Timetable saveCalendar = timetableRepository.save(calendar);
        return saveCalendar;
    }

    public void deleteTimetable(long calId){
        timetableRepository.deleteById(calId);
    }
}
