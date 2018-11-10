package com.sunlands.examplan.service;

import com.github.pagehelper.PageInfo;
import com.sunlands.examplan.base.service.BaseService;
import com.sunlands.examplan.entity.CollegeEntity;

import java.util.List;
import java.util.Map;

/**
 * 学院接口
 *
 * @author__zhouyu
 * @email__zhouyu01@sunlands.com
 * @date_2018-11-07 20:47:19
 */
public interface CollegeService extends BaseService<CollegeEntity> {

   /**
    * 后台默认查询分页列表（接口勿用）
    * @param params
    * @return
    */
   PageInfo<CollegeEntity> findPageList(Map<String, Object> params) throws Exception;

    /**
    * 保存
    * @param collegeEntity
    * @return
    */
    void save(CollegeEntity collegeEntity, String sysUserId) throws Exception;

    /**
    * 修改
    * @param collegeEntity
    * @return
    */
    void update(CollegeEntity collegeEntity, String sysUserId) throws Exception;

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

