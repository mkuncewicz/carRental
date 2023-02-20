package com.example.carrental.database;

import com.example.carrental.entity.Order;
import com.example.carrental.exceptions.CarNotFoundException;
import com.example.carrental.exceptions.OrderNotFoundException;
import com.example.carrental.exceptions.ReservationNotFoundException;
import com.example.carrental.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DbOrder {

    private final OrderRepository orderRepository;

    private final DbCar dbCar;
    private final DbReservation dbReservation;

    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    public Order getOrder(long orderId) throws OrderNotFoundException {
        return orderRepository.findById(orderId).orElseThrow(OrderNotFoundException::new);
    }

    public Order saveOrder(Order order) throws CarNotFoundException, ReservationNotFoundException {

        long carId = order.getCar().getId();
        long reservationId = order.getReservation().getId();
        Order saveOrder = orderRepository.save(order);

        dbCar.getCar(carId).getOrders().add(saveOrder);
        dbReservation.getReservation(reservationId).getOrders().add(saveOrder);

        return saveOrder;
    }

    public void deleteOrder(long id){
        orderRepository.deleteById(id);
    }
}
