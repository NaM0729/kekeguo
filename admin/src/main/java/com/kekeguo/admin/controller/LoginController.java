package com.kekeguo.admin.controller;

import com.kekeguo.admin.util.DataResult;
import com.kekeguo.admin.util.ShiroUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@ResponseBody
public class LoginController {

    @GetMapping("/login")
    public DataResult Login(@RequestParam("username") String username,@RequestParam("password") String password) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);
        }catch(UnknownAccountException ex) {
            return DataResult.success("账号已锁定");
        }catch(IncorrectCredentialsException ex) {
            return DataResult.success("密码错误");
        }
        return DataResult.success(token.toString());
    }

    @RequestMapping("logout")
    public DataResult logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return DataResult.success("退出成功");
    }

    @RequestMapping("update")
    @RequiresPermissions("user:update")
    public DataResult updateUser(){

        return DataResult.success("admin");
    }

    @RequestMapping("delete")
    @RequiresPermissions("user:delete")
//    @RequiresRoles("admin")
    public DataResult deleteUser(){

        return DataResult.success("delete");
    }

}
