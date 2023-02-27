package com.example.carrental.controler;

import com.example.carrental.database.DbAccessory;
import com.example.carrental.domain.AccessoryDto;
import com.example.carrental.entity.Accessory;
import com.example.carrental.exceptions.AccessoryNotFoundException;
import com.example.carrental.mapper.AccessoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/acc")
@RequiredArgsConstructor
@CrossOrigin("*")
public class AccessoryControler {

    private final DbAccessory dbAccessory;
    private final AccessoryMapper accessoryMapper;

    @GetMapping
    public ResponseEntity<List<AccessoryDto>> getAllAccessories(){
        System.out.println("Get all Accessories");

        return ResponseEntity.ok(accessoryMapper.mapToListAccessoryDto(dbAccessory.getAllAccessories()));
    }

    @GetMapping(value = "{accId}")
    public ResponseEntity<AccessoryDto> getAccessory(@PathVariable long accId) throws AccessoryNotFoundException {
        System.out.println("Get Accessory");

        return ResponseEntity.ok(accessoryMapper.mapToAccessoryDto(dbAccessory.getAccessory(accId)));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createAccessory(@RequestBody AccessoryDto accessoryDto){
        System.out.println("Create accessory");

        dbAccessory.saveAccessory(accessoryMapper.mapToAccesory(accessoryDto));
        return ResponseEntity.ok().build();
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AccessoryDto> updateAccessory(@RequestBody AccessoryDto accessoryDto){
        System.out.println("Update Accessory");
        Accessory accessory = accessoryMapper.mapToAccesory(accessoryDto);
        Accessory saveAccessory = dbAccessory.saveAccessory(accessory);

        return ResponseEntity.ok(accessoryMapper.mapToAccessoryDto(saveAccessory));
    }
    @DeleteMapping(value = "{accId}")
    public ResponseEntity<Void> deleteAccessory(@PathVariable long accId){
        System.out.println("Delete Accessory");
        dbAccessory.deleteAccesory(accId);
        return ResponseEntity.ok().build();
    }
}
