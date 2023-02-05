package com.example.carrental.repository;

import com.example.carrental.entity.BodyType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BodyTypeRepository extends CrudRepository<BodyType,Long> {

    List<BodyType> findAll();

    BodyType save(BodyType bodyType);

    Optional<BodyType> findById(Long bodyId);
}
