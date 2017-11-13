package com.nwpu.bishe.core.service.calculate;

import com.google.common.collect.Lists;
import com.nwpu.bishe.common.utils.PathUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;

/**
 * Created by chunk on 2017/11/12.
 */
@Service
public class PostService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PostService.class);

    public List<Double> postProcessing(String path){
        List<Double> result = Lists.newArrayList();
        try {

            BufferedReader bufferedReader = new BufferedReader(new FileReader(PathUtil.getPath() + "/post_test1.py"));

            String line = null;
            File file = new File(path, "post.py");
            if (!file.createNewFile()) {
                throw new IOException("创建核心文件失败");
            }
            BufferedWriter bufw = new BufferedWriter(new FileWriter(path + "/post.py"));
            int cont = 0;
            while ( (line = bufferedReader.readLine())!=null){
                cont++;
                switch (cont) {
                    case 32:
                        bufw.write("    fileName='"+path.replace("\\","/")+"/smises2', ");
                        bufw.write("\n");
                        break;
                    case 42:
                        bufw.write("    fileName='"+path.replace("\\","/")+"/uall2', ");
                        bufw.write("\n");
                        break;
                    case 51:
                        bufw.write("    fileName='"+path.replace("\\","/")+"/eprincipal2', ");
                        bufw.write("\n");
                        break;
                    case 59:
                        bufw.write("    fileName='"+path.replace("\\","/")+"/eprincipal1', ");
                        bufw.write("\n");
                        break;
                    case 68:
                        bufw.write("    fileName='"+path.replace("\\","/")+"/smises1', ");
                        bufw.write("\n");
                        break;
                    case 77:
                        bufw.write("    fileName='"+path.replace("\\","/")+"/uall1', ");
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
            String cmd = "cmd /c cd " + path + " && abaqus viewer noGUI=post.py";
            Process process = Runtime.getRuntime().exec(cmd);
            process.waitFor();
            result = getMaxMisesStress(path);
        }catch (Exception e){
            e.printStackTrace();
            LOGGER.error(e.getMessage());
        }finally {
            return result;
        }
    }

    public List<Double> getMaxMisesStress(String path){
        List<Double> result = Lists.newArrayList();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(PathUtil.getPath() + "/getOdbMises.py"));
            String line = null;
            File file = new File(path, "getOdbMises.py");
            if (!file.createNewFile()) {
                throw new IOException("创建核心文件失败");
            }
            BufferedWriter bufw = new BufferedWriter(new FileWriter(path + "/getOdbMises.py"));
            while ( (line = bufferedReader.readLine())!=null){
                bufw.write(line);
                bufw.write("\n");
            }
            bufw.flush();
            bufw.close();
            bufferedReader.close();
            String cmd = "cmd /c cd " + path + " && abaqus python getOdbMises.py -odb Job-1.odb -elset \" ALL ELEMENTS\"";
            Process process = Runtime.getRuntime().exec(cmd);
            process.waitFor();
            result = getDataFromFile(path);
        }catch (Exception e){
            e.printStackTrace();
            LOGGER.error(e.getMessage());
        }finally {
            return result;
        }
    }

    private List<Double> getDataFromFile(String path){
        List<Double> result = Lists.newArrayList();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path + "/data.txt"));
            double coolingStress = 100*(Double.parseDouble(bufferedReader.readLine()));
            double ignitionStress = 100*Double.parseDouble(bufferedReader.readLine())-coolingStress;
            result.add(coolingStress);
            result.add(ignitionStress);
        }catch (Exception e){
            e.printStackTrace();
            LOGGER.error(e.getMessage());
        }finally {
            return result;
        }
    }

}
