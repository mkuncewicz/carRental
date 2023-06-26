package com.example.carrental.database;

import com.example.carrental.entity.BodyType;
import com.example.carrental.repository.BodyTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
public class BodyTypeTestSuite {

    @Autowired
    private BodyTypeRepository bodyTypeRepository;

    private final BodyType bodyType = new BodyType();

    @BeforeEach
    public void preperateTest(){
       bodyType.setName("SUV");
    }

    @Test
    public void testAddBodyType(){
        //Given
        //When
        bodyTypeRepository.save(bodyType);
        //Then
        assertEquals(1,bodyTypeRepository.findAll().size());
        //Clean
        bodyTypeRepository.deleteAll();
    }

    @Test
    public void testFindBodyTypeById(){
        //Given
        bodyTypeRepository.save(bodyType);
        Long id = bodyType.getId();
        //When
        Optional<BodyType> testBody = bodyTypeRepository.findById(id);
        //Then
        assertEquals(id,testBody.get().getId());
        //Clean
        bodyTypeRepository.deleteAll();
    }

    @Test
    public void testFindAllBodyTypes(){
        //Given
        bodyTypeRepository.save(new BodyType());
        bodyTypeRepository.save(new BodyType());
        bodyTypeRepository.save(new BodyType());
        //When
        List<BodyType> result = bodyTypeRepository.findAll();
        //Then
        assertEquals(3,result.size());
        //Clean
        bodyTypeRepository.deleteAll();
    }
}
