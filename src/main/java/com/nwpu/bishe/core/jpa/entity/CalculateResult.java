package com.nwpu.bishe.core.jpa.entity;

import com.nwpu.bishe.common.database.jpa.BaseEntity;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by chunk on 2017/11/9.
 */
@Entity
@DynamicUpdate
@Table(name = "srm_structure_calculate")
public class CalculateResult extends BaseEntity {

    private String userName;

    private String geometric;

    private int geometricId;

    private Date time;

    private String calculatePath;

    private int materialId;

    private int ignitionId;

    private int coolingId;

    private double eprincipal1;

    private double eprincipal2;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGeometric() {
        return geometric;
    }

    public void setGeometric(String geometric) {
        this.geometric = geometric;
    }

    public int getGeometricId() {
        return geometricId;
    }

    public void setGeometricId(int geometricId) {
        this.geometricId = geometricId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getCalculatePath() {
        return calculatePath;
    }

    public void setCalculatePath(String calculatePath) {
        this.calculatePath = calculatePath;
    }

    public int getMaterialId() {
        return materialId;
    }

    public void setMaterialId(int materialId) {
        this.materialId = materialId;
    }

    public int getIgnitionId() {
        return ignitionId;
    }

    public void setIgnitionId(int ignitionId) {
        this.ignitionId = ignitionId;
    }

    public int getCoolingId() {
        return coolingId;
    }

    public void setCoolingId(int coolingId) {
        this.coolingId = coolingId;
    }

    public double getEprincipal1() {
        return eprincipal1;
    }

    public void setEprincipal1(double eprincipal1) {
        this.eprincipal1 = eprincipal1;
    }

    public double getEprincipal2() {
        return eprincipal2;
    }

    public void setEprincipal2(double eprincipal2) {
        this.eprincipal2 = eprincipal2;
    }
}
