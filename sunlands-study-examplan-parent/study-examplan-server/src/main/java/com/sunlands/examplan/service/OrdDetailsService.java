package com.sunlands.examplan.service;

import com.github.pagehelper.PageInfo;
import com.sunlands.examplan.base.service.BaseService;
import com.sunlands.examplan.entity.OrdDetailsEntity;

import java.util.List;
import java.util.Map;

/**
 * 订单明细表。子订单表。接口
 *
 * @author__zhouyu
 * @email__zhouyu01@sunlands.com
 * @date_2018-11-07 20:47:19
 */
public interface OrdDetailsService extends BaseService<OrdDetailsEntity> {

   /**
    * 后台默认查询分页列表（接口勿用）
    * @param params
    * @return
    */
   PageInfo<OrdDetailsEntity> findPageList(Map<String, Object> params) throws Exception;

    /**
    * 保存
    * @param ordDetailsEntity
    * @return
    */
    void save(OrdDetailsEntity ordDetailsEntity, String sysUserId) throws Exception;

    /**
    * 修改
    * @param ordDetailsEntity
    * @return
    */
    void update(OrdDetailsEntity ordDetailsEntity, String sysUserId) throws Exception;

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

