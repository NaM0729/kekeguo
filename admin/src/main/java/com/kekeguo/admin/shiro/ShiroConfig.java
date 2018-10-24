package com.kekeguo.admin.shiro;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author zhangyuna
 * @date 2018年09月30日09:47:35
 */

@Configuration
public class ShiroConfig {

    /**
     * ShiroFilterFactoryBean 处理拦截资源文件问题。
     * Filter Chain定义说明 1、一个URL可以配置多个Filter，使用逗号分隔 2、当设置多个过滤器时，全部验证通过，才视为通过
     * 3、部分过滤器可指定参数，如perms，roles
     */
    @Bean("shiroFilter")
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
        // 必须设置 SecurityManager
        shiroFilter.setSecurityManager(securityManager);

        // 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
        shiroFilter.setLoginUrl("/login.html");
        // 登录成功后要跳转的链接
        shiroFilter.setSuccessUrl("/static/template/index.html");
        // 未授权界面;
        shiroFilter.setUnauthorizedUrl("/static/template/404.html");

        //自定义拦截器
        Map<String, Filter> filtersMap = new LinkedHashMap<String, Filter>();
        //限制同一帐号同时在线的个数。
//        filtersMap.put("kickout", kickoutSessionControlFilter());
        shiroFilter.setFilters(filtersMap);

        // 权限控制map.
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
        // filterChainDefinitionMap.put("/add", "perms[权限添加]");
        // 过滤链定义，从上向下顺序执行，一般将 /**放在最为下边
        // authc:所有url都必须认证通过才可以访问;
        // anon:所有url都都可以匿名访问
//        filterChainDefinitionMap.put("/template/login.html", "anon");
        filterChainDefinitionMap.put("/logout.html", "anon");
//        filterChainDefinitionMap.put("/update", "authc");
//        filterChainDefinitionMap.put("/**", "authc");
        filterChainDefinitionMap.put("/**", "anon");
        shiroFilter.setFilterChainDefinitionMap(filterChainDefinitionMap);

        return shiroFilter;
    }

    @Bean
    public SessionManager sessionManager(ShiroSession shiroSession){
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        //设置session过期时间为1小时(单位：毫秒)，默认为30分钟
        sessionManager.setGlobalSessionTimeout(20 * 1000);
        sessionManager.setSessionValidationSchedulerEnabled(true);
        sessionManager.setSessionDAO(shiroSession);
        sessionManager.setSessionIdUrlRewritingEnabled(false);
        return  sessionManager;
    }

    @Bean
    public SecurityManager securityManager(UserRealm userRealm,SessionManager sessionManager) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 设置realm.
        securityManager.setRealm(userRealm);
        // 自定义缓存实现 使用redis
        //securityManager.setCacheManager(cacheManager());
        // 自定义session管理 使用redis
        securityManager.setSessionManager(sessionManager);
        return securityManager;
    }

    //开启shiro aop注解支持
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;
    }

}
