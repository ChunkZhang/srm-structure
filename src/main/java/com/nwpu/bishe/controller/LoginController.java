package com.nwpu.bishe.controller;

import com.nwpu.bishe.common.MVC.response.StandardJsonObject;
import com.nwpu.bishe.common.enumeration.LoginStatus;
import com.nwpu.bishe.common.utils.GlobalUtil;
import com.nwpu.bishe.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by chunk on 2017/11/9.
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login")
    @ResponseBody
    public StandardJsonObject login(HttpServletResponse response, String userName, String password) throws IOException {
        LoginStatus loginStatus = userService.login(response,userName, password);
        StandardJsonObject result = new StandardJsonObject();
        result.putEntry("LoginStatus",loginStatus);
        if (loginStatus.equals(LoginStatus.SUCCESSED)){
            response.sendRedirect("/srm/views/main.jsp");
        }
        return result;
    }

    @RequestMapping(value = "/exit")
    @ResponseBody
    public StandardJsonObject exit(HttpServletResponse response, String userName){
        LoginStatus loginStatus = userService.exit(response,userName);
        StandardJsonObject result = new StandardJsonObject();
        result.putEntry("LoginStatus",loginStatus);
        return result;
    }
}
