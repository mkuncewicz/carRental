package com.example.carrental.repository;

import com.example.carrental.entity.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends CrudRepository<Order, Long> {

    List<Order> findAll();

    Order save(Order order);

    Optional<Order> findById(Long orderId);
}
