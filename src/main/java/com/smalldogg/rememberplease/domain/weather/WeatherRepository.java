package com.smalldogg.rememberplease.domain.weather;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface WeatherRepository extends JpaRepository<Weather,String> {
    @Query("select new com.smalldogg.rememberplease.domain.weather.WeatherResponseDto(w.id, w.tempAvg, w.temp)" +
            " from Weather w where w.id = :id order by w.lastModifiedAt desc")
    Optional<WeatherResponseDto> findByIdTop1(String id);
}
