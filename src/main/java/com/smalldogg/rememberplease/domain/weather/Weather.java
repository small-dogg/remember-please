package com.smalldogg.rememberplease.domain.weather;

import com.smalldogg.rememberplease.domain.BaseTimeEntity;
import org.springframework.data.domain.Persistable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Weather extends BaseTimeEntity implements Persistable<String> {

    @Id
    private String id;
    private String name;
    private String dong;//영작
    private float tempAvg;//오늘 평균 기온
    private float temp;//현재 기온

    @Override
    public String getId() {
        return null;
    }

    @Override
    public boolean isNew() {
        return false;
    }
}
