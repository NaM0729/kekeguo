package com.sunlands.examplan.service;

import com.github.pagehelper.PageInfo;
import com.sunlands.examplan.base.service.BaseService;
import com.sunlands.examplan.entity.SchLocalProvinceEntity;

import java.util.List;
import java.util.Map;

/**
 * 省份（来自分校系统）接口
 *
 * @author__zhouyu
 * @email__zhouyu01@sunlands.com
 * @date_2018-11-08 11:20:40
 */
public interface SchLocalProvinceService extends BaseService<SchLocalProvinceEntity> {

   /**
    * 后台默认查询分页列表（接口勿用）
    * @param params
    * @return
    */
   PageInfo<SchLocalProvinceEntity> findPageList(Map<String, Object> params) throws Exception;

    /**
    * 保存
    * @param schLocalProvinceEntity
    * @return
    */
    void save(SchLocalProvinceEntity schLocalProvinceEntity, String sysUserId) throws Exception;

    /**
    * 修改
    * @param schLocalProvinceEntity
    * @return
    */
    void update(SchLocalProvinceEntity schLocalProvinceEntity, String sysUserId) throws Exception;

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

