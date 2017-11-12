package com.nwpu.bishe.core.service;

import com.nwpu.bishe.common.constant.SRMConstant;
import com.nwpu.bishe.common.utils.GlobalUtil;
import com.nwpu.bishe.core.jpa.entity.*;
import com.nwpu.bishe.core.jpa.repository.*;
import com.nwpu.bishe.core.model.CoolingParameter;
import com.nwpu.bishe.core.model.IgnitionParameter;
import com.nwpu.bishe.core.model.MaterialParameter;
import com.nwpu.bishe.core.model.StarGeometricParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by chunk on 2017/11/12.
 */
@Service
public class CalculateResultService {

    @Autowired
    private CalculateResultRepository calculateResultRepository;

    @Autowired
    private CoolingRepository coolingRepository;

    @Autowired
    private IgnitionRepository ignitionRepository;

    @Autowired
    private MaterialRepository materialRepository;

    @Autowired
    private StarGeometryRepository starGeometryRepository;

    public void saveStarCalculateResult(String path, List<Double> stresss, StarGeometricParameter starGeometricParameter, MaterialParameter materialParameter, IgnitionParameter ignitionParameter, CoolingParameter coolingParameter){
        CalculateResult calculateResult = new CalculateResult();
        String userName = GlobalUtil.getUserName();
        calculateResult.setCalculatePath(path);
        calculateResult.setUserName(userName);
        calculateResult.setGeometric("star");
        calculateResult.setTime(new Date());
        calculateResult.setEprincipal1(stresss.get(0));
        calculateResult.setEprincipal2(stresss.get(1));
        calculateResult.setGeometricId(Math.toIntExact(this.saveStarGeometry(userName, starGeometricParameter)));
        calculateResult.setMaterialId(Math.toIntExact(this.saveMaterial(userName, materialParameter)));
        calculateResult.setCoolingId(Math.toIntExact(this.saveCooling(userName, coolingParameter)));
        calculateResult.setIgnitionId(Math.toIntExact(this.saveIgnition(userName, ignitionParameter)));
        calculateResultRepository.save(calculateResult);
    }

    public Long saveStarGeometry(String userName,StarGeometricParameter starGeometricParameter){

        StarGeometry starGeometry = new StarGeometry();
        starGeometry.setUserName(userName);
        starGeometry.setArcRadius(starGeometricParameter.getArcRadius());
        starGeometry.setEllipseYAxis(starGeometricParameter.getEllipseYAxis());
        starGeometry.setFeatureLength(starGeometricParameter.getFeatureLength());
        starGeometry.setGrainLength(starGeometricParameter.getGrainLength());
        starGeometry.setOuterRadius(starGeometricParameter.getOuterRadius());
        starGeometry.setStarArcRadius(starGeometricParameter.getStarArcRadius());
        starGeometry.setStarCoefficient(starGeometricParameter.getStarCoefficient());
        starGeometry.setStarNum(starGeometricParameter.getStarNum());
        starGeometry.setStartAngle(starGeometricParameter.getStartAngle());
        starGeometryRepository.save(starGeometry);
        return starGeometry.getId();
    }

    public Long saveMaterial(String userName,MaterialParameter materialParameter){

        Material material = new Material();
        material.setUserName(userName);
        material.setDensity(materialParameter.getDensity());
        material.setExpansion(materialParameter.getExpansion());
        material.setModulus(materialParameter.getModulus());
        material.setPoissonRatio(materialParameter.getPoissonRatio());
        material.setPronyTable(materialParameter.getPronyTable().toString());
        material.setTrsTable(materialParameter.getTrsTable().toString());
        materialRepository.save(material);
        return material.getId();
    }
    
    public Long saveIgnition(String userName,IgnitionParameter ignitionParameter){

        Ignition ignition = new Ignition();
        ignition.setUserName(userName);
        ignition.setMaxPressure(ignitionParameter.getMaxPressure());
        ignition.setTimeSpan(ignition.getTimeSpan());
        ignitionRepository.save(ignition);
        return ignition.getId();
    }
    
    public Long saveCooling(String userName,CoolingParameter coolingParameter){

        Cooling cooling = new Cooling();
        cooling.setUserName(userName);
        cooling.setFinalTemperature(coolingParameter.getFinalTemperature());
        cooling.setOriginTemperature(coolingParameter.getOriginTemperature());
        cooling.setTimeSpan(coolingParameter.getTimeSpan());
        coolingRepository.save(cooling);
        return cooling.getId();
    }
    
    
}
