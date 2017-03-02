package com.example.common;

/**
 * Created by liubo on 2017/3/1.
 */
public class ResultFactory {
    public static ResultObj getResultObj(Object obj,MessageEnum message){
        return new ResultObj(obj,message.getValue(),message.getKey());
    }
}
