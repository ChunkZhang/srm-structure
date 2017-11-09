package com.nwpu.bishe.core.jpa.entity;

import com.nwpu.bishe.common.database.jpa.BaseEntity;

/**
 * Created by chunk on 2017/11/9.
 */
public class Cooling extends BaseEntity {

    private String userName;

    private int coolingId;

    private double originTemperature;

    private double finalTemperature;

    private double timeSpan;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getCoolingId() {
        return coolingId;
    }

    public void setCoolingId(int coolingId) {
        this.coolingId = coolingId;
    }

    public double getOriginTemperature() {
        return originTemperature;
    }

    public void setOriginTemperature(double originTemperature) {
        this.originTemperature = originTemperature;
    }

    public double getFinalTemperature() {
        return finalTemperature;
    }

    public void setFinalTemperature(double finalTemperature) {
        this.finalTemperature = finalTemperature;
    }

    public double getTimeSpan() {
        return timeSpan;
    }

    public void setTimeSpan(double timeSpan) {
        this.timeSpan = timeSpan;
    }
}
