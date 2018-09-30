package com.kekeguo.admin.controller;

import com.kekeguo.admin.util.DataResult;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@ResponseBody
public class LoginController {


    @RequestMapping("/loginTest")
    public DataResult Login(@RequestParam("username") String username) {
        return DataResult.success(username);
    }

    @RequestMapping("/login")
    public DataResult Login() {
        UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
        }catch(UnknownAccountException ex) {
            return DataResult.success("账号已锁定");
        }catch(IncorrectCredentialsException ex) {
            return DataResult.success("密码错误");
        }
        return DataResult.success(token.toString());
    }

    @RequestMapping("update")
    public DataResult updateUser(@RequestParam("token") String token){
        Subject subject = SecurityUtils.getSubject();
        boolean admin = subject.hasRole("admin");

        return DataResult.success("admin");
    }

}
