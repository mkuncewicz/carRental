package com.example.carrental.mapper;

import com.example.carrental.domain.FuelDto;
import com.example.carrental.entity.Fuel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FuelMapper {

    public Fuel mapToFuel(final FuelDto fuelDto){
        return new Fuel(fuelDto.getId(), fuelDto.getName(), fuelDto.getPrice());
    }

    public FuelDto mapToFuelDto(final Fuel fuel){
        return new FuelDto(fuel.getId(), fuel.getName(), fuel.getPrice());
    }

    public List<FuelDto> mapToFuelDtoList(final List<Fuel> list){
        return list.stream()
                .map(this::mapToFuelDto)
                .collect(Collectors.toList());
    }
}
