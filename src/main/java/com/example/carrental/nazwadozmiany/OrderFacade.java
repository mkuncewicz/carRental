package com.example.carrental.nazwadozmiany;

import com.example.carrental.database.*;
import com.example.carrental.entity.Accessory;
import com.example.carrental.entity.Order;
import com.example.carrental.entity.Penalty;
import com.example.carrental.exceptions.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class OrderFacade {


    private final DbOrder dbOrder;

    private final DbPenalty dbPenalty;
    private final DbAccessory dbAccessory;

    private final DbReservation dbReservation;

    private final DbCar dbCar;


    public Order addAccToOrder(long orderId, long accId) throws OrderNotFoundException, AccessoryNotFoundException, ReservationNotFoundException, CarNotFoundException {

        Set<Accessory> accessories = null;
        Accessory accessory = dbAccessory.getAccessory(accId);
        Order order = dbOrder.getOrder(orderId);

        accessories = order.getAccessories();
        accessories.add(accessory);
        order.setAccessories(accessories);
        return dbOrder.saveOrder(order);
    }

    public Order addPenToOrder(long orderId, long penId) throws OrderNotFoundException, PenaltyNotFoundException, CarNotFoundException, ReservationNotFoundException{

        Set<Penalty> penalties = null;
        Penalty penalty = dbPenalty.getPenalty(penId);
        Order order = dbOrder.getOrder(orderId);

        penalties = order.getPenalties();
        penalties.add(penalty);
        order.setPenalties(penalties);
        return dbOrder.saveOrder(order);
    }
}
