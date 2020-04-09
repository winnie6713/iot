package com.iot.vo;

import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author: weiyunyun
 * @date: 2020/4/7 9:04
 */
@Data
public class LoginInfoVO {

    @NotEmpty(message = "username can not be empty")
    private String username;

    @NotEmpty(message = "password can not be empty")
    private String password;

}
