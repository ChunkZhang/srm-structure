package com.nwpu.bishe.core.model;

import java.util.List;
import java.util.Map;

/**
 * Created by chunk on 2017/10/13.
 */
public class MaterialParameter {

    private double poissonRatio;

    private double expansion;

    private double density;

    private double modulus;

    //prony级数
    private Map<String,List<Double>> pronyTable;

    //室温转换因子
    private List<Double> trsTable;

    public MaterialParameter() {
    }

    public MaterialParameter(double poissonRatio, double expansion, double density, double modulus, Map<String, List<Double>> pronyTable, List<Double> trsTable) {
        this.poissonRatio = poissonRatio;
        this.expansion = expansion;
        this.density = density;
        this.modulus = modulus;
        this.pronyTable = pronyTable;
        this.trsTable = trsTable;
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

    public Map<String, List<Double>> getPronyTable() {
        return pronyTable;
    }

    public void setPronyTable(Map<String, List<Double>> pronyTable) {
        this.pronyTable = pronyTable;
    }

    public List<Double> getTrsTable() {
        return trsTable;
    }

    public void setTrsTable(List<Double> trsTable) {
        this.trsTable = trsTable;
    }
}
