package com.kekeguo.admin.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangyuna
 * @date 2018年11月07日13:17:58
 */
@Configuration
public class DataSourceConfig {

    @Bean(name = "transferbank")
    @ConfigurationProperties(prefix = "spring.datasource.db2")
    public DataSource transferbank() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "studyplan")
    @ConfigurationProperties(prefix = "spring.datasource.db1")
    public DataSource studyplan() {
        return DataSourceBuilder.create().build();
    }


    /**
     * 动态数据源: 通过AOP在不同数据源之间动态切换
     *
     * @return
     */
    @Primary
    @Bean(name = "dynamicDataSource")
    public DataSource dynamicDataSource() {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        // 默认数据源
//        dynamicDataSource.setDefaultTargetDataSource(studyplan());
        dynamicDataSource.setDefaultTargetDataSource(transferbank());
        // 配置多数据源
        Map<Object, Object> dsMap = new HashMap();
        dsMap.put("transferbank", transferbank());
        dsMap.put("studyplan", studyplan());

        dynamicDataSource.setTargetDataSources(dsMap);
        return dynamicDataSource;
    }

    /**
     * 配置@Transactional注解事物
     *
     * @return
     */
    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dynamicDataSource());
    }

}
