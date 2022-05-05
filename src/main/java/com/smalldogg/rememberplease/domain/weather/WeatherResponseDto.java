package com.smalldogg.rememberplease.domain.weather;

import lombok.Data;

@Data
public class WeatherResponseDto {
    private String id;
    private float tempAvg;
    private float temp;
}
