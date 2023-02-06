package com.example.carrental.database;

import com.example.carrental.entity.Car;
import com.example.carrental.exceptions.CarNotFoundException;
import com.example.carrental.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DbCar {

    private final CarRepository carRepository;

    public List<Car> getAllCars(){
        return carRepository.findAll();
    }

    public Car getCar(Long carId) throws CarNotFoundException {
        return carRepository.findById(carId).orElseThrow(CarNotFoundException::new);
    }

    public Car saveCar (Car car){
        return carRepository.save(car);
    }

    public void deleteCar(long carId){
        carRepository.deleteById(carId);
    }
}
