package com.nwpu.bishe.common.utils;


import com.google.common.collect.Lists;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by chunk on 2017/11/11.
 */

public class GlobalUtil {

    public static HttpServletRequest getHttpServletRequest(){
        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder
                .getRequestAttributes())
                .getRequest();
        return request;
    }

    public static HttpSession getHttpSession(){
        return getHttpServletRequest().getSession();
    }

    public static String getUserName(){
        HttpServletRequest httpServletRequest = getHttpServletRequest();
        Cookie[] cookies = httpServletRequest.getCookies();
        String userName ;
        for (Cookie cookie: cookies
             ) {
            if (cookie.getName().equals("UserName")){
                userName = cookie.getValue();
                return userName;
            }
        }
        return "";
    }
}