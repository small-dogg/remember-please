package com.smalldogg.rememberplease.domain.weather.repository;

import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.smalldogg.rememberplease.domain.weather.QWeather;
import com.smalldogg.rememberplease.domain.weather.dto.WeatherDto;
import com.smalldogg.rememberplease.domain.weather.dto.WeatherResponseDto;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

import static com.smalldogg.rememberplease.domain.weather.QWeather.*;

@RequiredArgsConstructor
public class WeatherRepositoryImpl implements WeatherRepositoryCustom{
    @Override
    public Optional<WeatherResponseDto> findByIdLatest(String id) {
        return Optional.empty();
    }
//
//    private final JPAQueryFactory queryFactory;
//
//    @Override
//    public Optional<WeatherResponseDto> findByIdLatest(WeatherSeachCondition weatherDto) {
//        queryFactory
//                .select(new WeatherDto(
//
//                ))
//                .where(weather.id.eq(id));
//        return Optional.empty();
//    }
}
