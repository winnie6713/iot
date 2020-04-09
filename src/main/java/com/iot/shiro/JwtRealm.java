package com.iot.shiro;

import com.iot.common.ResultCode;
import com.iot.entity.User;
import com.iot.service.UserService;
import com.iot.util.JWTUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;

/**
 * @author lixiao
 * @date 2019/8/6 10:02
 */
@Slf4j
public class JwtRealm extends AuthorizingRealm {

    @Resource
    private UserService userService;


    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    /**
     * 只有当需要检测用户权限的时候才会调用此方法，例如checkRole,checkPermission之类的
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
       return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken auth) throws AuthenticationException {
        String token = (String) auth.getCredentials();
        // 解密获得token
        String username = JWTUtil.getUsername(token);
        User user = userService.selectUserByUsername(username);
        if (user == null || !JWTUtil.verify(token, username,user.getPassword())) {
            throw new IncorrectCredentialsException(ResultCode.TOKEN_INVALID.getMsg());
        }
        return new SimpleAuthenticationInfo(token, token, "JwtRealm");
    }
}
