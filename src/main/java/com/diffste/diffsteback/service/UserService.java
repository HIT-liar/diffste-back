package com.diffste.diffsteback.service;

import com.diffste.diffsteback.data.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    // 根据用户名查询用户
    User findByAccount(String account);

    // 注册
    void register(String account, String password);
}
