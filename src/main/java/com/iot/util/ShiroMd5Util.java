package com.iot.util;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * @author: weiyunyun
 * @date: 2020/4/7 17:32
 */
public class ShiroMd5Util {

    private static  final String hashAlgorithmName = "MD5";

    public static String  encodeMd5(String username,String password) {


        ByteSource salt = ByteSource.Util.bytes(username);//以账号作为盐值

        int hashIterations = 1024;//加密2次

        SimpleHash hash = new SimpleHash(hashAlgorithmName,password,salt,hashIterations);

        return hash.toString();
    }
}
