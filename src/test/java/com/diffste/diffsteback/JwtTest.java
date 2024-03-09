package com.diffste.diffsteback;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtTest {
    @Test
    public void testGen() {
        Map<String,Object> claims = new HashMap<>();
        claims.put("id", 1);
        claims.put("account", "18804636651");
        String token = JWT.create()
                .withClaim("user",claims)// 添加载荷
                .withExpiresAt(new Date(System.currentTimeMillis()*1000*60*60*12))//添加过期时间
                .sign(Algorithm.HMAC256("zhscodenotpainful"));

        System.out.println(token);

    }

    @Test
    public void testParse() {
        //
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyIjp7ImlkIjoxLCJhY2NvdW50IjoiMTg4MDQ2MzY2NTEifSwiZXhwIjo4MzQzNjk0OTUwNTc5M30.M0MQAnIMMa_GnGrdhVo0oz8jJiR2tnwsGWHWk9LPmVw";
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("zhscodenotpainful")).build();
        DecodedJWT decodedJWT = jwtVerifier.verify(token); // 验证token生成解析后jwt对象
        Map<String, Claim> claims = decodedJWT.getClaims();
        System.out.println(claims.get("user"));
    }
}
