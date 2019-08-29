package com.constant;

import java.util.HashMap;
import java.util.Map;

public final class AppCode {
    public static Map<String,String> codeMap = new HashMap<>(); //需要处理操作的code

    /**
     * 基本接口返回
     */
    public static final String SUCCESS = "00000000"; //基本接口请求成
    public static final String ERROR = "00000001"; //基本接口请求失败

    static {
        //接口返回（原编码返回无需转换）
        codeMap.put(SUCCESS,"请求成功");
        codeMap.put(ERROR,"请求失败");
    }
}
