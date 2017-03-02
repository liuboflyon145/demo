package com.example.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.example.common.MessageEnum;
import com.example.common.ResultFactory;
import com.example.common.ResultObj;
import com.example.domain.User;
import com.example.provider.ILoginService;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by liubo on 2017/3/1.
 */
@Service(version = "1.0.0")
public class LoginServiceImpl implements ILoginService {

    @Autowired
    UserService userService;
    @Override
    public ResultObj login(String phone, String password) {
        User user = userService.getUser(phone);
        if (user==null)
            return ResultFactory.getResultObj(null,MessageEnum.USERNOTFOUND);
        if (password.length()>0&&password.equals(user.getPassword())){
            return ResultFactory.getResultObj(user, MessageEnum.SUCCESS);
        }
        return ResultFactory.getResultObj(user,MessageEnum.PASSWORDERROR);
    }
}
