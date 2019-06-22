package com.sample.shiro;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sample.shiro.common.exception.ServiceException;
import com.sample.shiro.infrastructure.domain.model.User;
import com.sample.shiro.infrastructure.domain.repository.UserRepository;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

@Component
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserRepository userRepository;

    /**
     * 授权(验证权限时调用)
     * 为当前登陆成功的用户授予权限和角色，已经登陆成功了
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
        return info;
    }

    /**
     * 认证(登录时调用)
     * 验证当前登录的用户，获取认证信息
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String userName = token.getPrincipal().toString();
        String password = new String((char[]) token.getCredentials());
        User user = userRepository.getOne(new QueryWrapper<User>().eq("username", userName));
        if (ObjectUtils.isEmpty(user)) {
            throw new ServiceException("用户名错误");
        }
        if (!user.getPassword().equals(password)) {
            throw new ServiceException("密码错误");
        }
        return new SimpleAuthenticationInfo(userName, password, getName());
    }

}
