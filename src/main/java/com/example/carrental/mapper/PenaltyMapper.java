package com.example.carrental.mapper;

import com.example.carrental.domain.PenaltyDto;
import com.example.carrental.entity.Penalty;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PenaltyMapper {

    public Penalty mapToPenalty(PenaltyDto penaltyDto){
        return new Penalty(penaltyDto.getId(), penaltyDto.getName(), penaltyDto.getPrice());
    }

    public PenaltyDto mapToPenaltyDto(Penalty penalty){
        return new PenaltyDto(penalty.getId(), penalty.getName(), penalty.getPrice());
    }

    public List<PenaltyDto> mapToListPenaltyDto(List<Penalty> list){
        return list.stream()
                .map(this::mapToPenaltyDto)
                .collect(Collectors.toList());
    }
}
