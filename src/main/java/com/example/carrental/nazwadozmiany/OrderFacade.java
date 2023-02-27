package com.example.carrental.nazwadozmiany;

import com.example.carrental.database.DbAccessory;
import com.example.carrental.database.DbOrder;
import com.example.carrental.database.DbPenalty;
import com.example.carrental.entity.Accessory;
import com.example.carrental.exceptions.AccessoryNotFoundException;
import com.example.carrental.exceptions.OrderNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderFacade {


    private final DbOrder dbOrder;

    private final DbPenalty dbPenalty;
    private final DbAccessory dbAccessory;

    public void addAccToOrder(long orderId, long accId) throws OrderNotFoundException, AccessoryNotFoundException {

        Accessory accessory = dbAccessory.getAccessory(accId);

        dbOrder.getOrder(orderId).getAccessories().add(accessory);
    }
}
