package com.example.carrental.facade;

import com.example.carrental.database.*;
import com.example.carrental.entity.*;
import com.example.carrental.exceptions.*;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

@SpringBootTest
@Transactional
public class OrderFacadeTestSuite {

    private OrderFacade orderFacade;
    private DbOrder dbOrder;
    private DbAccessory dbAccessory;
    private DbPenalty dbPenalty;
    private DbReservation dbReservation;
    private DbCar dbCar;

    @BeforeEach
    public void setup(){
         dbOrder = mock(DbOrder.class);
         dbAccessory = mock(DbAccessory.class);
         dbPenalty = mock(DbPenalty.class);
         dbReservation = mock(DbReservation.class);
         dbCar = mock(DbCar.class);
         orderFacade = new OrderFacade(dbOrder,dbPenalty,dbAccessory,dbReservation,dbCar);
    }

    @Test
    public void testAddAccToOrder() throws OrderNotFoundException, AccessoryNotFoundException,ReservationNotFoundException, CarNotFoundException {
        //Given
        Order testOrder = new Order(1L,new Reservation(),new Car(),40.0f,5f,new Date(),"Poznan");
        Accessory testAccessory = new Accessory(1L,"Fotelik",50.0f);
        given(dbOrder.getOrder(1L)).willReturn(testOrder);
        given(dbOrder.saveOrder(testOrder)).willReturn(testOrder);
        given(dbAccessory.getAccessory(1L)).willReturn(testAccessory);
        //When
        Order resultOrder = orderFacade.addAccToOrder(1L,1L);
        Accessory resultAcc = resultOrder.getAccessories().stream().findFirst().orElse(null);
        //Then
        assertEquals(testAccessory,resultAcc);
    }

    @Test
    public void testPenToOrder() throws OrderNotFoundException,PenaltyNotFoundException, ReservationNotFoundException, CarNotFoundException {
        //Given
        Order testOrder = new Order(1L,new Reservation(),new Car(),40.0f,5f,new Date(),"Poznan");
        Penalty testPenalty = new Penalty(1L,"Kara",200.0f);
        given(dbOrder.getOrder(1L)).willReturn(testOrder);
        given(dbOrder.saveOrder(testOrder)).willReturn(testOrder);
        given(dbPenalty.getPenalty(1L)).willReturn(testPenalty);
        //When
        Order resultOrder = orderFacade.addPenToOrder(1L,1L);
        Penalty resultPenalty = resultOrder.getPenalties().stream().findFirst().orElse(null);
        //Then
        assertEquals(testPenalty,resultPenalty);
    }
}
