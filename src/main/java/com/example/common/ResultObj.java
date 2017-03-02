package com.example.common;

/**
 * Created by liubo on 2017/3/1.
 */
public class ResultObj {
    Object obj;

    public ResultObj(Object obj, String msg, int code) {
        this.obj = obj;
        this.msg = msg;
        this.code = code;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    String msg;
    int code;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
