package com.iot.shiro;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * @author weiyunyun
 * @date 2020.4.9
 */
public class CustomizedToken extends UsernamePasswordToken {


    public CustomizedToken(final String username, final String password){
        super(username, password);
    }
    @Override
    public String toString(){
        return "username=" + super.getUsername()+",password="+ String.valueOf(super.getPassword());
    }


}
