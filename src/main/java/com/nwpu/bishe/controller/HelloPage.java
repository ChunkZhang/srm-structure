package com.nwpu.bishe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by chunk on 2017/10/10.
 */
@Controller
public class HelloPage {

    @RequestMapping(value = "/helloPage")
    @ResponseBody
    public int helloPage(){
        int a = 1;
        return a;
    }
}
