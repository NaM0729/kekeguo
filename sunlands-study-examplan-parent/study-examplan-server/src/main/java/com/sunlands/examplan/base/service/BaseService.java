package com.sunlands.examplan.base.service;

import java.util.List;
import java.util.Map;

/**
 * 基类抽象接口
 * @Class Name BaseService
 * @author 周宇
 * @Create In 2018年08月03日18:32:00
 * @email_zhouyu01@sunlands.com
 * @param <T>
 */
public interface BaseService<T> {


    /**
     * 后台默认查询列表（接口勿用）
     * @param
     * @return
     */
    List<T> findList(Map<String, Object> params);

    /**
     * 查询总数
     * @return
     */
    int queryTotal();

    /**
     * 根据id获取
     * @param userId
     * @return
     */
    T get(String userId);

}
