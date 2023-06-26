package com.example.carrental.database;

import com.example.carrental.entity.Fuel;
import com.example.carrental.repository.FuelRepository;
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
public class FuelTestSuite {

    @Autowired
    FuelRepository fuelRepository;

    private final Fuel fuel = new Fuel();

    @BeforeEach
    public void preperateTest(){
      fuel.setName("FuelTest");
      fuel.setPrice(6.43f);
    }

    @Test
    public void testAddFuel(){
        //Given
        //When
        fuelRepository.save(fuel);
        //Then
        assertEquals(1,fuelRepository.findAll().size());
        //Clean
        fuelRepository.deleteAll();
    }

    @Test
    public void testFindFuelById(){
        //Given
        fuelRepository.save(fuel);
        Long id = fuel.getId();
        //When
        Optional<Fuel> testFuel = fuelRepository.findById(id);
        //Then
        assertEquals(id,testFuel.get().getId());
        //Clean
        fuelRepository.deleteAll();
    }

    @Test
    public void testFindAllFuels(){
        //Given
        fuelRepository.save(new Fuel());
        fuelRepository.save(new Fuel());
        fuelRepository.save(new Fuel());
        //When
        List<Fuel> list = fuelRepository.findAll();
        //Then
        assertEquals(3,list.size());
        //Clean
        fuelRepository.deleteAll();
    }
}
