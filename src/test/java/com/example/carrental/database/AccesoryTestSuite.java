package com.example.carrental.database;

import com.example.carrental.entity.Accessory;
import com.example.carrental.repository.AccessoryRepository;
import org.junit.jupiter.api.BeforeAll;
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
public class AccesoryTestSuite {

    @Autowired
    private AccessoryRepository accessoryRepository;

    private final Accessory accessory = new Accessory();

    @BeforeEach
    public void preperateTest(){
        accessory.setName("Fotelik");
        accessory.setPrice(50.0f);
    }

    @Test
    public void testAddAccessory(){
        //Given
        accessoryRepository.save(accessory);
        //When & Then
        assertEquals(1, accessoryRepository.findAll().size());
        //Clean
        accessoryRepository.deleteAll();
    }

    @Test
    public void testFindAccesById() {
        //Given
        accessoryRepository.save(accessory);
        Long id = accessory.getId();
        //When
        Optional<Accessory> testAcc = accessoryRepository.findById(id);
        //Then
        assertEquals(id,testAcc.get().getId());
        //Clean
        accessoryRepository.deleteAll();
    }

    @Test
    public void testFindAllAcces(){
        //Given
        accessoryRepository.save(new Accessory(1L,"Test1",10.05f));
        accessoryRepository.save(new Accessory(2L,"Test2",20.10f));
        accessoryRepository.save(new Accessory(3L,"Test3",30.15f));
        //When
        List<Accessory> result = accessoryRepository.findAll();
        //Then
        assertEquals(3,result.size());
        //Clean
        accessoryRepository.deleteAll();
    }

}
