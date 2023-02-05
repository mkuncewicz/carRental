package com.example.carrental.controler;

import com.example.carrental.database.DbFuel;
import com.example.carrental.domain.FuelDto;
import com.example.carrental.entity.Fuel;
import com.example.carrental.exceptions.FuelNotFoundException;
import com.example.carrental.mapper.FuelMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/fuel")
@RequiredArgsConstructor
@CrossOrigin("*")
public class FuelControler {

    private final DbFuel dbFuel;
    private final FuelMapper fuelMapper;

    @GetMapping
    public List<FuelDto> getAllFuels(){
        System.out.println("Get All fuel");
        List<Fuel> list = dbFuel.getAllFuels();
        return fuelMapper.mapToFuelDtoList(list);
    }

    @GetMapping(value = "{fuelId}")
    public ResponseEntity<FuelDto> getFuel(@PathVariable long fuelId) throws FuelNotFoundException{
        System.out.println("Get Fuel");

        return ResponseEntity.ok(fuelMapper.mapToFuelDto(dbFuel.getFuel(fuelId)));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createFuel(@RequestBody FuelDto fuelDto){
        System.out.println("Create Fuel");
        dbFuel.saveFuel(fuelMapper.mapToFuel(fuelDto));
        ResponseEntity.ok().build();
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public FuelDto updateFuel(@RequestBody FuelDto fuelDto){
        System.out.println("Update Fuel");
        return fuelDto;
    }
    @DeleteMapping(value = "{fuelId}")
    public void deleteFuel(@PathVariable long fuelId){
        System.out.println("Delete Fuel");
    }

}
