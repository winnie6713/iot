package com.iot.controller;

import com.iot.common.Result;
import com.iot.common.ResultCode;
import com.iot.entity.User;
import com.iot.service.UserService;
import com.iot.vo.LoginInfoVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author: weiyunyun
 * @date: 2020/4/3 17:16
 */
@RestController
@RequestMapping("user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("register")
    public Result UserRegister(@RequestBody @Validated User user, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            for(ObjectError error:bindingResult.getAllErrors()){
                return Result.failure(ResultCode.INVALID_PARAMS,error.getDefaultMessage());
            }
        }
        return userService.register(user);

    }

    @PostMapping("login")
    public Result login(@RequestBody @Validated LoginInfoVO loginInfoVO, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            for(ObjectError error:bindingResult.getAllErrors()){
                return Result.failure(ResultCode.INVALID_PARAMS,error.getDefaultMessage());
            }
        }
        return Result.success(userService.login(loginInfoVO));
    }


    @GetMapping("logout")
    public Result logout(){
        SecurityUtils.getSubject().logout();
        return Result.success();
    }
}
