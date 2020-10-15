package com.sample.security;

import com.sample.security.common.utils.HttpResult;
import com.sample.security.common.utils.JwtTokenUtil;
import com.sample.security.entity.SysUser;
import com.sample.security.security.JwtAuthenticationToken;
import com.sample.security.security.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@SpringBootApplication
@RestController
public class SampleSpringBootSecurityApplication {

    @Autowired
    @Qualifier("jwtUserDetailsService")
    private UserDetailsService userDetailsService;
    @Autowired
    private LoginService loginService;

    public static void main(String[] args) {
        SpringApplication.run(SampleSpringBootSecurityApplication.class, args);
    }

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @PostMapping("/login")
    public HttpResult login(@RequestBody SysUser sysUser, HttpServletRequest request){
//        final UserDetails userDetails = userDetailsService.loadUserByUsername(sysUser.getUsername());
//        final String token = jwtTokenUtil.generateToken(userDetails);
        JwtAuthenticationToken token = loginService.login(sysUser.getUsername(), sysUser.getPassword(), request);
        return HttpResult.ok(token);
    }

    @GetMapping("test")
    public String test(){
        UserDetails userDetails = (UserDetails) org.springframework.security.core.context.SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return "test:"+userDetails.getUsername()+","+userDetails.getPassword();
    }
}
