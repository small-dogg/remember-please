package com.smalldogg.rememberplease.domain.weather;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WeatherService {

    private final WeatherRepository weatherRepository;

    public WeatherService(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    public WeatherResponseDto getWeather(String id){
        Optional<WeatherResponseDto> weatherResponseDto = weatherRepository.findByIdTop1(id);
        return weatherResponseDto.orElse(null);
    }
}
