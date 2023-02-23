package com.example.carrental.repository;

import com.example.carrental.entity.Penalty;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PenaltyRepository extends CrudRepository<Penalty,Long> {

    List<Penalty> findAll();

    Penalty save(Penalty penalty);

    Optional<Penalty> findById(Long penaltyId);
}
