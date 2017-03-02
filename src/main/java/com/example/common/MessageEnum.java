package com.example.common;

/**
 * Created by liubo on 2017/3/1.
 */
public enum MessageEnum {


    USERNOTFOUND("用户不存在",-2),
    PASSWORDERROR("密码错误",-1),
    SUCCESS("success", 0),
    ERROR("error", -1);

    String value;
    int key;

    MessageEnum(String value, int key) {
        this.value = value;
        this.key = key;
    }

    public static String getValue(int key) {
        for (MessageEnum message :
                MessageEnum.values()) {
            if (message.getKey() == key)
                return message.getValue();
        }
        return "";
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }
}
