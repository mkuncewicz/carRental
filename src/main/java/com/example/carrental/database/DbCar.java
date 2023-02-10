package com.example.carrental.database;

import com.example.carrental.entity.Car;
import com.example.carrental.exceptions.BodyTypeNotFoundException;
import com.example.carrental.exceptions.CarNotFoundException;
import com.example.carrental.exceptions.FuelNotFoundException;
import com.example.carrental.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DbCar {
//
    private final CarRepository carRepository;

    private final DbFuel dbFuel;

    private final DbBodyType dbBodyType;

    public List<Car> getAllCars(){
        return carRepository.findAll();
    }

    public Car getCar(Long carId) throws CarNotFoundException {
        return carRepository.findById(carId).orElseThrow(CarNotFoundException::new);
    }

    public Car saveCar (Car car) throws FuelNotFoundException, BodyTypeNotFoundException {
        long fuelId = car.getFuel().getId();
        long bodyId = car.getBodyType().getId();
        Car newCar = carRepository.save(car);
        dbFuel.getFuel(fuelId).getCars().add(newCar);
        dbBodyType.getBodyType(bodyId).getCars().add(newCar);

        return newCar;
    }

    public void deleteCar(long carId){
        carRepository.deleteById(carId);
    }
}
