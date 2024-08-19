package com.group.consult.commerce.utils;

import cn.hutool.core.date.DateUtil;
import com.group.consult.commerce.configuration.Constants;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.function.Function;

/**
 * @title: jwt工具
 * @description: jwt工具
 * @author: zl
 * @date: 2024-08-07
 */
public class JwtUtil {


    private String secretKey;


    public JwtUtil(String secretKey) {
        this.secretKey = secretKey;
    }

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();
    }

    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(DateUtil.offsetHour(new Date(), Constants.TOKEN_EXPIRE_HOURS))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    public Boolean validateToken(String token, String username) {
        final String extractedUsername = extractUsername(token);
        return (extractedUsername.equals(username) && !isTokenExpired(token));
    }
}
