package com.nwpu.bishe.core.model;

/**
 * Created by chunk on 2017/10/13.
 */
public class IgnitionParameter {

    private double maxPressure;

    private double timeSpan;

    public IgnitionParameter(double maxPressure, double timeSpan) {
        this.maxPressure = maxPressure;
        this.timeSpan = timeSpan;
    }

    public double getMaxPressure() {
        return maxPressure;
    }

    public void setMaxPressure(double maxPressure) {
        this.maxPressure = maxPressure;
    }

    public double getTimeSpan() {
        return timeSpan;
    }

    public void setTimeSpan(double timeSpan) {
        this.timeSpan = timeSpan;
    }
}
