package com.example.carrental.controler;

import com.example.carrental.database.DbPenalty;
import com.example.carrental.domain.PenaltyDto;
import com.example.carrental.entity.Order;
import com.example.carrental.entity.Penalty;
import com.example.carrental.exceptions.*;
import com.example.carrental.mapper.PenaltyMapper;
import com.example.carrental.facade.OrderFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/pen")
@RequiredArgsConstructor
@CrossOrigin("*")
public class PenaltyControler {

    private final DbPenalty dbPenalty;
    private final PenaltyMapper penaltyMapper;

    private final OrderFacade fasadaOrder;

    @GetMapping
    public ResponseEntity<List<PenaltyDto>> getAllAccessories(){
        System.out.println("Get all Penalties");

        return ResponseEntity.ok(penaltyMapper.mapToListPenaltyDto(dbPenalty.getAllPenalties()));
    }

    @GetMapping(value = "{penId}")
    public ResponseEntity<PenaltyDto> getPenalty(@PathVariable long penId) throws PenaltyNotFoundException {
        System.out.println("Get Penalty");

        return ResponseEntity.ok(penaltyMapper.mapToPenaltyDto(dbPenalty.getPenalty(penId)));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createPenalty(@RequestBody PenaltyDto penaltyDto){
        System.out.println("Create penalty");

        dbPenalty.savePenalty(penaltyMapper.mapToPenalty(penaltyDto));
        return ResponseEntity.ok().build();
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PenaltyDto> updatePenalty(@RequestBody PenaltyDto penaltyDto){
        System.out.println("Update Penalty");
        Penalty penalty = penaltyMapper.mapToPenalty(penaltyDto);
        Penalty savePenalty = dbPenalty.savePenalty(penalty);

        return ResponseEntity.ok(penaltyMapper.mapToPenaltyDto(savePenalty));
    }
    @DeleteMapping(value = "{penId}")
    public ResponseEntity<Void> deletePenalty(@PathVariable long penId){
        System.out.println("Delete Penalty");
        dbPenalty.deletePenalty(penId);
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/{orderId}/{penId}")
    public ResponseEntity<Order> addPenToOrder(@PathVariable long orderId, @PathVariable long penId) throws OrderNotFoundException, PenaltyNotFoundException, CarNotFoundException, ReservationNotFoundException {
        System.out.println("Order_Pen");

        return ResponseEntity.ok(fasadaOrder.addPenToOrder(orderId,penId));
    }
}
