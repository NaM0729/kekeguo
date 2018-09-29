package com.sportsxdata.adms.config;

import com.sportsxdata.adms.shiro.AuthFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author goulin
 * @Title: ${file_name}
 * @Description: ${todo}
 * @date 2018/6/27上午8:47
 */
@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean myOncePerRequestFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new AuthFilter());
        registration.addUrlPatterns("/admsAthleticsData/*");// 拦截路径
        registration.addUrlPatterns("/attendance/*");// 拦截路径
        registration.addUrlPatterns("/digitalTraining/*");// 拦截路径
        registration.addUrlPatterns("/training/*");// 拦截路径
        registration.addUrlPatterns("/admsProfile/*");// 拦截路径

        registration.setName("authFilter");// 拦截器名称
        registration.setOrder(2);// 顺序
        return registration;
    }
}
