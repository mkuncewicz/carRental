package com.example.carrental.database;


import com.example.carrental.entity.Penalty;
import com.example.carrental.repository.PenaltyRepository;
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
public class PenaltyTestSuite {

    @Autowired
    PenaltyRepository penaltyRepository;

    private final Penalty penalty = new Penalty();

    @BeforeEach
    public void preperateTest(){
        penalty.setName("Test1");
        penalty.setPrice(50.0f);
    }

    @Test
    public void testAddPenalty(){
        //Given
        //When
        penaltyRepository.save(penalty);
        //Then
        assertEquals(1,penaltyRepository.findAll().size());
        //Clean
        penaltyRepository.deleteAll();
    }

    @Test
    public void testFindPenaltyById(){
        //Given
        penaltyRepository.save(penalty);
        Long id = penalty.getId();
        //When
        Optional<Penalty> testPenalty = penaltyRepository.findById(id);
        //Then
        assertEquals(id,testPenalty.get().getId());
        //Clean
        penaltyRepository.deleteAll();
    }

    @Test
    public void testFindAllPenalties(){
        //Given
        penaltyRepository.save(new Penalty());
        penaltyRepository.save(new Penalty());
        penaltyRepository.save(new Penalty());
        //When
        List<Penalty> list = penaltyRepository.findAll();
        //Then
        assertEquals(3,list.size());
        //Clean
        penaltyRepository.deleteAll();
    }
}
