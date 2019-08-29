package com.constant;

import java.util.HashMap;
import java.util.Map;

public final class ServiceCode {

    public static Map<String,String> failMap = new HashMap();//需转换失败编码
    public static Map<String,String> successMap = new HashMap();//需转换成功编码

    /**
     * 基本接口返回
     */
    public static final String SUCCESS = AppCode.SUCCESS; //基本接口请求成功
    public static final String ERROR = AppCode.ERROR; //基本接口请求失败

    /******************************************************************************************
     * success Code
     */
    public static final String success_contact = "success_000001";

    static {
        //请求成功消息
        successMap.put(success_contact,"提交成功");
    }





    /*******************************************************************************************
     * final Code
     */

    public static final String fail_param_error = "fail_000000";

    static {
        //处理失败消息
        failMap.put(fail_param_error, "请求参数错误");
    }
}
