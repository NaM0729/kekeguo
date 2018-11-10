package com.sunlands.study.examplan.gateway.filter;

import com.sunlands.study.examplan.gateway.xss.XssHttpServletRequestWrapper;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * XSS过滤
 * @author_zhouyu
 * @email_zhouyu01@sunlands.com
 * @date_2018年11月07日14:18:04
 */
@Component
public class XssSecurityFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        XssHttpServletRequestWrapper xssRequest = new XssHttpServletRequestWrapper(httpServletRequest);
        filterChain.doFilter(xssRequest, httpServletResponse);
    }
}
