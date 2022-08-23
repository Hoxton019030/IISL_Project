package com.example.iisl_project.util;

import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;

@Component
public class JwtToken implements Serializable {

    private static final long EXPIRATION_TIME = 1 * 60 * 1000;

    public static final String SECRET = "1337";

    /**
     *產生JwtToken
     * @param userDetails 使用者登入資訊 帳號密碼之類的吧
     * @return JwToken 的加密字串
     */
    public String generateToken(HashMap<String,String> userDetails){
        HashMap<String, Object> claims = new HashMap<>();
        claims.put("userName",userDetails.get("userName"));
        return Jwts.builder().setClaims(claims).setExpiration(new Date(Instant.now().toEpochMilli()+EXPIRATION_TIME)).signWith(SignatureAlgorithm.HS512,SECRET).compact();
    }

    /**
     * 經由generateToken所產生的金鑰
     * @param token JwToken的加密字串
     */
    public void validateToken(String token){
        Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token);
    }
}
