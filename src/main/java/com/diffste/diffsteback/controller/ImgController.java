package com.diffste.diffsteback.controller;

import com.diffste.diffsteback.data.Result;
import com.diffste.diffsteback.utils.JwtUtil;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/img")
public class ImgController {
    @GetMapping("/imglist")
    public Result<String> imgList(/*@RequestHeader(name = "Authorization") String token, HttpServletResponse response*/) {
        // 验证token
//        try {
//            Map<String, Object> claims = JwtUtil.parseToken(token);
//            return Result.success("all imgs");
//        } catch (Exception e) {
//            response.setStatus(401);
//            return Result.error("未登录");
//        }
        return Result.success("all imgs");
    }
}
