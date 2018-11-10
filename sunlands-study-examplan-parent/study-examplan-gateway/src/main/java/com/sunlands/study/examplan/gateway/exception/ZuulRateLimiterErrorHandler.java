package com.sunlands.study.examplan.gateway.exception;

import com.marcosbarbero.cloud.autoconfigure.zuul.ratelimit.config.repository.DefaultRateLimiterErrorHandler;
import com.marcosbarbero.cloud.autoconfigure.zuul.ratelimit.config.repository.RateLimiterErrorHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 限流降级处理
 * @author_zhouyu
 * @email_zhouyu01@sunlands.com
 * @date_2018年11月07日22:04:18
 */
@Configuration
public class ZuulRateLimiterErrorHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(ZuulRateLimiterErrorHandler.class);


    @Bean
    public RateLimiterErrorHandler rateLimitErrorHandler() {
        return new DefaultRateLimiterErrorHandler() {
            @Override
            public void handleSaveError(String key, Exception e) {
                LOGGER.error("保存key:[{}]异常", key, e);
            }

            @Override
            public void handleFetchError(String key, Exception e) {
                LOGGER.error("路由失败:[{}]异常", key);
            }

            @Override
            public void handleError(String msg, Exception e) {
                LOGGER.error("限流异常:[{}]", msg, e);
            }
        };
    }
}
