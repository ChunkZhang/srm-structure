package com.nwpu.bishe.core.service;

import com.nwpu.bishe.core.model.CoolingParameter;
import com.nwpu.bishe.core.model.IgnitionParameter;
import com.nwpu.bishe.core.model.MaterialParameter;
import com.nwpu.bishe.core.model.StarGeometricParameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.*;

/**
 * Created by chunk on 2017/10/16.
 */

@Service
public class StarCalculateService {

    private static final Logger LOGGER = LoggerFactory.getLogger(StarCalculateService.class);

    public void generateGeometry(StarGeometricParameter starGeometricParameter){

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/3DStarGrain_Part_Test_1.py"));
            String line = null;
            BufferedWriter bufw = new BufferedWriter(new FileWriter("/runtime\\hi.py"));
            int cont = 0;
            while ((line=bufferedReader.readLine())!=null) {
                //            System.out.println(line);
                cont++;
                switch(cont){
                    case 34:
                        bufw.write("StarNum = "+starGeometricParameter.getStarNum());
                        bufw.write("\n");
                        break;
                    case 35:
                        bufw.write("StarCoefficient = "+starGeometricParameter.getStarCoefficient());
                        bufw.write("\n");
                        break;
                    case 36:
                        bufw.write("OuterRadius = "+starGeometricParameter.getOuterRadius());
                        bufw.write("\n");
                        break;
                    case 37:
                        bufw.write("FeatureLength = "+starGeometricParameter.getFeatureLength());
                        bufw.write("\n");
                        break;
                    case 38:
                        bufw.write("ArcRadius = "+starGeometricParameter.getArcRadius());
                        bufw.write("\n");
                        break;
                    case 39:
                        bufw.write("StarAngle = "+starGeometricParameter.getStartAngle());
                        bufw.write("\n");
                        break;
                    case 40:
                        bufw.write("StarArcRadius = "+starGeometricParameter.getStarArcRadius());
                        bufw.write("\n");
                        break;
                    case 42:
                        bufw.write("EllipseYAxis = "+starGeometricParameter.getEllipseYAxis());
                        bufw.write("\n");
                        break;
                    case 43:
                        bufw.write("GrainLength = "+starGeometricParameter.getGrainLength());
                        bufw.write("\n");
                        break;
                    default:
                        bufw.write(line);
                        bufw.write("\n");
                }

            }
            bufw.flush();
            bufw.close();
            bufferedReader.close();
            Runtime.getRuntime().exec("cmd /k start "
                    + "/run_abaqus_noGUI.bat");

        } catch (Exception e) {

        }
    }

    public void calculate(StarGeometricParameter starGeometricParameter, MaterialParameter materialParameter, CoolingParameter coolingParameter, IgnitionParameter ignitionParameter){

    }
}
