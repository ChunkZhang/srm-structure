package com.nwpu.bishe.common.MVC.response;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.nwpu.bishe.common.MVC.utils.JsonUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;
import java.util.*;

@JsonSerialize(
        include = JsonSerialize.Inclusion.NON_NULL
)
public class StandardJsonObject implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Boolean CORRECT_RET;
    private static final Boolean ERR_RET;
    private static final int DEFAULT_ERR_CODE = 0;
    private Object data;
    private Integer errcode;
    private String errmsg;
    private Boolean ret;

    public StandardJsonObject() {
    }

    public static StandardJsonObject newCorrectJsonObject() {
        StandardJsonObject correctJsonObject = new StandardJsonObject();
        correctJsonObject.setRet(CORRECT_RET);
        return correctJsonObject;
    }

    public static StandardJsonObject newCorrectJsonObject(Object object) {
        StandardJsonObject correctJsonObject = newCorrectJsonObject();
        correctJsonObject.setData(object);
        return correctJsonObject;
    }

    public static StandardJsonObject newErrorJsonObject(Integer code, String msg) {
        StandardJsonObject errorReturnObject = new StandardJsonObject();
        errorReturnObject.setRet(ERR_RET);
        errorReturnObject.setErrcode(code);
        errorReturnObject.setErrmsg(msg);
        return errorReturnObject;
    }

    public static StandardJsonObject newErrorJsonObject(String msg) {
        return newErrorJsonObject(Integer.valueOf(0), msg);
    }

    public StandardJsonObject putEntry(String key, Object value) {
        if(StringUtils.isBlank(key)) {
            return this;
        } else {
            if(this.data == null) {
                this.data = new HashMap();
            }

            boolean isMapStructure = this.data instanceof Map;
            if(!isMapStructure) {
                throw new RuntimeException("Can't put k-v into not-map data");
            } else {
                ((Map)this.data).put(key, value);
                return this;
            }
        }
    }

    public <T> T getData(Class<T> clazz) {
        return clazz != null && this.data != null?JsonUtils.unmarshalFromString(JsonUtils.marshalToString(this.data), clazz):null;
    }

    public <T> List<T> getListData(Class<T> clazz) {
        if(clazz != null && this.data != null) {
            List<T> list = new ArrayList();
            return (List)(this.data instanceof List?JsonUtils.unmarshalFromString2List(JsonUtils.marshalToString(this.data), clazz):list);
        } else {
            return Collections.emptyList();
        }
    }

    public Object getData() {
        return this.data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Integer getErrcode() {
        return this.errcode;
    }

    public void setErrcode(Integer errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return this.errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public Boolean getRet() {
        return this.ret;
    }

    public void setRet(Boolean ret) {
        this.ret = ret;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

    static {
        CORRECT_RET = Boolean.TRUE;
        ERR_RET = Boolean.FALSE;
    }
}
