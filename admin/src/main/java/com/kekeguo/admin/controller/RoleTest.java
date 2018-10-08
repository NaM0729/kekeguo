package com.kekeguo.admin.controller;

import com.kekeguo.admin.shiro.UserRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

/**
 * @author zhangyuna
 * @date 2018年10月08日10:06:35
 */

public class RoleTest {

    @Test
    public void roletest() {
        UserRealm userRealm = new UserRealm();

        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(userRealm);

        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");
        subject.login(token);
        System.out.println(subject.isAuthenticated());
        subject.checkRole("admin");
        subject.checkPermission("user:update");
    }

}
