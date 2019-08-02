package com.sample.shiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {

    /**
     * 登陆
     * @param username
     * @param password
     * @param rememberMe
     * @return
     * @throws AuthenticationException
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> login(@RequestParam("username") String username,
                                     @RequestParam("password") String password,
                                     @RequestParam("rememberMe") boolean rememberMe) throws AuthenticationException {
        Map<String, Object> map = new HashMap<>();
        try {
            Subject currentUser = SecurityUtils.getSubject();
            //当前用户是否已登录
            if (!currentUser.isAuthenticated()) {
                UsernamePasswordToken token = new UsernamePasswordToken(username, password, rememberMe);
                token.setRememberMe(rememberMe);
                currentUser.login(token);
                map.put("code", 200);
                map.put("message", "login success");
            }
        } catch (AuthenticationException e) {
            throw new AuthenticationException("用户名或密码错误", e.getCause());
        }
        return map;
    }

    /**
     * 自定义登出 不使用shiro自带登出
     * @return
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        Map<String, Object> map = new HashMap<>();
        map.put("code", 200);
        map.put("message", "logout success");
        return map;
    }

}
