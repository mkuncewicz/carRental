package com.example.carrental.controler;

import com.example.carrental.database.DbBodyType;
import com.example.carrental.domain.BodyTypeDto;
import com.example.carrental.entity.BodyType;
import com.example.carrental.exceptions.BodyTypeNotFoundException;
import com.example.carrental.mapper.BodyTypeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/bodytype")
@RequiredArgsConstructor
@CrossOrigin("*")
public class BodyTypeControler {

    private final DbBodyType dbBodyType;
    private final BodyTypeMapper bodyTypeMapper;

    @GetMapping
    public ResponseEntity<List<BodyTypeDto>> getAllBodyTypes(){
        System.out.println("Get all BodyTypes");

        return ResponseEntity.ok(bodyTypeMapper.mapToBodyTypeDtoList(dbBodyType.getAllBodyTypes()));
    }

    @GetMapping(value = "{bodyId}")
    public ResponseEntity<BodyTypeDto> getBodyType(@PathVariable long bodyId) throws BodyTypeNotFoundException {
        System.out.println("Get BodyType");

        return ResponseEntity.ok(bodyTypeMapper.mapToBodyTypeDto(dbBodyType.getBodyType(bodyId)));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createBodyType(@RequestBody BodyTypeDto bodyTypeDto){
        System.out.println("Create bodyType");

        dbBodyType.saveBodyType(bodyTypeMapper.mapToBodyType(bodyTypeDto));
        return ResponseEntity.ok().build();
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BodyTypeDto> updateBodyType(@RequestBody BodyTypeDto bodyTypeDto){
        System.out.println("Update BodyType");
        BodyType bodyType = bodyTypeMapper.mapToBodyType(bodyTypeDto);
        BodyType saveBodyType = dbBodyType.saveBodyType(bodyType);

        return ResponseEntity.ok(bodyTypeMapper.mapToBodyTypeDto(saveBodyType));
    }
    @DeleteMapping(value = "{bodyId}")
    public ResponseEntity<Void> deleteBodyType(@PathVariable long bodyId){
        System.out.println("Delete BodyType");
        dbBodyType.deleteBodyType(bodyId);
        return ResponseEntity.ok().build();
    }
}
