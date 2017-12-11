package com.nwpu.bishe.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.common.collect.Lists;
import com.nwpu.bishe.common.MVC.response.EasyUIDataGridResult;
import com.nwpu.bishe.common.MVC.response.StandardJsonObject;
import com.nwpu.bishe.common.utils.GlobalUtil;
import com.nwpu.bishe.core.jpa.entity.CalculateResult;
import com.nwpu.bishe.core.service.CalculateResultService;
import org.apache.commons.lang.StringUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by chunk on 2017/11/30.
 */
@Controller
public class HistoryManagerController {

    @Autowired
    private CalculateResultService calculateResultService;


    @RequestMapping(value = "/history")
    @ResponseBody
    public EasyUIDataGridResult getCalculateHistory(){
        String userName = GlobalUtil.getUserName();
        if (StringUtils.isBlank(userName)){
            return new EasyUIDataGridResult();
        }
        List<CalculateResult> calculateResultByUserName = calculateResultService.getCalculateResultByUserName(userName);
        EasyUIDataGridResult result = new EasyUIDataGridResult();
        result.setTotal(calculateResultByUserName.size());
        result.setRows(calculateResultByUserName);
        return result;
    }

    @RequestMapping(value = "/resultById")
    @ResponseBody
    public StandardJsonObject getCalculateResulteById(HttpServletResponse response, Long id) throws IOException {


        return StandardJsonObject.newCorrectJsonObject();
    }

    @RequestMapping(value = "/resultPic")
    @ResponseBody
    public StandardJsonObject getResultePic(HttpServletResponse response, String path) throws IOException {

        List<String> resultPicList = Lists.newArrayList();
        resultPicList.add(path + "/smises1.png");
        resultPicList.add(path + "/eprincipal1.png");
        resultPicList.add(path + "/uall1.png");
        resultPicList.add(path + "/smises2.png");
        resultPicList.add(path + "/eprincipal2.png");
        resultPicList.add(path + "/uall2.png");
        Cookie cookie = new Cookie("resultPicList",resultPicList.toString());
        response.addCookie(cookie);
        response.sendRedirect("/srm/views/result.jsp");
        return StandardJsonObject.newCorrectJsonObject();
    }

}
