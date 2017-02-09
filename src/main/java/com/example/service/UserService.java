package com.example.service;

import com.example.domain.User;
import com.example.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by liubo16 on 2017/2/9.
 */
@Service
public class UserService {
    @Autowired
    UserMapper mapper;

    public User getUser(String phone){
        return mapper.getByPhone(phone);
    }

    public int saveUser(User user) {
        return mapper.saveUser(user);
    }
}
