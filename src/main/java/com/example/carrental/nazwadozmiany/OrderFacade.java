package com.example.carrental.nazwadozmiany;

import com.example.carrental.database.*;
import com.example.carrental.entity.Accessory;
import com.example.carrental.entity.Order;
import com.example.carrental.exceptions.AccessoryNotFoundException;
import com.example.carrental.exceptions.CarNotFoundException;
import com.example.carrental.exceptions.OrderNotFoundException;
import com.example.carrental.exceptions.ReservationNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class OrderFacade {


    private final DbOrder dbOrder;

    private final DbPenalty dbPenalty;
    private final DbAccessory dbAccessory;

//    private final DbReservation dbReservation;
//
//    private final DbCar dbCar;

    public Order addAccToOrder(long orderId, long accId) throws OrderNotFoundException, AccessoryNotFoundException, ReservationNotFoundException, CarNotFoundException {

        Set<Accessory> accessories = null;
        Accessory accessory = dbAccessory.getAccessory(accId);
        Order order = dbOrder.getOrder(orderId);

        accessories = order.getAccessories();
        accessories.add(accessory);
        order.setAccessories(accessories);
        return dbOrder.saveOrder(order);
    }

//    public float showSalary(long orderId) throws OrderNotFoundException, CarNotFoundException{
//
//        float total = 0.00f;
//        long carId = dbOrder.getOrder(orderId).getCar().getId();
//        long reservationId;
//        float carPerDay = dbCar.getCar(carId).getPricePerDay();
//    }
}
