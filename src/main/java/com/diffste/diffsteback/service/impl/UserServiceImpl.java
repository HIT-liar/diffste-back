package com.diffste.diffsteback.service.impl;

import com.diffste.diffsteback.data.User;
import com.diffste.diffsteback.mapper.UserMapper;
import com.diffste.diffsteback.service.UserService;
import com.diffste.diffsteback.utils.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByAccount(String account) {
        User u = userMapper.findByAccount(account);
        return u;
    }

    @Override
    public void register(String account, String password) {
        // 加密密码
        String md5String = Md5Util.getMD5String(password);
        // 添加
        userMapper.add(account, md5String);
    }
}
