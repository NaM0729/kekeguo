package com.sunlands.examplan.api;

import com.sunlands.examplan.redis.RedisUtils;
import com.sunlands.examplan.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * 获取token
 * @author_zhouyu
 * @email_zhouyu01@sunlands.com
 * @date_2018年11月07日21:44:44
 */
@RestController
@RequestMapping("auth")
public class TokenApi {
    
    @Autowired
    private RedisUtils redisUtils;
    
    @RequestMapping("token")
    public String getToken() throws Exception {
        String userIdentity = UUID.randomUUID().toString().replaceAll("-", "");
        String token = MD5Utils.md5(userIdentity);
        redisUtils.set(userIdentity, token,RedisUtils.MINUTE_30_EXPIRE);
        return userIdentity;
    }


    
}
