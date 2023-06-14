package com.example.carrental.nazwadozmiany;

import com.example.carrental.database.DbCar;
import com.example.carrental.entity.Car;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CarFacade {

    private final DbCar dbCar;


    public List<Car> showCarWithBrandname(String brandname){
        List<Car> list = dbCar.getAllCars();

        list = list.stream()
                .filter(n -> n.getBrandName().equals(brandname))
                .collect(Collectors.toList());

        return list;
    }
}
