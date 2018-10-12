package com.kekeguo.admin.util;

import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author zhangyuna
 * @date 2018年10月08日16:01:08
 */
@Component
public class RedisUtil {

    @Autowired
    private  StringRedisTemplate stringRedisTemplate;

    @Autowired
    private  RedisTemplate redisTemplate;

    @Bean
    public RedisTemplate redisTemplateInit() {
        //设置序列化Key的实例化对象
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        //设置序列化Value的实例化对象
//        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer();
        return redisTemplate;
    }

    private static final String SHIRO_PREFIX_KEY = "shiro:";

    public RedisUtil() {
    }

    public void saveStirng(String key, String info) {
        ValueOperations<String, String> value = stringRedisTemplate.opsForValue();
        value.append(key, info);
    }

    public void saveSession(String key, Session session) {
        redisTemplate.opsForValue().set(SHIRO_PREFIX_KEY + key, session);
        //30分钟过期
        redisTemplate.expire(key, 30, TimeUnit.MINUTES);
    }

    public  Session getSessionBySessionId(String key) {
        return (Session)redisTemplate.opsForValue().get(SHIRO_PREFIX_KEY + key);
    }

    public void deleteSessionBySessionId(String key) {
        redisTemplate.delete(SHIRO_PREFIX_KEY + key);
    }

    public Set<Session> getSessionList() {
        return redisTemplate.keys(SHIRO_PREFIX_KEY + "*");
    }

}
