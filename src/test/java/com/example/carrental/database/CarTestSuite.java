package com.example.carrental.database;

import com.example.carrental.entity.BodyType;
import com.example.carrental.entity.Car;
import com.example.carrental.repository.CarRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
public class CarTestSuite {

    @Autowired
    CarRepository carRepository;

    private final Car car = new Car();

    @BeforeEach
    public void preperateTest(){
        car.setBrandName("Mercedes");
        car.setModel("CLA");
        car.setAmOfFuel(50.0f);
        car.setNumOfPlaces(5);
        car.setEnPower(200);
        car.setPricePerDay(250.0f);
        car.setLocation("Wroclaw");
    }

    @Test
    public void testAddCar(){
        //Given
        //When
        carRepository.save(car);
        //Then
        assertEquals(1,carRepository.findAll().size());
        //Clean
        carRepository.deleteAll();
    }

    @Test
    public void testFindCarById(){
        //Given
        carRepository.save(car);
        Long id = car.getId();
        //When
        Optional<Car> testCar = carRepository.findById(id);
        Long result = testCar.get().getId();
        //Then
        assertEquals(id,result);
        //Clean
        carRepository.deleteAll();
    }

    @Test
    public void testFindAllCars(){
        //Given
        carRepository.save(new Car());
        carRepository.save(new Car());
        carRepository.save(new Car());
        //When
        List<Car> list = carRepository.findAll();
        //Then
        assertEquals(3,list.size());
        //Clean
        carRepository.deleteAll();
    }
}
