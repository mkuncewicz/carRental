package com.example.carrental.database;

import com.example.carrental.entity.Accessory;
import com.example.carrental.exceptions.AccessoryNotFoundException;
import com.example.carrental.repository.AccessoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DbAccessory {

    private final AccessoryRepository accessoryRepository;

    public List<Accessory> getAllAccessories (){
        return accessoryRepository.findAll();
    }

    public Accessory getAccessory(long accId) throws AccessoryNotFoundException {
        return accessoryRepository.findById(accId).orElseThrow(AccessoryNotFoundException::new);
    }

    public Accessory saveAccessory(Accessory accessory){
        return accessoryRepository.save(accessory);
    }

    public void deleteAccesory(long accId){
        accessoryRepository.deleteById(accId);
    }
}
