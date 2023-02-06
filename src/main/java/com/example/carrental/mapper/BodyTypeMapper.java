package com.example.carrental.mapper;

import com.example.carrental.domain.BodyTypeDto;
import com.example.carrental.entity.BodyType;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BodyTypeMapper {

    public BodyType mapToBodyType(final BodyTypeDto bodyTypeDto){
        return new BodyType(bodyTypeDto.getId(), bodyTypeDto.getName());
    }

    public BodyTypeDto mapToBodyTypeDto(final BodyType bodyType){
        return new BodyTypeDto(bodyType.getId(), bodyType.getName());
    }

    public List<BodyTypeDto> mapToBodyTypeDtoList(final List<BodyType> list){
        return list.stream()
                .map(this::mapToBodyTypeDto)
                .collect(Collectors.toList());
    }
}
