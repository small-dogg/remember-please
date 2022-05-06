package com.smalldogg.rememberplease.domain.weather;

import com.smalldogg.rememberplease.domain.weather.dto.WeatherResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class WeatherController {
    private final WeatherService weatherService;


    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/weather")
    public WeatherResponseDto getWeather(@RequestParam("x") String x,
                                         @RequestParam("y") String y,
                                         @RequestParam("weatherId") String weatherId) throws IOException {

        x = "126.98470";
        y = "37.30884";

        weatherService.getWeather(weatherId, x, y);

        return new WeatherResponseDto("aa", 1.0f, 2.0f);
    }
}
