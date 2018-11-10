package com.sunlands.examplan.service;

import com.github.pagehelper.PageInfo;
import com.sunlands.examplan.base.service.BaseService;
import com.sunlands.examplan.entity.ModuleEntity;

import java.util.List;
import java.util.Map;

/**
 * 模块接口
 *
 * @author__zhouyu
 * @email__zhouyu01@sunlands.com
 * @date_2018-11-07 20:47:20
 */
public interface ModuleService extends BaseService<ModuleEntity> {

   /**
    * 后台默认查询分页列表（接口勿用）
    * @param params
    * @return
    */
   PageInfo<ModuleEntity> findPageList(Map<String, Object> params) throws Exception;

    /**
    * 保存
    * @param moduleEntity
    * @return
    */
    void save(ModuleEntity moduleEntity, String sysUserId) throws Exception;

    /**
    * 修改
    * @param moduleEntity
    * @return
    */
    void update(ModuleEntity moduleEntity, String sysUserId) throws Exception;

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

