package com.example.carrental.database;

import com.example.carrental.entity.Fuel;
import com.example.carrental.exceptions.FuelNotFoundException;
import com.example.carrental.repository.FuelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DbFuel {

    private final FuelRepository fuelRepository;

    public List<Fuel> getAllFuels(){
        return fuelRepository.findAll();
    }

    public Fuel getFuel(Long fuelId) throws FuelNotFoundException {
        return fuelRepository.findById(fuelId).orElseThrow(FuelNotFoundException::new);
    }

    public Fuel saveFuel(Fuel fuel){
        return fuelRepository.save(fuel);
    }

    public void deleteFuel(long id){
        fuelRepository.deleteById(id);
    }
}
