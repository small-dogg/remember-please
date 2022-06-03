package com.smalldogg.rememberplease.domain.weather;

import com.smalldogg.rememberplease.domain.weather.dto.LocationDto;
import com.smalldogg.rememberplease.domain.weather.dto.WeatherResponseDto;
import com.smalldogg.rememberplease.domain.weather.repository.WeatherRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@SpringBootTest
@Transactional
@Rollback(value = false)
class WeatherServiceTest {

    @Autowired
    WeatherService weatherService;

    @Autowired
    WeatherRepository weatherRepository;

    LocationDto locationDto;

    @BeforeEach
    void setUp() {
        this.locationDto = new LocationDto();
        locationDto.setLatitude("37.3190288");
        locationDto.setLongitude("126.9782842");
        locationDto.setX("60");
        locationDto.setY("121");
    }

    @Test
    void getWeather(){
        weatherService.getWeather(locationDto);
    }

    @Test
    public void WeatherTest(){
        Weather weather = new Weather(
                "서울시","관악구","신림1동",21.4f,18.2f
        );
        Weather weather2 = new Weather(
                "서울시","관악구","신림1동",21.4f,18.2f
        );
        weatherRepository.save(weather);
        weatherRepository.save(weather2);

        Optional<WeatherResponseDto> topByOrderByLastModifiedAtDescById = weatherRepository.findByIdLatest("서울시,관악구,신림1동");
        System.out.println("topByOrderByLastModifiedAtDescById.get() = " + topByOrderByLastModifiedAtDescById.get());

    }

}