package com.example.consumer;

import com.alibaba.dubbo.config.annotation.Reference;
import com.example.common.ResultObj;
import org.springframework.stereotype.Component;
import com.example.provider.ILoginService;
/**
 * Created by liubo on 2017/3/2.
 */

public class UserService {
    @Reference(version = "1.0.0")
    ILoginService iLoginService;


    public ResultObj login(String phone, String password){
        return iLoginService.login(phone,password);
    }
}
