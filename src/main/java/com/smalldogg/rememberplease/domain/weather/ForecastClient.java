package com.smalldogg.rememberplease.domain.weather;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.OptionalInt;
import java.util.stream.Stream;

@Component
public class ForecastClient {
    @Value("${openapi.weather.servicekey}")
    private String SERVICE_KEY;

    @Value("${openapi.weather.endpoint}")
    private String ENDPOINT;

    private static final String DATA_TYPE = "JSON";
    private LocalDateTime localDateTime;

    //기상청 API에서 사용 가능한 base_time 필드 값
    private final String[] availableTime = {"200", "500", "800", "1100", "1400", "1700", "2000", "2300"};

    public ForecastClient() {
        this.localDateTime = LocalDateTime.now();
    }


    public Forecast getForecast(String x, String y) {
        DefaultUriBuilderFactory builderFactory = new DefaultUriBuilderFactory();
        builderFactory.setEncodingMode(DefaultUriBuilderFactory.EncodingMode.VALUES_ONLY); // URI의 내용을 인코딩하지 않도록 인코딩 모드 적용

        RestTemplate restTemplate = new RestTemplateBuilder()
                .uriTemplateHandler(builderFactory)
                .build();

        UriComponents uri = getUri(x, y);
        ResponseEntity<String> forecast = restTemplate.getForEntity(uri.toUriString(), String.class);
//        forecast.getBody()
        System.out.println("forecast = " + forecast);
//        StringUtils.collectionToCommaDelimitedString(locationList).replace("\"", "");

//        //년월일 받아오는 부분
//        SimpleDateFormat timeSdf = new SimpleDateFormat("HH");
//        // 현재시간 받아오는 부분
//        Calendar cal = Calendar.getInstance();
//        // 현재시간을 받아온다.
//        gi.setNowDate(dateSdf.format(cal.getTime()));
//        // 날짜 세팅
//        gi.setNowTime(timeSdf.format(cal.getTime()));
//        // 시간 세팅
//        /** 하루 전체의 기상예보를 받아오려면 전날 23시에 266개의 날씨정보를 호출해와야 한다.
//         * 따라서 호출 값은 현재 날짜보다 1일전으로 세팅해줘야 한다.
//         **/
//        cal.add(Calendar.DATE, -1);
//        //1일전 날짜를 구하기 위해 현재 날짜에서 -1 시켜주는 부분 gi.setCallDate(dateSdf.format(cal.getTime()));
//        // 1일전 값으로 호출값 생성 Log.i(TAG,"DATE : "+gi.getNowDate()); Log.i(TAG,"TIME : "+gi.getNowTime()); Log.i(TAG,"CALL DATE : "+gi.getCallDate()); }

        return new Forecast();
    }

    private UriComponents getUri(String x, String y) {
        return UriComponentsBuilder.fromHttpUrl(ENDPOINT)
                .queryParam("serviceKey", SERVICE_KEY)
                .queryParam("pageNo", "1")
                .queryParam("numOfRows", "1000")
                .queryParam("base_date", getLocalDate())
                .queryParam("base_time", getNearestAvailableTime())
                .queryParam("base_time", "2300")
                .queryParam("nx", x)
                .queryParam("ny", y)
                .queryParam("dataType", DATA_TYPE)
                .build();
    }

    private String getLocalDate() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate localDate = localDateTime.toLocalDate();
        if (LocalTime.now().isBefore(LocalTime.of(2,00))) {
            localDate.minusDays(1L);
        }
        return localDate.format(dateTimeFormatter);
    }

    private String getNearestAvailableTime() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HHmm");
        int nowTime = Integer.parseInt(localDateTime.toLocalTime().format(dateTimeFormatter));
        int first = Stream.of(availableTime)
                .mapToInt(Integer::parseInt)
                .filter(i -> i <= nowTime)
                .max().orElse(2300);
        return String.valueOf(first<1200?"0"+first:first);
    }


}
