package com.example.carrental.nazwadozmiany;

import com.example.carrental.entity.Accessory;
import com.example.carrental.entity.Order;
import com.example.carrental.exceptions.AccessoryNotFoundException;
import com.example.carrental.exceptions.CarNotFoundException;
import com.example.carrental.exceptions.OrderNotFoundException;
import com.example.carrental.exceptions.ReservationNotFoundException;
import com.example.carrental.repository.AccessoryRepository;
import com.example.carrental.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

import java.util.Date;

@SpringBootTest
public class OrderFacadeSuiteTest {

    @Autowired
    private OrderFacade orderFacade;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private AccessoryRepository accessoryRepository;

    @Test
    void addAccToOrderTest() throws OrderNotFoundException, AccessoryNotFoundException {
       // orderFacade.addAccToOrder(33,34);

        Order order =orderRepository.findById(33l).orElseThrow(OrderNotFoundException::new);
        Accessory accessory = accessoryRepository.findById(34L).orElseThrow(AccessoryNotFoundException::new);

        System.out.println(order.getAccessories().size());
        System.out.println(accessory.getOrders().size());
    }

    @Test
    void addAccToOrderTest2() throws OrderNotFoundException, AccessoryNotFoundException {
        System.out.println("Test 2");
        Order order = orderRepository.findById(33L).orElseThrow(OrderNotFoundException::new);
        Accessory accessory = accessoryRepository.findById(34L).orElseThrow(AccessoryNotFoundException::new);
        order.getAccessories().add(accessory);
        accessory.getOrders().add(order);
    }

    @Test
    void showSalary() throws OrderNotFoundException, CarNotFoundException, ReservationNotFoundException {

        System.out.println("Test 3");

        float totalCost = orderFacade.showSalary(35);
        System.out.println("Result: " + totalCost);
    }

    @Test
    void takiedlamnie() {

        Date start1 = new Date(2023,2,16);
        Date start2 = new Date(2023,3,16);

        System.out.println(start1);
        System.out.println(start2);
        System.out.println(start1.getTime() < start2.getTime());
    }

    @Test
    void clearAll(){
        orderRepository.deleteAll();
        accessoryRepository.deleteAll();
    }
}
