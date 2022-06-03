package com.smalldogg.rememberplease.domain.weather;

import com.smalldogg.rememberplease.domain.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Persistable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Weather extends BaseTimeEntity implements Persistable<String> {

    @Id
    private String id;
    private String city;
    private String state;
    private String town;
    private float tempAvg;//오늘 평균 기온
    private float temp;//현재 기온

    public Weather(String city, String state, String town, float tempAvg, float temp) {
        this.city = city;
        this.state = state;
        this.town = town;
        this.tempAvg = tempAvg;
        this.temp = temp;
    }

    @Override
    public String getId() {
        return null;
    }

    @Override
    public boolean isNew() {
        return false;
    }
}
