package com.example.carrental.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExchangeDto {

    private float result;


    public float myResult(){
        float liczba = this.result;
        int miejscaPoPrzecinku = 2;
        float zaokraglona  = Math.round(liczba * Math.pow(10, miejscaPoPrzecinku)) / (float) Math.pow(10, miejscaPoPrzecinku);

        return zaokraglona;
    }
}
