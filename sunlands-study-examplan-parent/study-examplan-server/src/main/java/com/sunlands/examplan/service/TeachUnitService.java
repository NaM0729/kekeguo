package com.sunlands.examplan.service;

import com.github.pagehelper.PageInfo;
import com.sunlands.examplan.base.service.BaseService;
import com.sunlands.examplan.entity.TeachUnitEntity;

import java.util.List;
import java.util.Map;

/**
 * 教学活动表接口
 *
 * @author__zhouyu
 * @email__zhouyu01@sunlands.com
 * @date_2018-11-08 11:13:44
 */
public interface TeachUnitService extends BaseService<TeachUnitEntity> {

   /**
    * 后台默认查询分页列表（接口勿用）
    * @param params
    * @return
    */
   PageInfo<TeachUnitEntity> findPageList(Map<String, Object> params) throws Exception;

    /**
    * 保存
    * @param teachUnitEntity
    * @return
    */
    void save(TeachUnitEntity teachUnitEntity, String sysUserId) throws Exception;

    /**
    * 修改
    * @param teachUnitEntity
    * @return
    */
    void update(TeachUnitEntity teachUnitEntity, String sysUserId) throws Exception;

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

