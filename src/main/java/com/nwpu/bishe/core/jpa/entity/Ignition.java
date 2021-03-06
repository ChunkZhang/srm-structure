package com.nwpu.bishe.core.jpa.entity;

import com.nwpu.bishe.common.database.jpa.BaseEntity;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by chunk on 2017/11/9.
 */
@Entity
@DynamicUpdate
@Table(name = "srm_structure_ignition")
public class Ignition extends BaseEntity{

    private String userName;

    private double maxPressure;

    @Column(name = "time_span")
    private double timeSpan;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
