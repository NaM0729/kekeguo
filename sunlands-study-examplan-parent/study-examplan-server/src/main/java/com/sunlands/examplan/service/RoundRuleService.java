package com.sunlands.examplan.service;

import com.github.pagehelper.PageInfo;
import com.sunlands.examplan.base.service.BaseService;
import com.sunlands.examplan.entity.RoundRuleEntity;

import java.util.List;
import java.util.Map;

/**
 * 轮次规则表，OPEN开关：1开/0关；EXAM_PROVINCE考试计划省份：sch_local_province.id，多个用逗号分隔；ORDER_PERIOD报名时间段：yyyy-MM-dd，多个用逗号分隔；ALLOT同科目精讲轮次未结束时允许分配：1允许/0不允许;EXAM_PLAN限定分配的考期，如1703接口
 *
 * @author__zhouyu
 * @email__zhouyu01@sunlands.com
 * @date_2018-11-07 20:47:19
 */
public interface RoundRuleService extends BaseService<RoundRuleEntity> {

   /**
    * 后台默认查询分页列表（接口勿用）
    * @param params
    * @return
    */
   PageInfo<RoundRuleEntity> findPageList(Map<String, Object> params) throws Exception;

    /**
    * 保存
    * @param roundRuleEntity
    * @return
    */
    void save(RoundRuleEntity roundRuleEntity, String sysUserId) throws Exception;

    /**
    * 修改
    * @param roundRuleEntity
    * @return
    */
    void update(RoundRuleEntity roundRuleEntity, String sysUserId) throws Exception;

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

