package com.example.carrental.repository;

import com.example.carrental.entity.Calendar;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CalendarRepository extends CrudRepository<Calendar,Long> {

    List<Calendar> findAll();

    Calendar save(Calendar calendar);

    Optional<Calendar> findById(Long calId);
}
