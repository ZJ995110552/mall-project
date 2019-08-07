package com.mercury.mallproject.common.utils;


import java.util.Date;
import javax.crypto.SecretKey;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class JwtUtil {


    private static final String KEY = "1S2H3A4N5G6H7A8I9S10H11U12I13X14I15N161145FSWW";

    public static String createJWT(String subject) {
        SecretKey key = generalKey();
        Date now = new Date();
        Date thirtyMinutes = new Date(System.currentTimeMillis() + 60 * 60 * 1000 * 24 * 2);  // 失效时间2天

        String jws = Jwts.builder()
                .setSubject(subject) // 主题
                .setIssuedAt(now) // 签发时间
                .setExpiration(thirtyMinutes) // 过期时间
                .signWith(key)
                .compact();
        return jws;
    }

    public static SecretKey generalKey() {
        String stringKey = KEY;// + Constant.JWT_SECRET;
        byte[] encodedKey = org.apache.tomcat.util.codec.binary.Base64.decodeBase64(stringKey);
        SecretKey key = Keys.hmacShaKeyFor(encodedKey);
        return key;
    }

    public static String parseJWT(String jwt) throws JwtException {
        SecretKey key = generalKey();

        try {
            return Jwts.parser()
                    .setSigningKey(key)
                    .parseClaimsJws(jwt)
                    .getBody()
                    .getSubject();
        } catch (JwtException ex) {
            System.out.println("签证失效");
            return null;
        }
    }


    public static void main(String[] args) {

        String createJWT = JwtUtil.createJWT(2368 + "");

        System.out.println(createJWT);

        String parseJWT = JwtUtil.parseJWT("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIyMzYzIiwiaWF0IjoxNTY1MDYxODk4LCJleHAiOjE1NjUyMzQ2OTh9.KIr9uDJkk49iWAxutKFs2hXlX1dMcdoxzd58nu21UIQ");
        String parse1JWT = JwtUtil.parseJWT(createJWT);

        System.out.println(parse1JWT);

    }


}
