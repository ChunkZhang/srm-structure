package com.nwpu.bishe.core.model;

/**
 * Created by chunk on 2017/10/13.
 */
public class IgnitionParameter {

    private double maxPressure;

    private double ignitionTimeSpan;

    public IgnitionParameter() {
    }

    public IgnitionParameter(double maxPressure, double ignitionTimeSpan) {
        this.maxPressure = maxPressure;
        this.ignitionTimeSpan = ignitionTimeSpan;
    }

    public double getMaxPressure() {
        return maxPressure;
    }

    public void setMaxPressure(double maxPressure) {
        this.maxPressure = maxPressure;
    }

    public double getignitionTimeSpan() {
        return ignitionTimeSpan;
    }

    public void setignitionTimeSpan(double ignitionTimeSpan) {
        this.ignitionTimeSpan = ignitionTimeSpan;
    }
}
