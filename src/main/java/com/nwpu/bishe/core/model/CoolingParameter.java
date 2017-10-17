package com.nwpu.bishe.core.model;

/**
 * Created by chunk on 2017/10/13.
 */
public class CoolingParameter {

    private double originTemperature;

    private double finalTemperature;

    private double timeSpan;

    public CoolingParameter() {
    }

    public CoolingParameter(double originTemperature, double finalTemperature, double timeSpan) {
        this.originTemperature = originTemperature;
        this.finalTemperature = finalTemperature;
        this.timeSpan = timeSpan;
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
