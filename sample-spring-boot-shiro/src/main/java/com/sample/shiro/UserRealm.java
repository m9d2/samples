package com.sample.shiro;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sample.shiro.infrastructure.domain.model.Permission;
import com.sample.shiro.infrastructure.domain.model.Role;
import com.sample.shiro.infrastructure.domain.model.User;
import com.sample.shiro.infrastructure.domain.repository.PermissionRepository;
import com.sample.shiro.infrastructure.domain.repository.RoleRepository;
import com.sample.shiro.infrastructure.domain.repository.UserRepository;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * 认证及授权
 */
@Component
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PermissionRepository permissionRepository;

    /**
     * 授权(验证权限时调用)
     * 为当前登陆成功的用户授予权限和角色，已经登陆成功了
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String userName = (String) SecurityUtils.getSubject().getPrincipal();
        User user = userRepository.getOne(new QueryWrapper<User>().eq("username", userName));
        Role role = roleRepository.getOne(new QueryWrapper<Role>().eq("id", user.getRoleId()));
        Permission permission = permissionRepository.getOne(new QueryWrapper<Permission>().eq("role_id", user.getRoleId()));
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
        Set<String> roles = new HashSet<>();
        roles.add(role.getRolename());
        info.setRoles(roles);
        if (!ObjectUtils.isEmpty(permission)) {
            Set<String> permissions = new HashSet<>();
            permissions.add(permission.getPermissionName());
            info.setStringPermissions(permissions);
        }
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
            throw new AuthenticationException("用户名错误");
        }
        String p = String.valueOf(new Md5Hash(password, user.getSalt(), 1024));
        if (!user.getPassword().equals(p)) {
            throw new AuthenticationException("密码错误");
        }
        return new SimpleAuthenticationInfo(userName, password, getName());
    }

    public static void main(String[] args) {
        Object password = "123456"; //密码原值
        String salt = UUID.randomUUID().toString().replace("-", ""); //盐值
        System.out.println(salt);
        Object result = new Md5Hash(password, salt, 1024);
        System.out.println(result);
    }
}
