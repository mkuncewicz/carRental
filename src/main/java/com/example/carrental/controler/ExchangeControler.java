package com.example.carrental.controler;

import com.example.carrental.api.ExchangeDto;
import com.example.carrental.api.ExchangeService;
import com.example.carrental.api.OpenExchangeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/exchange")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ExchangeControler {

    private final ExchangeService exchange;

    @GetMapping(value = "/{curFrom}/{curTo}/{amount}")
    public ResponseEntity<Float> getExchange(@PathVariable String curFrom, @PathVariable String curTo, @PathVariable int amount) {
        System.out.println("Get Exchange");
        OpenExchangeDto openExchangeDto = exchange.getExchange(curFrom,curTo,amount);

        ExchangeDto result = ExchangeDto.builder()
                .result(openExchangeDto.getResult())
                .build();

        System.out.println("Normal result: " + result.getResult());
        System.out.println("My result: "+ result.myResult());

        return ResponseEntity.ok(result.myResult());
    }

}
