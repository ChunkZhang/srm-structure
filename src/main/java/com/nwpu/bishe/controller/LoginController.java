package com.nwpu.bishe.controller;

import com.nwpu.bishe.common.enumeration.LoginStatus;
import com.nwpu.bishe.core.service.UserService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by chunk on 2017/11/9.
 */
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login")
    @ResponseBody
    public JSONObject login(HttpServletResponse response, String userName, String password){
        LoginStatus loginStatus = userService.login(response,userName, password);
        JSONObject result = new JSONObject();
        result.put("LoginStatus",loginStatus);
        return result;
    }

    @RequestMapping(value = "/exit")
    @ResponseBody
    public JSONObject exit(HttpServletResponse response, String userName){
        LoginStatus loginStatus = userService.exit(response,userName);
        JSONObject result = new JSONObject();

        result.put("LoginStatus",loginStatus);
        return result;
    }
}
