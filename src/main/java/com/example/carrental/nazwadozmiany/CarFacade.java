package com.example.carrental.nazwadozmiany;

import com.example.carrental.database.DbCar;
import com.example.carrental.entity.Car;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
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

    public List<Car> showCarWithPrice(float min, float max){
        if(min > max && min != 0 && max != 0){
            System.out.println("Min jest wierksze od max");
            return new ArrayList<>();
        }
        List<Car> list = dbCar.getAllCars();
            if (min > 0) {
                list = list.stream()
                        .filter(n -> n.getPricePerDay() >= min)
                        .collect(Collectors.toList());
            }
            if (max != 0){
            list = list.stream()
                    .filter(n -> n.getPricePerDay() <= max)
                    .collect(Collectors.toList());
        }
        return list;
        }
}
