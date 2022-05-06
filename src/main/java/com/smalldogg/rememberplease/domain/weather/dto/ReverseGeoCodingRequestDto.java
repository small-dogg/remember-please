package com.smalldogg.rememberplease.domain.weather.dto;

import lombok.Data;
import lombok.NonNull;


@Data
public class ReverseGeoCodingRequestDto {
    private String request;
    @NonNull private String coords;
    private String sourcecrs;
    private String targetcrs;
    private String orders;
    private String output;
    private String callback;

    @Override
    public String toString() {
        return "ReverseGeoCodingRequestDto{" +
                ", coords='" + coords + '\'' +
                '}';
    }
}
