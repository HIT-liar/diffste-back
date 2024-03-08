package com.diffste.diffsteback.controller;

import com.diffste.diffsteback.data.Result;
import com.diffste.diffsteback.data.User;
import com.diffste.diffsteback.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Result register(String account, String password) {
        System.out.println(account + password);
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
}
