package com.example.carrental.nazwadozmiany;

import com.example.carrental.entity.Accessory;
import com.example.carrental.entity.Order;
import com.example.carrental.exceptions.AccessoryNotFoundException;
import com.example.carrental.exceptions.OrderNotFoundException;
import com.example.carrental.repository.AccessoryRepository;
import com.example.carrental.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

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
        orderFacade.addAccToOrder(28,29);
    }

    @Test
    void addAccToOrderTest2() throws OrderNotFoundException, AccessoryNotFoundException {
        System.out.println("Test 2");
        Order order = orderRepository.findById(31L).orElseThrow(OrderNotFoundException::new);
        Accessory accessory = accessoryRepository.findById(32L).orElseThrow(AccessoryNotFoundException::new);
        order.getAccessories().add(accessory);
        accessory.getOrders().add(order);
    }

    @Test
    void clearAll(){
        orderRepository.deleteAll();
        accessoryRepository.deleteAll();
    }
}
