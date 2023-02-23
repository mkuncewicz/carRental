package com.example.carrental.database;

import com.example.carrental.entity.Penalty;
import com.example.carrental.exceptions.PenaltyNotFoundException;
import com.example.carrental.repository.PenaltyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DbPenalty {

    private final PenaltyRepository penaltyRepository;

    public List<Penalty> getAllPenalties(){
        return penaltyRepository.findAll();
    }

    public Penalty getPenalty(long penId) throws PenaltyNotFoundException {
        return penaltyRepository.findById(penId).orElseThrow(PenaltyNotFoundException::new);
    }

    public Penalty savePenalty(Penalty penalty){
        Penalty savePenalty = penaltyRepository.save(penalty);
        return savePenalty;
    }
    public void deletePenalty(long id){
        penaltyRepository.deleteById(id);
    }
}
