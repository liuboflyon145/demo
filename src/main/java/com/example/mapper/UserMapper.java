package com.example.mapper;

import com.example.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by liubo16 on 2017/2/8.
 */
public interface UserMapper {
    @Select("select * from users where phone = #{phone}")
    User getByPhone(@Param("phone") String phone);

    @Insert("insert into users set user_name=#{userName},phone=#{phone},email=#{email},sex=#{sex},password=#{password},create_time=now(6),status=1 ")
    int saveUser(User user);
}
