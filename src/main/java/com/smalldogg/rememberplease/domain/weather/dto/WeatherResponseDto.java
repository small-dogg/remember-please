package com.smalldogg.rememberplease.domain.weather.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WeatherResponseDto {
    private String id;
    private float tempAvg;
    private float temp;
}
