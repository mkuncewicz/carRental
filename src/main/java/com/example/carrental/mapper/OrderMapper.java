package com.example.carrental.mapper;

import com.example.carrental.database.DbCar;
import com.example.carrental.database.DbReservation;
import com.example.carrental.domain.OrderDto;
import com.example.carrental.entity.Order;
import com.example.carrental.exceptions.CarNotFoundException;
import com.example.carrental.exceptions.ReservationNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderMapper {

    @Autowired
    private DbReservation reservation;

    @Autowired
    private DbCar dbCar;

    public Order mapToOrder(OrderDto orderDto) throws ReservationNotFoundException, CarNotFoundException {

        return new Order(orderDto.getId(), reservation.getReservation(orderDto.getReservation_id()),dbCar.getCar(orderDto.getCar_id()),
                orderDto.getPrice(), orderDto.getDiscout(), orderDto.getReturnDate(), orderDto.getReturnLocation());
    }

    public OrderDto mapToOrderDto(Order order){

        return new OrderDto(order.getId(), order.getReservation().getId(),order.getCar().getId(),order.getPrice(), order.getDiscout(),
                order.getReturnDate(), order.getReturnLocation());
    }

    public List<OrderDto> mapToListDto(List<Order> list){

        return list.stream()
                .map(this::mapToOrderDto)
                .collect(Collectors.toList());
    }
}
