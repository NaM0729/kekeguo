package com.kekeguo.admin.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author zhangyuna
 * @date 2018年11月07日14:49:45
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        System.out.println("数据源为"+DataSourceContextHolder.getDB());
        return DataSourceContextHolder.getDB();
    }
}
