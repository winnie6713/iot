package com.iot.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.iot.common.Result;
import com.iot.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.iot.vo.LoginInfoVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author weiyunyun
 * @since 2020-04-07
 */
public interface UserService extends IService<User> {

    Result login(LoginInfoVO loginInfoVO);

    Result register(User user);

    default User selectUserByUsername(String username){
        return this.getOne(new QueryWrapper<User>().eq("username", username));
    }

}
