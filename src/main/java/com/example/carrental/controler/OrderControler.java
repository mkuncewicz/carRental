package com.example.carrental.controler;


import com.example.carrental.database.DbOrder;
import com.example.carrental.domain.OrderDto;
import com.example.carrental.entity.Order;
import com.example.carrental.exceptions.*;
import com.example.carrental.mapper.OrderMapper;
import com.example.carrental.facade.OrderFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/order")
@RequiredArgsConstructor
@CrossOrigin("*")
public class OrderControler {


    private final DbOrder dbOrder;
    private final OrderMapper orderMapper;

    private final OrderFacade fasadaOrder;

    @GetMapping
    public ResponseEntity<List<OrderDto>> getAllOrders(){
        System.out.println("Get All - Orders");

        return ResponseEntity.ok(orderMapper.mapToListDto(dbOrder.getAllOrders()));
    }

    @GetMapping(value = "{orderId}")
    public ResponseEntity<OrderDto> getOrder(@PathVariable long orderId) throws OrderNotFoundException {
        System.out.println("Get Order");

        return ResponseEntity.ok(orderMapper.mapToOrderDto(dbOrder.getOrder(orderId)));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createOrder(@RequestBody OrderDto orderDto) throws ReservationNotFoundException, CarNotFoundException {
        System.out.println("Create Order");

        dbOrder.saveOrder(orderMapper.mapToOrder(orderDto));

        return ResponseEntity.ok().build();
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderDto> updateOrder(@RequestBody OrderDto orderDto) throws ReservationNotFoundException, CarNotFoundException{
        System.out.println("Update Order");

        Order order = orderMapper.mapToOrder(orderDto);
        Order saveOrder = dbOrder.saveOrder(order);

        return ResponseEntity.ok(orderMapper.mapToOrderDto(saveOrder));
    }

    @DeleteMapping(value = "{orderId}")
    public ResponseEntity<Void> deleteOrder(@PathVariable long orderId){
        System.out.println("Delete order");

        dbOrder.deleteOrder(orderId);

        return ResponseEntity.ok().build();
    }
}
