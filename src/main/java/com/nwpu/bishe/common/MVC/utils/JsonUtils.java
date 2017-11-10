package com.nwpu.bishe.common.MVC.utils;

/**
 * Created by chunk on 2017/11/10.
 */


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class JsonUtils {
    private static final Logger logger = LoggerFactory.getLogger(JsonUtils.class);
    private static final ObjectMapper mapper = new ObjectMapper();

    public JsonUtils() {
    }

    public static <T> T unmarshalFromString(String json, Class<T> targetClass) {
        if(!StringUtils.isBlank(json) && targetClass != null) {
            try {
                return mapper.readValue(json, targetClass);
            } catch (Exception var3) {
                logger.error(String.format("unmarshalFromString error %s, %s", new Object[]{json, targetClass.toString()}), var3);
                return null;
            }
        } else {
            return null;
        }
    }

    public static <T> T unmarshalFromString(String json, TypeReference<T> type) {
        if(!StringUtils.isBlank(json) && type != null) {
            try {
                return mapper.readValue(json, type);
            } catch (Exception var3) {
                logger.error(String.format("unmarshalFromString error %s, %s", new Object[]{json, type.getType()}), var3);
                return null;
            }
        } else {
            return null;
        }
    }

    public static <T> List<T> unmarshalFromString2List(String json, Class<T> targetClass) {
        if(!StringUtils.isBlank(json) && targetClass != null) {
            try {
                return (List)mapper.readValue(json, mapper.getTypeFactory().constructCollectionType(List.class, targetClass));
            } catch (Exception var3) {
                logger.error(String.format("unmarshalFromString2List error %s, %s", new Object[]{json, targetClass.toString()}), var3);
                return null;
            }
        } else {
            return null;
        }
    }

    public static String marshalToString(Object obj) {
        if(obj == null) {
            return null;
        } else {
            try {
                return mapper.writeValueAsString(obj);
            } catch (Exception var2) {
                logger.error(String.format("marshalToString error object: %s ", new Object[]{obj}), var2);
                return null;
            }
        }
    }

    public static String marshalToStringPretty(Object obj) {
        if(obj == null) {
            return null;
        } else {
            try {
                return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
            } catch (Exception var2) {
                logger.error(String.format("marshalToStringPretty error object: %s ", new Object[]{obj}), var2);
                return null;
            }
        }
    }

    public static JsonNode toJsonNode(String Json) {
        if(StringUtils.isBlank(Json)) {
            return null;
        } else {
            try {
                JsonNode arrNode = (new ObjectMapper()).readTree(Json);
                return arrNode;
            } catch (Exception var2) {
                logger.error(String.format("toJsonNode error Json: %s ", new Object[]{Json}), var2);
                return null;
            }
        }
    }

    static {
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }
}
