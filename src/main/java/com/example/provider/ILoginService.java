package com.example.provider;

import com.example.common.ResultObj;
import com.example.domain.User;

/**
 * Created by liubo on 2017/3/1.
 */
public interface ILoginService {
    public ResultObj login(String phone, String password);
}
