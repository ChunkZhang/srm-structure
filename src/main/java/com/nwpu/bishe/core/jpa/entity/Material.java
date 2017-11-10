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
@Table(name = "srm_structure_material")
public class Material extends BaseEntity {

    private String userName;

    private int materialId;

    private double poissonRatio;

    private double expansion;

    private double density;

    private double modulus;

    private String pronyTable;

    private String trsTable;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getMaterialId() {
        return materialId;
    }

    public void setMaterialId(int materialId) {
        this.materialId = materialId;
    }

    public double getPoissonRatio() {
        return poissonRatio;
    }

    public void setPoissonRatio(double poissonRatio) {
        this.poissonRatio = poissonRatio;
    }

    public double getExpansion() {
        return expansion;
    }

    public void setExpansion(double expansion) {
        this.expansion = expansion;
    }

    public double getDensity() {
        return density;
    }

    public void setDensity(double density) {
        this.density = density;
    }

    public double getModulus() {
        return modulus;
    }

    public void setModulus(double modulus) {
        this.modulus = modulus;
    }

    public String getPronyTable() {
        return pronyTable;
    }

    public void setPronyTable(String pronyTable) {
        this.pronyTable = pronyTable;
    }

    public String getTrsTable() {
        return trsTable;
    }

    public void setTrsTable(String trsTable) {
        this.trsTable = trsTable;
    }
}
