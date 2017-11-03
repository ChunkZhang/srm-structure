package com.nwpu.bishe.common.enumeration;

import com.nwpu.bishe.common.database.jpa.convert.ValEnum;

/**
 * Created by chunk on 2017/10/31.
 */
public enum LoginStatus implements ValEnum<Integer> {

    SUCCESSED(0,"登录成功"),

    NO_USER(1,"用户不存在"),

    PASSWORD_WRONG(2,"密码错误"),

    EXIT(-1,"退出登录");


    LoginStatus(Integer value,String result){
        this.value = value;
    }

    private final int value;

    @Override
    public Integer value() {
        return value;
    }

}
