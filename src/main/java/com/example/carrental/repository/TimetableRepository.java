package com.example.carrental.repository;

import com.example.carrental.entity.Timetable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface TimetableRepository extends CrudRepository<Timetable,Long> {

    List<Timetable> findAll();

    Timetable save(Timetable calendar);

    Optional<Timetable> findById(Long calId);
}
