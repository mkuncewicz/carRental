package com.example.carrental.mapper;

import com.example.carrental.database.DbBodyType;
import com.example.carrental.database.DbFuel;
import com.example.carrental.domain.CarDto;
import com.example.carrental.entity.Car;
import com.example.carrental.exceptions.BodyTypeNotFoundException;
import com.example.carrental.exceptions.FuelNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarMapper {

    private DbFuel dbFuel;
    private DbBodyType dbBodyType;

    public Car mapToCar(CarDto carDto) throws BodyTypeNotFoundException,FuelNotFoundException {
        return new Car(carDto.getId(), carDto.getBrandName(), carDto.getModel(),
                dbBodyType.getBodyType(carDto.getBodyType_id()), dbFuel.getFuel(carDto.getFuel_id()),
                carDto.getAmOfFuel(), carDto.getNumOfPlaces(), carDto.getEnPower(), carDto.getPricePerDay(), carDto.getLocation());
    }

    public CarDto mapToCarDto(Car car){
        return new CarDto(car.getId(),car.getBrandName(), car.getModel(),
                car.getBodyType().getId(),car.getFuel().getId(),
                car.getAmOfFuel(),car.getNumOfPlaces(),car.getEnPower(),car.getPricePerDay(),car.getLocation());
    }

    public List<CarDto> mapToCarDtoList(final List<Car> list){
        return list.stream().
                map(this::mapToCarDto)
                .collect(Collectors.toList());
    }
}
