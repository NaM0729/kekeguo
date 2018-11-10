package com.sunlands.examplan.service;

import com.github.pagehelper.PageInfo;
import com.sunlands.examplan.base.service.BaseService;
import com.sunlands.examplan.entity.SubjectEntity;

import java.util.List;
import java.util.Map;

/**
 * 学习科目接口
 *
 * @author__zhouyu
 * @email__zhouyu01@sunlands.com
 * @date_2018-11-07 20:47:20
 */
public interface SubjectService extends BaseService<SubjectEntity> {

   /**
    * 后台默认查询分页列表（接口勿用）
    * @param params
    * @return
    */
   PageInfo<SubjectEntity> findPageList(Map<String, Object> params) throws Exception;

    /**
    * 保存
    * @param subjectEntity
    * @return
    */
    void save(SubjectEntity subjectEntity, String sysUserId) throws Exception;

    /**
    * 修改
    * @param subjectEntity
    * @return
    */
    void update(SubjectEntity subjectEntity, String sysUserId) throws Exception;

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

