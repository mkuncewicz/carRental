package com.example.carrental.repository;

import com.example.carrental.entity.Car;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CarRepository extends CrudRepository<Car,Long> {

    List<Car> findAll();

    Car save(Car car);

    Optional<Car> findById(Long carId);
}
