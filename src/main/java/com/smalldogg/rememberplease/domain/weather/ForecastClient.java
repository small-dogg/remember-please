package com.smalldogg.rememberplease.domain.weather;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class ForecastClient {
    @Value("${openapi.weather.servicekey}")
    private String SERVICE_KEY;

    @Value("${openapi.weather.endpoint}")
    private String ENDPOINT;

    private static final String DATA_TYPE = "JSON";
    private LocalDateTime localDateTime;

    public ForecastClient() {
        this.localDateTime = LocalDateTime.now();
    }

    public Forecast getForecast(String x, String y) {
        RestTemplate restTemplate = new RestTemplate();

        UriComponents uri = getUri(x, y);
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity httpEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<String> forecast = restTemplate.exchange(uri.toString(), HttpMethod.GET, httpEntity, String.class);

        System.out.println("forecast = " + forecast);
//        StringUtils.collectionToCommaDelimitedString(locationList).replace("\"", "");
        return new Forecast();
    }

    private UriComponents getUri(String x, String y) {
        return UriComponentsBuilder.fromHttpUrl(ENDPOINT)
                .queryParam("serviceKey", SERVICE_KEY)
                .queryParam("pageNo", "1")
                .queryParam("numOfRows", "1000")
                .queryParam("base_date", getLocalDate())
                .queryParam("base_time", getTime())
                .queryParam("nx", x)
                .queryParam("ny", y)
                .queryParam("dataType", DATA_TYPE)
                .build();
    }

    private String getLocalDate() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        return localDateTime.toLocalDate().format(dateTimeFormatter);
    }

    private String getTime() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HHmm");
        return localDateTime.toLocalTime().format(dateTimeFormatter);
    }
}
