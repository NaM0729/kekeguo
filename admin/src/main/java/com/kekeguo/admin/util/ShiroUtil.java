package com.kekeguo.admin.util;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.stereotype.Component;

/**
 * @author zhangyuna
 * @date 2018年10月08日14:31:41
 */
@Component
public class ShiroUtil {

    public static Subject subject;
    static{
        SecurityUtils.setSecurityManager(new DefaultWebSecurityManager());
        subject = SecurityUtils.getSubject();
    }
    public static void login(UsernamePasswordToken token){
        subject.login(token);
    }

    public static void logout(){
        subject.logout();
    }
}
