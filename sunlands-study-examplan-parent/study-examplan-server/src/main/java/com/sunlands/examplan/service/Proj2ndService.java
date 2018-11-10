package com.sunlands.examplan.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.sunlands.examplan.base.service.BaseService;
import com.sunlands.examplan.entity.Proj2ndEntity;

/**
 * 学院与项目关系表接口
 *
 * @author__zhouyu
 * @email__zhouyu01@sunlands.com
 * @date_2018-11-07 20:47:19
 */
public interface Proj2ndService extends BaseService<Proj2ndEntity> {

   /**
    * 后台默认查询分页列表（接口勿用）
    * @param params
    * @return
    */
   PageInfo<Proj2ndEntity> findPageList(Map<String, Object> params) throws Exception;

    /**
    * 保存
    * @param proj2ndEntity
    * @return
    */
    void save(Proj2ndEntity proj2ndEntity, String sysUserId) throws Exception;

    /**
    * 修改
    * @param proj2ndEntity
    * @return
    */
    void update(Proj2ndEntity proj2ndEntity, String sysUserId) throws Exception;

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
    
    /**
     * 获取专业列表
     * @param major
     * @return
     */
    List<Proj2ndEntity> getMajorList(Proj2ndEntity proj);
}

