package com.example.carrental.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class FuelDto {
    private long id;
    private String name;
    private float price;
}
