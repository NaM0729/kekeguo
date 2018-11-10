package com.sunlands.examplan.service;

import com.github.pagehelper.PageInfo;
import com.sunlands.examplan.base.service.BaseService;
import com.sunlands.examplan.entity.RoundEntity;

import java.util.List;
import java.util.Map;

/**
 * 班号|轮次接口
 *
 * @author__zhouyu
 * @email__zhouyu01@sunlands.com
 * @date_2018-11-07 20:47:19
 */
public interface RoundService extends BaseService<RoundEntity> {

   /**
    * 后台默认查询分页列表（接口勿用）
    * @param params
    * @return
    */
   PageInfo<RoundEntity> findPageList(Map<String, Object> params) throws Exception;

    /**
    * 保存
    * @param roundEntity
    * @return
    */
    void save(RoundEntity roundEntity, String sysUserId) throws Exception;

    /**
    * 修改
    * @param roundEntity
    * @return
    */
    void update(RoundEntity roundEntity, String sysUserId) throws Exception;

    /**
    * 删除
    * @param id
    * @return
    */
    void delete(Integer id, String sysUserId) throws Exception;

    /**
     * 批量删除
     * @param stringIds
     * @return
     */
    void deleteBatchIds(List<String> stringIds) throws Exception;
}

