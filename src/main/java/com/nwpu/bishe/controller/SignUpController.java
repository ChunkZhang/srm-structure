package com.nwpu.bishe.controller;

import com.nwpu.bishe.common.MVC.response.StandardJsonObject;
import com.nwpu.bishe.common.utils.MD5Utils;
import com.nwpu.bishe.core.jpa.entity.User;
import com.nwpu.bishe.core.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * Created by chunk on 2017/11/9.
 */
@Controller
public class SignUpController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/signUp")
    @ResponseBody
    public StandardJsonObject signUp(HttpServletResponse response, String userName, String password, String phone, String email) throws IOException {

        if (StringUtils.isBlank(userName)){
            return StandardJsonObject.newErrorJsonObject("用户名不能为空");
        }
        if (StringUtils.isBlank(password)){
            return StandardJsonObject.newErrorJsonObject("密码不能为空");
        }
        if (StringUtils.isBlank(phone)){
            return StandardJsonObject.newErrorJsonObject("电话不能为空");
        }
        if (StringUtils.isBlank(email)){
            return StandardJsonObject.newErrorJsonObject("邮箱不能为空");
        }
        User user = new User();
        user.setEmail(email);
        user.setPhone(phone);
        user.setUserName(userName);
        user.setPassword(MD5Utils.MD5Encode(password));
        user.setCreated(new Date());
        user.setUpdated(new Date());
        userService.creatUser(user);
        response.sendRedirect("/srm/views/main.jsp");
        return StandardJsonObject.newCorrectJsonObject();
    }
}
