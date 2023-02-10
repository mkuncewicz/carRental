package com.example.carrental.controler;

import com.example.carrental.database.DbCar;
import com.example.carrental.domain.CarDto;
import com.example.carrental.entity.Car;
import com.example.carrental.exceptions.BodyTypeNotFoundException;
import com.example.carrental.exceptions.CarNotFoundException;
import com.example.carrental.exceptions.FuelNotFoundException;
import com.example.carrental.mapper.CarMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/car")
@RequiredArgsConstructor
@CrossOrigin("*")
public class CarControler {
//
    private final DbCar dbCar;
    private final CarMapper carMapper;

    @GetMapping
    public ResponseEntity<List<CarDto>> getAllCars(){
        System.out.println("Get All Cars");

        return ResponseEntity.ok(carMapper.mapToCarDtoList(dbCar.getAllCars()));
    }

    @GetMapping(value = "{carId}")
    public ResponseEntity<CarDto> getCar(@PathVariable long carId) throws CarNotFoundException {
        System.out.println("Get Car");

        return ResponseEntity.ok(carMapper.mapToCarDto(dbCar.getCar(carId)));
    }

    @PostMapping(MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createCar(@RequestBody CarDto carDto) throws FuelNotFoundException, BodyTypeNotFoundException{
        System.out.println("Create car");
        dbCar.saveCar(carMapper.mapToCar(carDto));

        return ResponseEntity.ok().build();
    }

    @PutMapping(MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CarDto> updateCar(@RequestBody CarDto carDto) throws  FuelNotFoundException, BodyTypeNotFoundException{
        System.out.println("Update Car");

        Car car = carMapper.mapToCar(carDto);
        Car saveCar = dbCar.saveCar(car);

        return ResponseEntity.ok(carMapper.mapToCarDto(saveCar));
    }
    @DeleteMapping(value = "{carId}")
    public ResponseEntity<Void> deleteCar(@PathVariable long carId){
        System.out.println("Delete Car");

        dbCar.deleteCar(carId);

        return ResponseEntity.ok().build();
    }
}
