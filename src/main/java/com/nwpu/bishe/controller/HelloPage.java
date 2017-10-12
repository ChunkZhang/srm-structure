package com.nwpu.bishe.controller;

import com.nwpu.bishe.core.jpa.entity.User;
import com.nwpu.bishe.core.jpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by chunk on 2017/10/10.
 */
@Controller
public class HelloPage {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/helloPage")
    @ResponseBody
    public String helloPage(){
        User byId = userRepository.findById(10l);
        int a = 1;
        return byId.getUserName();
    }
}
