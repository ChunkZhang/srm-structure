package com.nwpu.bishe.core.jpa.entity;

import com.nwpu.bishe.common.database.jpa.BaseEntity;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by chunk on 2017/11/9.
 */
@Entity
@DynamicUpdate
@Table(name = "srm_structure_star")
public class StarGeometry extends BaseEntity {

    private String userName;

    private int starNum;

    private double starCoefficient;

    private double outerRadius;

    private double featureLength;

    //过度圆弧半径
    private double arcRadius;

    private double startAngle;

    //星角圆弧半径
    private double starArcRadius;

    private double ellipseyaxis;

    private double grainLength;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public double getEllipseyaxis() {
        return ellipseyaxis;
    }

    public void setEllipseyaxis(double ellipseyaxis) {
        this.ellipseyaxis = ellipseyaxis;
    }

    public double getGrainLength() {
        return grainLength;
    }

    public void setGrainLength(double grainLength) {
        this.grainLength = grainLength;
    }
}
