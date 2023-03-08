package com.example.carrental.nazwadozmiany;

import com.example.carrental.database.*;
import com.example.carrental.entity.*;
import com.example.carrental.exceptions.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class OrderFacade {


    private final DbOrder dbOrder;

    private final DbPenalty dbPenalty;
    private final DbAccessory dbAccessory;

    private final DbReservation dbReservation;

    private final DbCar dbCar;

    private static final long milPerDay = 86400000;

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

    public float showSalary(long orderId) throws OrderNotFoundException{

        float total = 0.00f;
        //Obliczanie kosztow rezerwacji auta
        Order testOrder = dbOrder.getOrder(orderId);

        float carSalary = carSalary(testOrder.getReservation());
        System.out.println("Poka kosz calkowity za samo auto: " + carSalary);
        //Obliczanie kosztow za akcesorie

       float accCost = accCost(testOrder);

        System.out.println("AccCost: " + accCost);
        return carSalary + accCost;
    }

    private float carSalary(Reservation reservation){
        Car car = reservation.getCar();
        float carCost = reservation.getCar().getPricePerDay();
        System.out.println("Cena za auto w metodzie: " +car.getPricePerDay());

        Date start = reservation.getDateStart();
        Date end = reservation.getDateEnd();

        long days = (end.getTime() - start.getTime())/ milPerDay;

        return carCost * days;
    }

    private float accCost(Order order){
        float totalAccCost = 0.0f;
        List<Accessory> listAcc = new ArrayList<>(order.getAccessories());

        for (Accessory accessory : listAcc){
            totalAccCost += accessory.getPrice();
            System.out.print("Nazwa: " + accessory.getName() + " ");
            System.out.println("Cena: " + accessory.getPrice());
        }
        return totalAccCost;
    }

    public float showPenalties(long orderId) throws OrderNotFoundException{
        float totalCost = 0.0f;

        Order order = dbOrder.getOrder(orderId);
        totalCost = penCost(order);
        return totalCost;
    }

    private float penCost(Order order){
        float totalPenCost = 0.0f;
        List<Penalty> penalties = new ArrayList<>(order.getPenalties());

        System.out.println("Kary:");
        for (Penalty penalty : penalties){
            totalPenCost += penalty.getPrice();
            System.out.print("Nazwa: "+ penalty.getName());
            System.out.println("Cena: "+ penalty.getPrice());
        }
        return totalPenCost;
    }
}
