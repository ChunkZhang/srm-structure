package com.nwpu.bishe.core.service.calculate;

import com.google.common.collect.Lists;
import com.nwpu.bishe.common.constant.SRMConstant;
import com.nwpu.bishe.common.utils.GlobalUtil;
import com.nwpu.bishe.common.utils.PathUtil;
import com.nwpu.bishe.core.jpa.entity.CalculateResult;
import com.nwpu.bishe.core.jpa.repository.*;
import com.nwpu.bishe.core.model.CoolingParameter;
import com.nwpu.bishe.core.model.IgnitionParameter;
import com.nwpu.bishe.core.model.MaterialParameter;
import com.nwpu.bishe.core.model.StarGeometricParameter;
import com.nwpu.bishe.core.service.CalculateResultService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by chunk on 2017/10/16.
 */

@Service
public class StarCalculateService {

    private static final Logger LOGGER = LoggerFactory.getLogger(StarCalculateService.class);

    @Autowired
    private PostService postService;

    @Autowired
    private CalculateResultService calculateResultService;

    public List<String> generateGeometry(StarGeometricParameter starGeometricParameter){

        List<String> picPathList = Lists.newArrayList();
        try {

            BufferedReader bufferedReader = new BufferedReader(new FileReader(PathUtil.getPath()+"/3DStarGrain_Part_Test_1.py"));

            String line = null;
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
            String runtimePath = "runtime_" + dateFormat.format(new Date());
            File filePath = new File(SRMConstant.CALCULTE_Path + runtimePath);
            if (!filePath.mkdirs()){
                throw new IOException("创建运行目录失败");
            }
            File file = new File(SRMConstant.CALCULTE_Path + runtimePath ,"hi.py");
            if (!file.createNewFile()){
                throw new IOException("创建核心文件失败");
            }
            BufferedWriter bufw = new BufferedWriter(new FileWriter(SRMConstant.CALCULTE_Path + runtimePath + "/hi.py"));
            int cont = 0;
            while ((line=bufferedReader.readLine())!=null) {
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
                    case 460:
                        bufw.write("    fileName='"+ SRMConstant.CALCULTE_Path.replace("\\","/")   + runtimePath + "/geometry1', ");
                        bufw.write("\n");
                        break;
                    case 468:
                        bufw.write("    fileName='"+ SRMConstant.CALCULTE_Path.replace("\\","/")   + runtimePath + "/geometry2', ");
                        bufw.write("\n");
                        break;
                    case 477:
                        bufw.write("    fileName='"+ SRMConstant.CALCULTE_Path.replace("\\","/")   + runtimePath + "/geometry3', ");
                        bufw.write("\n");
                        break;
                    default:
                        bufw.write(line);
                        bufw.write("\n");
                }

            }
            picPathList.add(SRMConstant.CALCULTE_Path  + runtimePath + "\\geometry1");
            picPathList.add(SRMConstant.CALCULTE_Path  + runtimePath + "\\geometry2");
            picPathList.add(SRMConstant.CALCULTE_Path  + runtimePath + "\\geometry3");
            bufw.flush();
            bufw.close();
            bufferedReader.close();
            String cmd = "cmd /c cd " + SRMConstant.CALCULTE_Path + runtimePath + " && abaqus cae noGUI=hi.py";
            Process process = Runtime.getRuntime().exec(cmd);

        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error(e.getMessage());
        }finally {
            return picPathList;
        }
    }

    public List calculate(StarGeometricParameter starGeometricParameter, MaterialParameter materialParameter, CoolingParameter coolingParameter, IgnitionParameter ignitionParameter){

        List result = Lists.newArrayList();
        try {

            BufferedReader bufferedReader = new BufferedReader(new FileReader(PathUtil.getPath()+"/3DStarGrain_Calculate_Test_1.py"));

            String line = null;
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
            String runtimePath = "runtime_" + dateFormat.format(new Date());
            File filePath = new File(SRMConstant.CALCULTE_Path + runtimePath);
            if (!filePath.mkdirs()){
                throw new IOException("创建运行目录失败");
            }
            File file = new File(SRMConstant.CALCULTE_Path + runtimePath ,"hi.py");
            if (!file.createNewFile()){
                throw new IOException("创建核心文件失败");
            }
            BufferedWriter bufw = new BufferedWriter(new FileWriter(SRMConstant.CALCULTE_Path + runtimePath + "/hi.py"));
            int cont = 0;
            while ((line=bufferedReader.readLine())!=null) {
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
                    case 46:
                        bufw.write("PoissonRatio = "+materialParameter.getPoissonRatio());
                        bufw.write("\n");
                        break;
                    case 47:
                        bufw.write("Expansion1 = "+materialParameter.getExpansion());
                        bufw.write("\n");
                        break;
                    case 48:
                        bufw.write("Density1 = "+materialParameter.getDensity());
                        bufw.write("\n");
                        break;
                    case 49:
                        bufw.write("Modulus = "+materialParameter.getModulus());
                        bufw.write("\n");
                        break;
                    case 50:
                        bufw.write("PronyTable1 = ("+materialParameter.getPronyTable().get("PronyTable1").get(0)+","
                                +materialParameter.getPronyTable().get("PronyTable1").get(1)+","
                                +materialParameter.getPronyTable().get("PronyTable1").get(2)+")");
                        bufw.write("\n");
                        break;
                    case 51:
                        bufw.write("PronyTable2 = ("+materialParameter.getPronyTable().get("PronyTable2").get(0)+","
                                +materialParameter.getPronyTable().get("PronyTable2").get(1)+","
                                +materialParameter.getPronyTable().get("PronyTable2").get(2)+")");
                        bufw.write("\n");
                        break;
                    case 52:
                        bufw.write("PronyTable3 = ("+materialParameter.getPronyTable().get("PronyTable3").get(0)+","
                                +materialParameter.getPronyTable().get("PronyTable3").get(1)+","
                                +materialParameter.getPronyTable().get("PronyTable3").get(2)+")");
                        bufw.write("\n");
                        break;
                    case 53:
                        bufw.write("TrsTable = ("+materialParameter.getTrsTable().get(0)+","+materialParameter.getTrsTable().get(0)+","+materialParameter.getTrsTable().get(0)+")");
                        bufw.write("\n");
                        break;

                    case 55:
                        bufw.write("TemperatureOriginal = "+coolingParameter.getOriginTemperature());
                        bufw.write("\n");
                        break;

                    case 56:
                        bufw.write("TemperatureFinal = "+coolingParameter.getFinalTemperature());
                        bufw.write("\n");
                        break;
                    case 57:
                        bufw.write("Time = "+coolingParameter.getTimeSpan());
                        bufw.write("\n");
                        break;
                    case 59:
                        bufw.write("PressureTime = "+ignitionParameter.getTimeSpan());
                        bufw.write("\n");
                        break;
                    case 60:
                        bufw.write("PressureMax = "+ignitionParameter.getMaxPressure());
                        bufw.write("\n");
                        break;
                    case 460:
                        bufw.write("    fileName='"+ SRMConstant.CALCULTE_Path.replace("\\","/")   + runtimePath + "/geometry1', ");
                        bufw.write("\n");
                        break;
                    case 468:
                        bufw.write("    fileName='"+ SRMConstant.CALCULTE_Path.replace("\\","/")   + runtimePath + "/geometry2', ");
                        bufw.write("\n");
                        break;
                    case 477:
                        bufw.write("    fileName='"+ SRMConstant.CALCULTE_Path.replace("\\","/")   + runtimePath + "/geometry3', ");
                        bufw.write("\n");
                        break;
                    case 478:
                        int a= 1;
                    default:
                        bufw.write(line);
                        bufw.write("\n");
                }

            }
            result.add(SRMConstant.CALCULTE_Path  + runtimePath + "");
            bufw.flush();
            bufw.close();
            bufferedReader.close();
            String cmd = "cmd /c cd " + SRMConstant.CALCULTE_Path + runtimePath + " && abaqus cae noGUI=hi.py";
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Process process = Runtime.getRuntime().exec(cmd);
                        process.waitFor();
                        List<Double> stresss = postService.postProcessing(SRMConstant.CALCULTE_Path + runtimePath);
                        calculateResultService.saveStarCalculateResult(SRMConstant.CALCULTE_Path + runtimePath,stresss,starGeometricParameter,materialParameter,ignitionParameter,coolingParameter);

                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error(e.getMessage());
        }finally {
            return result;
        }
    }

}
