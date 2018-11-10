package com.sunlands.study.examplan.gateway.filter;

import com.alibaba.fastjson.JSON;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.sunlands.study.examplan.gateway.redis.RedisUtils;
import com.sunlands.study.examplan.gateway.utils.GateWayUtils;
import com.sunlands.study.examplan.gateway.utils.Result;
import com.sunlands.study.examplan.gateway.utils.SignUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 拦截认证Filter
 *
 * @author_zhouyu
 * @email_zhouyu01@sunlands.com
 * @date_2018年11月07日18:58:21
 */
@Component
public class GateWayAuthFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Autowired
    private RedisUtils redisUtils;

    //请求超时时间（s）
    private static final int timeLimit = 30;

    @Value("${gate.ignore.startWith}")
    private String startWith;

    @Value("${appId}")
    private static String appId;


    @Override
    public Object run() throws ZuulException {

        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletResponse response = requestContext.getResponse();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        HttpServletRequest httpServletRequest = requestContext.getRequest();
        String requestURI = httpServletRequest.getRequestURI();

        //不进行拦截的地址
        if (isStartWith(requestURI)) {
            requestContext.setSendZuulResponse(true);
            return true;
        }

        String token = httpServletRequest.getHeader("token");
        String headerUserIdentity = httpServletRequest.getHeader("userIdentity");
        String timestamp = httpServletRequest.getHeader("timestamp");
        String sign = httpServletRequest.getHeader("sign");
        String headerAppId = httpServletRequest.getHeader("appid");

        requestContext.setSendZuulResponse(false);

        //请求头参数非空验证
        if (StringUtils.isEmpty(token) || StringUtils.isEmpty(timestamp) ||  StringUtils.isEmpty(sign) ||  StringUtils.isEmpty(headerAppId)) {
            requestContext.setResponseBody(JSON.toJSONString(new Result("-1", "请求头参数不正确")));
            return false;
        }

        //请求时间和现在时间对比验证，发起请求时间和服务器时间不能超过timeLimit秒
        if (GateWayUtils.timeDiffSeconds(new Date(), timestamp) > timeLimit) {
            requestContext.setResponseBody(JSON.toJSONString(new Result("-1", "请求发起时间超过服务器限制")));
            return false;
        }

        //验证token信息
        String userIdentity = redisUtils.get(token);
        if (userIdentity == null || !headerUserIdentity.equals(userIdentity)) {
            requestContext.setResponseBody(JSON.toJSONString(new Result("-1", "错误的token信息")));
            return false;
        }else {
            //续租token
            redisUtils.get(token,RedisUtils.MINUTE_30_EXPIRE);
        }

        //验证appId信息
        if (!headerAppId.equals(appId)) {
            requestContext.setResponseBody(JSON.toJSONString(new Result("-1", "错误的验证信息")));
            return false;
        }
        //服务器生成签名与header中签名对比
        Map<String,String> paramsMap = new ConcurrentHashMap<String,String>();
        paramsMap.put("token",token);
        paramsMap.put("userIdentity",headerUserIdentity);
        paramsMap.put("timestamp",timestamp);
        paramsMap.put("appId",headerAppId);
        paramsMap.put("sign",sign);
        try {
            String serverSign = SignUtils.generateSign(paramsMap);
            if (!serverSign.equals(sign)) {
                requestContext.setResponseBody(JSON.toJSONString(new Result("-1", "错误的签名信息")));
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        requestContext.setSendZuulResponse(true);
        return true;
    }



    private boolean isStartWith(String requestUri) {
        boolean flag = false;
        String[] split = startWith.split(",");
        for (String s : split) {
            if (requestUri.endsWith(s)) {
                return true;
            }
        }
        return flag;
    }
}
