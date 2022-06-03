package com.smalldogg.rememberplease.domain.weather.repository;

import com.smalldogg.rememberplease.domain.weather.Weather;
import com.smalldogg.rememberplease.domain.weather.dto.WeatherResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface WeatherRepository extends JpaRepository<Weather,String>, WeatherRepositoryCustom {

}
