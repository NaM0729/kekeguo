package com.sportsxdata.adms.shiro;

import com.sportsxdata.adms.model.DataResult;
import com.sportsxdata.adms.utils.JWTUtil;
import com.sportsxdata.adms.utils.RenderUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 对客户端请求的jwt token验证过滤器
 *
 * @author fengshuonan
 * @Date 2017/8/24 14:04
 */
@Slf4j
public class AuthFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("---> jwt 时间校验");
        String servletPath = request.getServletPath();
        log.info("servletpath:{}",servletPath);
        if(servletPath.contains("login")){
            chain.doFilter(request,response);
            return;
        }
        String authorization = request.getHeader("Authorization");
        if(authorization!=null){
            if(JWTUtil.expTime(authorization)){
                chain.doFilter(request, response);
            }else{
                log.info("已超时:{}",authorization);
                RenderUtil.renderJson(response,DataResult.fail("token time out"));
            }
        }
    }
}