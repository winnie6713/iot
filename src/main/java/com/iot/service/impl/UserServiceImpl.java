package com.iot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.iot.common.Result;
import com.iot.common.ResultCode;
import com.iot.entity.User;
import com.iot.mapper.UserMapper;
import com.iot.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iot.shiro.CustomizedToken;
import com.iot.util.JWTUtil;
import com.iot.util.ParamaterJudgeUtil;
import com.iot.util.ShiroMd5Util;
import com.iot.vo.LoginInfoVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author weiyunyun
 * @since 2020-04-07
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {


    @Override
    public Result login(LoginInfoVO loginInfoVO) {
        // 1.获取Subject
        Subject subject = SecurityUtils.getSubject();
        // 2.封装用户数据
        String username = loginInfoVO.getUsername();
        String password = loginInfoVO.getPassword();
//        String encodePassword = ShiroMd5Util.encodeMd5(username,password);
        CustomizedToken token = new CustomizedToken(username, password);
        // 3.执行登录方法
        try{
            subject.login(token);
            Map<String, Object> data = returnLoginInitParam(loginInfoVO.getUsername());
            return Result.success(data);
        }catch (UnknownAccountException e) {
            return Result.failure(ResultCode.NO_SUCH_USER);
        } catch (IncorrectCredentialsException e){
            return Result.failure(ResultCode.INVALID_PASSWORD);
        }
    }

    @Override
    public Result register(User user) {
        User userInfo = getOne(new QueryWrapper<User>().eq("username",user.getUsername()));
        if(!ObjectUtils.isEmpty(userInfo)){
            return Result.failure(ResultCode.USER_EXISTS);
        }
        String hashPassword = ShiroMd5Util.encodeMd5(user.getUsername(),user.getPassword());
        user.setPassword(hashPassword);
        save(user);
        return Result.success();
    }

    /**
     * 返回登录后初始化参数
     * @param username
     * @return Map<String, Object>
     */
    private Map<String, Object> returnLoginInitParam(String username) {
        Map<String, Object> data = new HashMap<>(1);
        User user = selectUserByUsername(username);
        // 生成jwtToken
        String jwtToken = JWTUtil.createToken(username, user.getPassword());
        // token
        data.put("token", jwtToken);
        return data;
    }
}
