package com.nwpu.bishe.controller;

import com.nwpu.bishe.common.MVC.response.StandardJsonObject;
import com.nwpu.bishe.common.utils.GlobalUtil;
import com.nwpu.bishe.core.jpa.entity.CalculateResult;
import com.nwpu.bishe.core.service.CalculateResultService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public StandardJsonObject getCalculateHistory(){
        String userName = GlobalUtil.getUserName();
        if (StringUtils.isBlank(userName)){
            return StandardJsonObject.newErrorJsonObject("请登录");
        }
        List<CalculateResult> calculateResultByUserName = calculateResultService.getCalculateResultByUserName(userName);
        StandardJsonObject result = StandardJsonObject.newCorrectJsonObject();
        result.putEntry("historyResult",calculateResultByUserName);
        return result;
    }
}
