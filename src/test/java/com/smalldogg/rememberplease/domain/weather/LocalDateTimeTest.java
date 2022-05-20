package com.smalldogg.rememberplease.domain.weather;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.TestPropertySources;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

public class LocalDateTimeTest {

    LocalDateTime localDateTime;

    @BeforeEach
    void getLocalDateTime() {
        this.localDateTime = LocalDateTime.now();
    }

    @Test
    void getDate() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String localDate = localDateTime.toLocalDate().format(dateTimeFormatter);
        System.out.println("localDate = " + localDate);
    }

    @Test
    void getTime() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HHmm");
        String localDate = localDateTime.toLocalTime().format(dateTimeFormatter);
        System.out.println("localDate = " + localDate);
    }
}
