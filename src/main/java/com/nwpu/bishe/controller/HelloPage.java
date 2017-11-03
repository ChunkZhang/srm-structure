package com.nwpu.bishe.controller;

import com.nwpu.bishe.core.jpa.entity.User;
import com.nwpu.bishe.core.jpa.repository.UserRepository;
import com.nwpu.bishe.core.model.StarGeometricParameter;
import com.nwpu.bishe.core.service.calculate.StarCalculateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by chunk on 2017/10/10.
 */
@Controller
public class HelloPage {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    StarCalculateService starCalculateService;

    @RequestMapping(value = "/helloPage")
    @ResponseBody
    public String helloPage(){
        User byId = userRepository.findById(10l);
        int a = 1;
        return byId.getUserName();
    }

    @RequestMapping(value = "/generateTest")
    @ResponseBody
    public List<String> generateTest(){

        List<String> picPathList = starCalculateService.generateGeometry(new StarGeometricParameter(6,0.8,500,200,5,80,15,200,1500));
        return picPathList;
    }
}
