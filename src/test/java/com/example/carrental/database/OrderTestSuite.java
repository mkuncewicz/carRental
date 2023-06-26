package com.example.carrental.database;

import com.example.carrental.entity.Order;
import com.example.carrental.repository.OrderRepository;
import org.aspectj.weaver.ast.Or;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
public class OrderTestSuite {

    @Autowired
    OrderRepository orderRepository;

    private final Order order = new Order();


    @BeforeEach
    public void preperateTest(){
        order.setPrice(300.0f);
        order.setDiscout(5);
        order.setReturnLocation("Poznan");
    }

    @Test
    public void testAddOrder(){
        //Given
        //When
        orderRepository.save(order);
        //Then
        assertEquals(1,orderRepository.findAll().size());
        //Clean
        orderRepository.deleteAll();
    }

    @Test
    public void testFindOrderById(){
        //Given
        orderRepository.save(order);
        Long id = order.getId();
        //When
        Optional<Order> testOrder = orderRepository.findById(id);
        //Then
        assertEquals(id,testOrder.get().getId());
        //Clean
        orderRepository.deleteAll();
    }

    @Test
    public void testFindAllOrders(){
        //Given
        orderRepository.save(new Order());
        orderRepository.save(new Order());
        orderRepository.save(new Order());
        //When
        List<Order> list = orderRepository.findAll();
        //Then
        assertEquals(3,list.size());
        //Clean
        orderRepository.deleteAll();
    }
}
