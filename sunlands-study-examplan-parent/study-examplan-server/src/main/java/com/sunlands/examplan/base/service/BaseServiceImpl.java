package com.sunlands.examplan.base.service;

import com.sunlands.examplan.base.mapper.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * 基类接口实现类
 * @Class Name BaseServiceImpl
 * @author 周宇
 * @Create_2018年08月03日19:57:39
 * @email_zhouyu01@sunlands.com
 * @param <T>
 */
public class BaseServiceImpl<T> implements BaseService<T> {

    @Autowired
    private BaseMapper<T> baseMapper;


    /**
     * 后台默认查询分页列表（接口勿用）
     * @param params
     * @return
     */
    @Override
    public List<T> findList(Map<String, Object> params) {
        List<T> sysLogList = baseMapper.findList(params);
        return sysLogList;
    }

    /**
     * 查询总数
     * @return
     */
    @Override
    public int queryTotal() {
        return baseMapper.queryTotal();
    }

    @Override
    public T get(String id) {
        return baseMapper.get(id);
    }

}
