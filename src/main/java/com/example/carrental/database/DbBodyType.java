package com.example.carrental.database;

import com.example.carrental.entity.BodyType;
import com.example.carrental.exceptions.BodyTypeNotFoundException;
import com.example.carrental.repository.BodyTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DbBodyType {

    private final BodyTypeRepository bodyTypeRepository;

    public List<BodyType> getAllBodyTypes(){
        return bodyTypeRepository.findAll();
    }

    public BodyType getBodyType(Long bodyId) throws BodyTypeNotFoundException {
        return bodyTypeRepository.findById(bodyId).orElseThrow(BodyTypeNotFoundException::new);
    }

    public BodyType saveBodyType(BodyType bodyType){
        return bodyTypeRepository.save(bodyType);
    }

    public void deleteBodyType(long id){
        bodyTypeRepository.deleteById(id);
    }
}
