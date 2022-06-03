package com.smalldogg.rememberplease.domain.weather;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;

import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ForecastClientTest {

    @Autowired
    ForecastClient forecastClient;

    @Test
    void forecastClientTest() throws URISyntaxException {
        forecastClient.getForecast("60","121");
    }

}