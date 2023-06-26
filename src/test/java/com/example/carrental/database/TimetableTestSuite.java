package com.example.carrental.database;

import com.example.carrental.entity.Timetable;
import com.example.carrental.repository.TimetableRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
public class TimetableTestSuite {

    @Autowired
    TimetableRepository timetableRepository;

    private final Timetable timetable = new Timetable();

    @Test
    public void testAddTimetable(){
        //Given
        //When
        timetableRepository.save(timetable);
        //Then
        assertEquals(1,timetableRepository.findAll().size());
        //Clean
        timetableRepository.deleteAll();
    }

    @Test
    public void testFindTimetableById(){
        //Given
        timetableRepository.save(timetable);
        Long id = timetable.getId();
        //When
        Optional<Timetable> testTimetable = timetableRepository.findById(id);
        Long testId = testTimetable.get().getId();
        //Then
        assertEquals(id,testId);
        //Clean
        timetableRepository.deleteAll();
    }

    @Test
    public void testFindAllTimetables(){
        //Given
        timetableRepository.save(new Timetable());
        timetableRepository.save(new Timetable());
        timetableRepository.save(new Timetable());
        //When
        List<Timetable> list = timetableRepository.findAll();
        //Then
        assertEquals(3,list.size());
        //Clean
        timetableRepository.deleteAll();
    }
}
