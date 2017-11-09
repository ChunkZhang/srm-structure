package com.nwpu.bishe.common.cookie;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by chunk on 2017/11/9.
 */
public class CookieUserContext {

    public void addLoginCookie(HttpServletResponse response, String userName){
        Cookie cookieLogin = new Cookie("LoginStatus","0");
        Cookie cookieUser = new Cookie("UserName",userName);
        cookieLogin.setMaxAge(60 * 60);
        cookieLogin.setPath("/");
        cookieUser.setMaxAge(60 * 60);
        cookieUser.setPath("/");
        response.addCookie(cookieLogin);
        response.addCookie(cookieUser);
    }

    public void deleteLoginCookie(HttpServletResponse response){
        Cookie cookie = new Cookie("LoginStatus","-1");
        cookie.setPath("/");
        response.addCookie(cookie);
    }
}
