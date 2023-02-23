package com.example.carrental.mapper;

import com.example.carrental.domain.AccessoryDto;
import com.example.carrental.entity.Accessory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccessoryMapper {

    public Accessory mapToAccesory(AccessoryDto accessoryDto){
        return new Accessory(accessoryDto.getId(), accessoryDto.getName(), accessoryDto.getPrice());
    }

    public AccessoryDto mapToAccessoryDto(Accessory accessory){
        return new AccessoryDto(accessory.getId(), accessory.getName(), accessory.getPrice());
    }

    public List<AccessoryDto> mapToListAccessoryDto(List<Accessory> list){

        return list.stream()
                .map(this::mapToAccessoryDto)
                .collect(Collectors.toList());
    }
}
