package com.smalldogg.rememberplease.domain.weather;

import com.smalldogg.rememberplease.domain.weather.dto.LocationDto;
import com.smalldogg.rememberplease.domain.weather.dto.WeatherResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.Optional;

@Slf4j
@Service
public class WeatherService {

    private final WeatherRepository weatherRepository;
    private final LocationExtractor locationExtractor;

    public WeatherService(WeatherRepository weatherRepository, LocationExtractor locationExtractor) {
        this.weatherRepository = weatherRepository;
        this.locationExtractor = locationExtractor;
    }

    public WeatherResponseDto getWeather(LocationDto locationDto) throws IOException {
        String id = locationDto.getId();
        if(!StringUtils.hasText(id)){
            id = locationExtractor.getLocation(locationDto.getLongitude(), locationDto.getLatitude());
        }
        Optional<WeatherResponseDto> weatherResponseDto = weatherRepository.findByIdTop1(id);

        if(weatherResponseDto.isEmpty()){
            //날씨 조회 API 호출
        }

        return weatherResponseDto.orElse(null);
    }


}
