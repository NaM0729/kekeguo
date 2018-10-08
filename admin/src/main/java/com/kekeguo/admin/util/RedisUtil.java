package com.kekeguo.admin.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

/**
 * @author zhangyuna
 * @date 2018年10月08日16:01:08
 */
@Component
public abstract class RedisUtil {

    @Autowired
    private static StringRedisTemplate redisTemplate;

    public static void saveStirng (String key,String info){
        ValueOperations<String, String> value = redisTemplate.opsForValue();
        value.append(key,info);
    }

}
