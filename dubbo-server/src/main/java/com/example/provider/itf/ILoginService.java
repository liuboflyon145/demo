package com.example.provider.itf;

import com.example.common.ResultObj;

/**
 * Created by liubo on 2017/3/1.
 */
public interface ILoginService {
    public ResultObj login(String phone, String password);
}
