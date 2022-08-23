package com.example.iisl_project.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.security.Key;
import java.util.Calendar;

/**
 * 參考至https://blog.kennycoder.io/2020/01/21/Spring-Boot-Spring-Security%E7%B5%90%E5%90%88JWT%E7%9A%84%E8%A8%AD%E8%A8%88%E4%BE%86%E9%99%90%E5%88%B6API%E5%AD%98%E5%8F%96/
 */
@Component
@ConfigurationProperties(prefix = "jwt")
public class JwtUtil implements Serializable {

    private  int EXPIRATION_TIME;

    public  String SECRET;


    /**
     * @param userId 使用者帳號
     * @return 返回jwToken
     */
    public String Sign(String userId) {
        Claims claims = Jwts.claims();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, EXPIRATION_TIME);
        claims.setExpiration(calendar.getTime());
        claims.put("userId", userId);
        Key key = Keys.hmacShaKeyFor(SECRET.getBytes());
        return Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS256, key).compact();
    }

    /**
     *
     * @param token JwToken的加密後字串的使用者帳號
     */
    public String Verify(String token) {
        String userId;
        try {
            Key key = Keys.hmacShaKeyFor(SECRET.getBytes());
            Claims claims = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
            userId = claims.get("userId").toString();
        } catch (Exception e) {
            userId = null;
        }
        return userId;
    }}
