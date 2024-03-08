package com.diffste.diffsteback.mapper;

import com.diffste.diffsteback.data.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    // 根据用户名 查询用户
    @Select("select * from user where account=#{account}")
    User findByAccount(String account);

    // 添加
    @Insert("insert into user(account, password) values (#{account}, #{password})")
    void add(String account, String password);
}
