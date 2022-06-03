package com.smalldogg.rememberplease.domain.weather.repository;

import com.smalldogg.rememberplease.domain.weather.dto.WeatherResponseDto;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface WeatherRepositoryCustom {
    Optional<WeatherResponseDto> findByIdLatest(String id);
}
