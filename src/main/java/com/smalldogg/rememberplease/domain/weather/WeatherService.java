package com.smalldogg.rememberplease.domain.weather;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smalldogg.rememberplease.domain.weather.dto.LocationDto;
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
import java.util.List;
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


    public WeatherResponseDto getWeather(LocationDto locationDto) throws IOException {
        String id = locationDto.getId();
        if(!StringUtils.hasText(id)){
            id = getLocation(locationDto.getLatitude(), locationDto.getLongitude());
        }


        Optional<WeatherResponseDto> weatherResponseDto = weatherRepository.findByIdTop1(id);
        return weatherResponseDto.orElse(null);
    }

    private String getLocation(String latitude, String longitude) throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        ArrayList<String> result = new ArrayList<>();

        UriComponents uri = UriComponentsBuilder.fromHttpUrl(geocodingUrl)
                .queryParam("coords", (longitude + "," + latitude).replace(" ", ""))
                .queryParam("orders", "legalcode")
                .queryParam("output", "json")
                .build();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("X-NCP-APIGW-API-KEY-ID", clientID);
        httpHeaders.add("X-NCP-APIGW-API-KEY", clientSecret);
        HttpEntity entity = new HttpEntity(httpHeaders);

        ResponseEntity<String> exchange = restTemplate.exchange(uri.toUriString(), HttpMethod.GET, entity, String.class);
        List<String> locationList = getLocationList(exchange.getBody());

        return StringUtils.collectionToCommaDelimitedString(locationList).replace("\"","");
    }

    private List<String> getLocationList(String jsonString) throws JsonProcessingException {
        List<String> result = new ArrayList<>();
        JsonNode jsonNode = new ObjectMapper().readTree(jsonString);
        jsonNode.get("results").get(0).get("region").iterator().forEachRemaining(area -> {
            result.add(String.valueOf(area.get("name")));
        });
        return result;
    }
}
