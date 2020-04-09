package com.iot.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.sun.corba.se.impl.oa.toa.TOA;

import java.io.UnsupportedEncodingException;
import java.util.Date;

/**
 * @author: weiyunyun
 * @date: 2020/4/8 16:48
 */
public class JWTUtil {

    private static final long EXPIRE_TIME = 60*24*60*1000L;

    /**
     * 生成token
     * @param username
     * @return
     */
    public static String createToken(String username,String secret){
        Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
        Algorithm algorithm = Algorithm.HMAC256(secret);
        return JWT.create().withClaim("username",username)
                           .withExpiresAt(date)
                           .sign(algorithm);

    }

    public static boolean verify(String token,String username,String secret){
       try {
           Algorithm algorithm = Algorithm.HMAC256(secret);
           JWTVerifier verifier = JWT.require(algorithm).withClaim("username",username).build();
           verifier.verify(token);
           return true;
       } catch (Exception e){
           return false;
       }
    }

    public static String getUsername(String token){
        DecodedJWT jwt = JWT.decode(token);
        return jwt.getClaim("username").asString();
    }

}
