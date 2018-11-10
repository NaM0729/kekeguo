package com.sunlands.examplan.service;

import com.github.pagehelper.PageInfo;
import com.sunlands.examplan.base.service.BaseService;
import com.sunlands.examplan.entity.StuRoundEntity;

import java.util.List;
import java.util.Map;

/**
 * 学员拥有的轮次接口
 *
 * @author__zhouyu
 * @email__zhouyu01@sunlands.com
 * @date_2018-11-07 20:47:19
 */
public interface StuRoundService extends BaseService<StuRoundEntity> {

   /**
    * 后台默认查询分页列表（接口勿用）
    * @param params
    * @return
    */
   PageInfo<StuRoundEntity> findPageList(Map<String, Object> params) throws Exception;

    /**
    * 保存
    * @param stuRoundEntity
    * @return
    */
    void save(StuRoundEntity stuRoundEntity, String sysUserId) throws Exception;

    /**
    * 修改
    * @param stuRoundEntity
    * @return
    */
    void update(StuRoundEntity stuRoundEntity, String sysUserId) throws Exception;

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

