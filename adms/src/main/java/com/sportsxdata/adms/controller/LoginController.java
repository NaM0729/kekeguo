package com.sportsxdata.adms.controller;

import com.sportsxdata.adms.model.DataResult;
import com.sportsxdata.adms.model.SystemUser;
import com.sportsxdata.adms.service.LoginService;
import com.sportsxdata.adms.utils.JWTUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public DataResult login(@RequestParam("username") String username,
                            @RequestParam("password") String password) {
        return loginService.login(username,password);

    }
}
