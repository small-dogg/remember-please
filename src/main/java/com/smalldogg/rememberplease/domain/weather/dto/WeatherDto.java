package com.smalldogg.rememberplease.domain.weather.dto;

import com.querydsl.core.types.Expression;
import lombok.Data;

@Data
public class WeatherDto {
    private String id;
    private String city;
    private String state;
    private String town;
    private float tempAvg;//오늘 평균 기온
    private float temp;//현재 기온


}
