package com.example.carrental.repository;

import com.example.carrental.entity.Fuel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FuelRepository extends CrudRepository<Fuel,Long> {

    List<Fuel> findAll();

    Fuel save(Fuel fuel);

    Optional<Fuel> findById(Long fuelId);
}
