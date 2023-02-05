package com.example.carrental.controler;

import com.example.carrental.domain.CarDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/car")
@RequiredArgsConstructor
@CrossOrigin("*")
public class CarControler {

    @GetMapping
    public List<CarDto> getAllCars(){
        List<CarDto> list = new ArrayList<>();
        list.add(new CarDto(1L,"brandNameTest1","modelNameTest1",2L,3L,
                50.0f,5,200,150.0f,"Wroclaw"));

        list.add(new CarDto(2L,"brandNameTest2","modelNameTest",3L,3L,
                60.0f,2,325,250.0f,"Poznan"));
        System.out.println("Get All Cars");
        return list;
    }

    @GetMapping(value = "{carId}")
    public CarDto getCar(@PathVariable long carId){
        System.out.println("Get Car");
        return new CarDto(carId,"brandNameTest1","modelNameTest1",2L,3L,
                50.0f,5,200,150.0f,"Wroclaw");
    }

    @PostMapping(MediaType.APPLICATION_JSON_VALUE)
    public void createCar(@RequestBody CarDto carDto){
        System.out.println("Create car");
    }

    @PutMapping(MediaType.APPLICATION_JSON_VALUE)
    public CarDto updateCar(@RequestBody CarDto carDto){
        System.out.println("Update Car");
        return carDto;
    }
    @DeleteMapping(value = "{carId}")
    public void deleteCar(@PathVariable long carId){
        System.out.println("Delete Car");
    }
}
