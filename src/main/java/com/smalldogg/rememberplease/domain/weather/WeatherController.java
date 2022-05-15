package com.smalldogg.rememberplease.domain.weather;

import com.smalldogg.rememberplease.domain.weather.dto.LocationDto;
import com.smalldogg.rememberplease.domain.weather.dto.WeatherResponseDto;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
public class WeatherController {
    private final WeatherService weatherService;


    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/weather")
    public WeatherResponseDto getWeather(LocationDto locationDto, HttpServletRequest request) throws IOException {

        weatherService.getWeather(locationDto);

        return new WeatherResponseDto("aa", 1.0f, 2.0f);
    }
}
