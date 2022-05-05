package com.smalldogg.rememberplease.domain.weather;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WeatherRepository extends JpaRepository<Weather,String> {

}
