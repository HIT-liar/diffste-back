package com.diffste.diffsteback.controller;

import com.diffste.diffsteback.data.Result;
import com.diffste.diffsteback.data.User;
import com.diffste.diffsteback.service.UserService;
import com.diffste.diffsteback.utils.JwtUtil;
import com.diffste.diffsteback.utils.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Result register(String account, String password) {

        // 查询用户
        User u = userService.findByAccount(account);
        if (u == null) {
            userService.register(account, password);
            return Result.success();
        } else {
            System.out.println("ssssss");
            return Result.error("用户已注册过！");
        }
    }

    @PostMapping("/login")
    public Result<String> login(String account, String password){
        // 根据用户名查询用户
        User loginUser = userService.findByAccount(account);
        // 判断用户是否存在
        if (loginUser == null) {
            return Result.error("用户不存在！");
        }
        // 判断密码是否正确
        if (Md5Util.getMD5String(password).equals(loginUser.getPassword())) {
            Map<String, Object> claims = new HashMap<>();
            claims.put("id",loginUser.getId());
            claims.put("account",loginUser.getAccount());
            String token = JwtUtil.genToken(claims);
            return Result.success(token);
        }

        return Result.error("密码错误！");
    }
}
