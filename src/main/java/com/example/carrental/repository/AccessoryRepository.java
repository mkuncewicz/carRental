package com.example.carrental.repository;

import com.example.carrental.entity.Accessory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccessoryRepository extends CrudRepository<Accessory, Long> {

    List<Accessory> findAll();

    Accessory save(Accessory accessory);

    Optional<Accessory> findById(Long accessoryId);
}
