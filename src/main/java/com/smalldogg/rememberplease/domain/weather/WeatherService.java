package com.smalldogg.rememberplease.domain.weather;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smalldogg.rememberplease.domain.weather.dto.WeatherResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

@Slf4j
@Service
public class WeatherService {

    private static String geocodingUrl;
    private static String clientID;
    private static String clientSecret;

    private final WeatherRepository weatherRepository;

    public WeatherService(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    @Value("${ncp.maps.reverse-geocoding.url}")
    public void setGeocodingUrl(String geocodingUrl) {
        WeatherService.geocodingUrl = geocodingUrl;
    }

    @Value("${ncp.maps.client.ID}")
    public void setClientID(String clientID) {
        WeatherService.clientID = clientID;
    }

    @Value("${ncp.maps.client.secret}")
    public void setClientSecret(String clientSecret) {
        WeatherService.clientSecret = clientSecret;
    }

    public WeatherResponseDto getWeather(String id, String x, String y) throws IOException {
        ArrayList<String> town = new ArrayList<>();
        if (StringUtils.hasText(x)) {
            town = getTown(x, y);
        }

        Optional<WeatherResponseDto> weatherResponseDto = weatherRepository.findByIdTop1(id);


        return weatherResponseDto.orElse(null);
    }

    private ArrayList<String> getTown(String x, String y) throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        ArrayList<String> result = new ArrayList<>();

        UriComponents uri = UriComponentsBuilder.fromHttpUrl(geocodingUrl)
                .queryParam("coords", (x + "," + y).replace(" ", ""))
                .queryParam("orders", "legalcode")
                .queryParam("output", "json")
                .build();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("X-NCP-APIGW-API-KEY-ID",clientID);
        httpHeaders.add("X-NCP-APIGW-API-KEY", clientSecret);
        HttpEntity entity = new HttpEntity(httpHeaders);

        ResponseEntity<String> exchange = restTemplate.exchange(uri.toUriString(), HttpMethod.GET, entity, String.class);
        JsonNode jsonNode = new ObjectMapper().readTree(exchange.getBody());
        jsonNode.get("results").get(0).get("region").iterator().forEachRemaining(area->{
            result.add(String.valueOf(area.get("name")));
        });

        log.debug("exchange = " + exchange.getBody());
        return result;
    }
}
