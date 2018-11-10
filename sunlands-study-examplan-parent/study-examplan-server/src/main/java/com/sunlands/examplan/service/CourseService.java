package com.sunlands.examplan.service;

import com.github.pagehelper.PageInfo;
import com.sunlands.examplan.base.service.BaseService;
import com.sunlands.examplan.entity.CourseEntity;

import java.util.List;
import java.util.Map;

/**
 * 科目表，不复用现在的ent_subject，因为含义不一致，现在科目隶属于二级项目接口
 *
 * @author__zhouyu
 * @email__zhouyu01@sunlands.com
 * @date_2018-11-07 20:47:19
 */
public interface CourseService extends BaseService<CourseEntity> {

   /**
    * 后台默认查询分页列表（接口勿用）
    * @param params
    * @return
    */
   PageInfo<CourseEntity> findPageList(Map<String, Object> params) throws Exception;

    /**
    * 保存
    * @param courseEntity
    * @return
    */
    void save(CourseEntity courseEntity, String sysUserId) throws Exception;

    /**
    * 修改
    * @param courseEntity
    * @return
    */
    void update(CourseEntity courseEntity, String sysUserId) throws Exception;

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

