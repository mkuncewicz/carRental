package com.example.carrental.controler;

import com.example.carrental.domain.BodyTypeDto;
import lombok.RequiredArgsConstructor;
import org.atmosphere.config.service.Get;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/bodytype")
@RequiredArgsConstructor
@CrossOrigin("*")
public class BodyTypeControler {

    @GetMapping
    public List<BodyTypeDto> getAllBodyTypes(){
        System.out.println("Get all BodyTypes");
        List<BodyTypeDto> list = new ArrayList<>();

        list.add(new BodyTypeDto(1L,"BodyType - TestNazwa1"));
        list.add(new BodyTypeDto(2L,"BodyType - TestNazwa2"));
        return list;
    }

    @GetMapping(value = "{bodyId}")
    public BodyTypeDto getBodyType(@PathVariable long bodyId){
        System.out.println("Get BodyType");
        return new BodyTypeDto(bodyId,"BodyType - TestName1");
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createBodyType(@RequestBody BodyTypeDto bodyTypeDto){
        System.out.println("Create bodyType");
    }
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public BodyTypeDto updateBodyType(@RequestBody BodyTypeDto bodyTypeDto){
        System.out.println("Update BodyType");
        return bodyTypeDto;
    }
    @DeleteMapping(value = "{bodyId}")
    public void deleteBodyType(@PathVariable long bodyId){
        System.out.println("Delete BodyType");
    }
}
