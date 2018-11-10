package com.sunlands.examplan.service;

import com.github.pagehelper.PageInfo;
import com.sunlands.examplan.base.service.BaseService;
import com.sunlands.examplan.entity.ExamSessionPlanEntity;

import java.util.List;
import java.util.Map;

/**
 * 专业省份下科目考试轮次表接口
 *
 * @author__zhouyu
 * @email__zhouyu01@sunlands.com
 * @date_2018-11-08 11:41:02
 */
public interface ExamSessionPlanService extends BaseService<ExamSessionPlanEntity> {

   /**
    * 后台默认查询分页列表（接口勿用）
    * @param params
    * @return
    */
   PageInfo<ExamSessionPlanEntity> findPageList(Map<String, Object> params) throws Exception;

    /**
    * 保存
    * @param examSessionPlanEntity
    * @return
    */
    void save(ExamSessionPlanEntity examSessionPlanEntity, String sysUserId) throws Exception;

    /**
    * 修改
    * @param examSessionPlanEntity
    * @return
    */
    void update(ExamSessionPlanEntity examSessionPlanEntity, String sysUserId) throws Exception;

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

