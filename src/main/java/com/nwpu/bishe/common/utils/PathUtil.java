package com.nwpu.bishe.common.utils;

/**
 * Created by chunk on 2017/10/16.
 */
public class PathUtil {
    public static String getPath(){
        String path=Thread.currentThread().getContextClassLoader().getResource("").toString();
        path = path.replace('/', '\\'); // 将/换成\
        path = path.replace("file:", ""); //去掉file:
        path = path.substring(1); //去掉第一个\,如 \D:\JavaWeb...
        return path;
    }
}
