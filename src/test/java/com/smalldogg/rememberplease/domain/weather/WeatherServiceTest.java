package com.smalldogg.rememberplease.domain.weather;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.Optional;

@SpringBootTest
@Transactional
@Rollback(value = false)
class WeatherServiceTest {

    @Autowired WeatherRepository weatherRepository;

    @Test
    public void WeatherTest(){
        Weather weather = new Weather(
                "서울시,관악구,신림1동","신림동","신림동",21.4f,18.2f
        );
        Weather weather2 = new Weather(
                "서울시,관악구,신림2동","신림동","신림동",21.4f,18.2f
        );
        weatherRepository.save(weather);
        weatherRepository.save(weather2);

        Optional<WeatherResponseDto> topByOrderByLastModifiedAtDescById = weatherRepository.findByIdTop1("서울시,관악구,신림1동");
        System.out.println("topByOrderByLastModifiedAtDescById.get() = " + topByOrderByLastModifiedAtDescById.get());

    }

}