package com.sample.security.security;

import com.sample.security.common.exception.CustomException;
import com.sample.security.common.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * @author gaoy
 * @since 2020/10/14
 */
@Service
public class LoginService {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    public JwtAuthenticationToken login(String username, String password, HttpServletRequest request) {
        JwtAuthenticationToken token = null;
        try {
            token = new JwtAuthenticationToken(username, password);
            token.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            // 执行登录认证过程
            Authentication authentication = authenticationManager.authenticate(token);
            // 认证成功存储认证信息到上下文
            SecurityContextHolder.getContext().setAuthentication(authentication);
            // 生成令牌并返回给客户端
            token.setToken(jwtTokenUtil.generateToken(authentication));
        } catch (AuthenticationException e) {
            throw new CustomException("用户名或密码错误", HttpStatus.UNPROCESSABLE_ENTITY);
        }
        return token;
    }

}
