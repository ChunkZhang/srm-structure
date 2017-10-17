package com.nwpu.bishe.core.model;


/**
 * Created by chunk on 2017/10/13.
 */
public class StarGeometricParameter {

    private int starNum;

    private double starCoefficient;

    private double outerRadius;

    private double featureLength;

    //过度圆弧半径
    private double arcRadius;

    private double startAngle;

    //星角圆弧半径
    private double starArcRadius;

    private double ellipseYAxis;

    private double grainLength;

    public StarGeometricParameter() {

    }

    public StarGeometricParameter(int starNum, double starCoefficient, double outerRadius, double featureLength, double arcRadius, double startAngle, double starArcRadius, double ellipseYAxis, double grainLength) {
        this.starNum = starNum;
        this.starCoefficient = starCoefficient;
        this.outerRadius = outerRadius;
        this.featureLength = featureLength;
        this.arcRadius = arcRadius;
        this.startAngle = startAngle;
        this.starArcRadius = starArcRadius;
        this.ellipseYAxis = ellipseYAxis;
        this.grainLength = grainLength;
    }

    public int getStarNum() {
        return starNum;
    }

    public void setStarNum(int starNum) {
        this.starNum = starNum;
    }

    public double getStarCoefficient() {
        return starCoefficient;
    }

    public void setStarCoefficient(double starCoefficient) {
        this.starCoefficient = starCoefficient;
    }

    public double getOuterRadius() {
        return outerRadius;
    }

    public void setOuterRadius(double outerRadius) {
        this.outerRadius = outerRadius;
    }

    public double getFeatureLength() {
        return featureLength;
    }

    public void setFeatureLength(double featureLength) {
        this.featureLength = featureLength;
    }

    public double getArcRadius() {
        return arcRadius;
    }

    public void setArcRadius(double arcRadius) {
        this.arcRadius = arcRadius;
    }

    public double getStartAngle() {
        return startAngle;
    }

    public void setStartAngle(double startAngle) {
        this.startAngle = startAngle;
    }

    public double getStarArcRadius() {
        return starArcRadius;
    }

    public void setStarArcRadius(double starArcRadius) {
        this.starArcRadius = starArcRadius;
    }

    public double getEllipseYAxis() {
        return ellipseYAxis;
    }

    public void setEllipseYAxis(double ellipseYAxis) {
        this.ellipseYAxis = ellipseYAxis;
    }

    public double getGrainLength() {
        return grainLength;
    }

    public void setGrainLength(double grainLength) {
        this.grainLength = grainLength;
    }
}
