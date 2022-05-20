package com.smalldogg.rememberplease.domain.weather.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter
@NoArgsConstructor
public class LocationDto {
    private String id;
    private String latitude;
    private String longitude;
    private String x;
    private String y;

    public LocationDto(String id) {
        this.id = id;
    }
}
