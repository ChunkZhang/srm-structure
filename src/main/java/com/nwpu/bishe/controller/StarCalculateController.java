package com.nwpu.bishe.controller;

import com.google.common.collect.Lists;
import com.nwpu.bishe.common.MVC.response.StandardJsonObject;
import com.nwpu.bishe.common.constant.SRMConstant;
import com.nwpu.bishe.common.utils.GlobalUtil;
import com.nwpu.bishe.core.jpa.entity.User;
import com.nwpu.bishe.core.jpa.repository.UserRepository;
import com.nwpu.bishe.core.model.CoolingParameter;
import com.nwpu.bishe.core.model.IgnitionParameter;
import com.nwpu.bishe.core.model.MaterialParameter;
import com.nwpu.bishe.core.model.StarGeometricParameter;
import com.nwpu.bishe.core.service.CalculateResultService;
import com.nwpu.bishe.core.service.calculate.PostService;
import com.nwpu.bishe.core.service.calculate.StarCalculateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by chunk on 2017/10/10.
 */
@Controller
public class StarCalculateController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StarCalculateService starCalculateService;

    @Autowired
    private PostService postService;

    @Autowired
    private CalculateResultService calculateResultService;

    @RequestMapping(value = "/generateGeometry")
    @ResponseBody
    public StandardJsonObject generateTest(HttpServletResponse response,StarGeometricParameter starGeometricParameter){
//        starGeometricParameter = new StarGeometricParameter(6,0.8,500,200,5,80,15,200,1500);
        List<String> picPathList = starCalculateService.generateGeometry(starGeometricParameter);
        StandardJsonObject result = new StandardJsonObject();
        result.putEntry("picPathList",picPathList);
        Cookie cookie = new Cookie("picPathList",picPathList.toString());
        cookie.setMaxAge(60*60);
        response.addCookie(cookie);
        return result;
    }

    @RequestMapping(value = "/generateTest")
    @ResponseBody
    public StandardJsonObject generate(HttpServletResponse response,StarGeometricParameter starGeometricParameter){
//        starGeometricParameter = new StarGeometricParameter(6,0.8,500,200,5,80,15,200,1500);
        int a= 1;
        return StandardJsonObject.newCorrectJsonObject();
    }

    @RequestMapping(value = "/calculateTest")
    @ResponseBody
    public StandardJsonObject calculateTest(StarGeometricParameter starGeometricParameter,MaterialParameter materialParameter,CoolingParameter coolingParameter, IgnitionParameter ignitionParameter){
       /* StarGeometricParameter starGeometricParameter = new StarGeometricParameter(6, 0.8, 500, 200, 5, 80, 15, 200, 1500);
        HashMap<String, List<Double>> pronyTable = new HashMap<>();
        pronyTable.put("PronyTable1", Lists.newArrayList(0.408,0.408,5.54));
        pronyTable.put("PronyTable2", Lists.newArrayList(0.286,0.286,55.42));
        pronyTable.put("PronyTable3", Lists.newArrayList(0.13,0.13,554.17));
        MaterialParameter materialParameter = new MaterialParameter(0.48, 9.5E-05, 1.77E-09, 5.25, pronyTable, Lists.newArrayList(20.0, 20.0, 573.0));
        CoolingParameter coolingParameter = new CoolingParameter(73.0,20.0,190800);
        IgnitionParameter ignitionParameter = new IgnitionParameter(10.0, 0.1);*/
        starCalculateService.calculate(starGeometricParameter,materialParameter,coolingParameter,ignitionParameter);
        return StandardJsonObject.newErrorJsonObject("计算中，请稍后");
    }


    @RequestMapping(value = "/inputTest")
    @ResponseBody
    public StandardJsonObject inputTest(StarGeometricParameter starGeometricParameter,MaterialParameter materialParameter,CoolingParameter coolingParameter, IgnitionParameter ignitionParameter){
       /* StarGeometricParameter starGeometricParameter = new StarGeometricParameter(6, 0.8, 500, 200, 5, 80, 15, 200, 1500);
        HashMap<String, List<Double>> pronyTable = new HashMap<>();
        pronyTable.put("PronyTable1", Lists.newArrayList(0.408,0.408,5.54));
        pronyTable.put("PronyTable2", Lists.newArrayList(0.286,0.286,55.42));
        pronyTable.put("PronyTable3", Lists.newArrayList(0.13,0.13,554.17));
        MaterialParameter materialParameter = new MaterialParameter(0.48, 9.5E-05, 1.77E-09, 5.25, pronyTable, Lists.newArrayList(20.0, 20.0, 573.0));
        CoolingParameter coolingParameter = new CoolingParameter(73.0,20.0,190800);
        IgnitionParameter ignitionParameter = new IgnitionParameter(10.0, 0.1);*/
        int a = 0;
        return StandardJsonObject.newErrorJsonObject("计算中，请稍后");
    }

    @RequestMapping(value = "/dababaseTest")
    @ResponseBody
    public void dababaseTest(){
        StarGeometricParameter starGeometricParameter = new StarGeometricParameter(6, 0.8, 500, 200, 5, 80, 15, 200, 1500);
        HashMap<String, List<Double>> pronyTable = new HashMap<>();
        pronyTable.put("PronyTable1", Lists.newArrayList(0.408,0.408,5.54));
        pronyTable.put("PronyTable2", Lists.newArrayList(0.286,0.286,55.42));
        pronyTable.put("PronyTable3", Lists.newArrayList(0.13,0.13,554.17));
        MaterialParameter materialParameter = new MaterialParameter(0.48, 9.5E-05, 1.77E-09, 5.25, pronyTable, Lists.newArrayList(20.0, 20.0, 573.0));
        CoolingParameter coolingParameter = new CoolingParameter(73.0,20.0,190800);
        IgnitionParameter ignitionParameter = new IgnitionParameter(10.0, 0.1);
        List<Double> stresss = postService.postProcessing(SRMConstant.CALCULTE_Path + "runtime_2017-11-12_17-40-19");
        calculateResultService.saveStarCalculateResult("chunk",SRMConstant.CALCULTE_Path + "runtime_2017-11-12_17-40-19",stresss,starGeometricParameter,materialParameter,ignitionParameter,coolingParameter);
    }

    @RequestMapping(value = "/postTest")
    @ResponseBody
    public void postTest(){
        postService.postProcessing("C:\\Users\\chunk\\Desktop\\abaqus\\srm-structure\\runtime_2017-11-04_16-42-02");
    }
}
