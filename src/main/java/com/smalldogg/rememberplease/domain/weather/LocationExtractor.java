package com.smalldogg.rememberplease.domain.weather;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

@Component
public class LocationExtractor {
    @Value("${ncp.maps.reverse-geocoding.url}")
    private String geocodingUrl;
    @Value("${ncp.maps.client.ID}")
    private String clientId;
    @Value("${ncp.maps.client.secret}")
    private String clientSecret;

    public String getLocation(String longitude, String latitude) throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();

        UriComponents uri = getUri(longitude, latitude);
        HttpEntity entity = new HttpEntity(getNCPHeader());

        ResponseEntity<String> exchange = restTemplate.exchange(uri.toUriString(), HttpMethod.GET, entity, String.class);
        List<String> locationList = extractLocationList(exchange.getBody());

        return StringUtils.collectionToCommaDelimitedString(locationList).replace("\"","");
    }

    private HttpHeaders getNCPHeader() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("X-NCP-APIGW-API-KEY-ID", clientId);
        httpHeaders.add("X-NCP-APIGW-API-KEY", clientSecret);
        return httpHeaders;
    }

    private UriComponents getUri(String longitude, String latitude) {
        return UriComponentsBuilder.fromHttpUrl(geocodingUrl)
                .queryParam("coords", (longitude + "," + latitude).replace(" ", ""))
                .queryParam("orders", "legalcode")
                .queryParam("output", "json")
                .build();
    }

    private List<String> extractLocationList(String jsonString) throws JsonProcessingException {
        List<String> result = new ArrayList<>();
        JsonNode jsonNode = new ObjectMapper().readTree(jsonString);
        jsonNode.get("results").get(0).get("region").iterator().forEachRemaining(area -> {
            result.add(String.valueOf(area.get("name")));
        });
        return result;
    }
}
