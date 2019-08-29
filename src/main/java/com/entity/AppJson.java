package com.entity;

/**
 * 请求后返回数据
 */

public class AppJson {
    private String success = "00000000"; //是否成功
    private String msg = "操作成功"; // 提示信息
    private Object obj = null; //其他信息

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }
}
