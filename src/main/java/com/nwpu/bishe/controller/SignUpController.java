package com.nwpu.bishe.controller;

import com.nwpu.bishe.core.jpa.entity.User;
import com.nwpu.bishe.core.service.UserService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * Created by chunk on 2017/11/9.
 */
public class SignUpController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/signUp")
    @ResponseBody
    public JSONObject signUp( String userName, String password, char phone, String email){

        User user = new User();
        user.setEmail(email);
        user.setPhone(phone);
        user.setUserName(userName);
        user.setPassword(password);
        user.setCreated(new Date());
        user.setUpdated(new Date());
        userService.creatUser(user);
        return new JSONObject().put("SignUpStatus","success");
    }
}
