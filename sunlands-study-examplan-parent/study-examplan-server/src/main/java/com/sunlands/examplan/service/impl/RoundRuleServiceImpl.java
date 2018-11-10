package com.sunlands.examplan.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sunlands.examplan.base.service.BaseServiceImpl;
import com.sunlands.examplan.entity.RoundRuleEntity;
import com.sunlands.examplan.mapper.RoundRuleMapper;
import com.sunlands.examplan.service.RoundRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

/**
 * 轮次规则表，OPEN开关：1开/0关；EXAM_PROVINCE考试计划省份：sch_local_province.id，多个用逗号分隔；ORDER_PERIOD报名时间段：yyyy-MM-dd，多个用逗号分隔；ALLOT同科目精讲轮次未结束时允许分配：1允许/0不允许;EXAM_PLAN限定分配的考期，如1703实现类
 *
 * @author__zhouyu
 * @email__zhouyu01@sunlands.com
 * @date_2018-11-07 20:47:19
 */
@Service
@Transactional
public class RoundRuleServiceImpl extends BaseServiceImpl<RoundRuleEntity> implements RoundRuleService {

    @Autowired
    private RoundRuleMapper roundRuleMapper;

    /**
    * 后台默认查询列表（接口勿用）
    * @param params
    * @return
    */
    @Override
    public PageInfo<RoundRuleEntity> findPageList(Map<String, Object> params) throws Exception {
        PageHelper.startPage(Integer.valueOf(String.valueOf(params.get("pageNumber"))), Integer.valueOf(String.valueOf(params.get("pageSize"))));
        List<RoundRuleEntity> roundRuleList = findList(params);
        PageInfo<RoundRuleEntity> pageInfo = new PageInfo<RoundRuleEntity>(roundRuleList);
        return pageInfo;
    }

    /**
     * 保存
     * @param roundRuleEntity
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(RoundRuleEntity roundRuleEntity, String sysUserId) throws Exception {
        roundRuleEntity.preInsert(sysUserId);
        roundRuleMapper.insert(roundRuleEntity);
    }

    /**
     * 修改
     * @param roundRuleEntity
     * @return
     */
    @Async
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(RoundRuleEntity roundRuleEntity, String sysUserId) throws Exception {
        roundRuleEntity.preUpdate(sysUserId);
        roundRuleMapper.update(roundRuleEntity);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @Async
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Integer id, String sysUserId) throws Exception {
//        roundRuleMapper.delete(id);
    }

    /**
     * 批量删除
     * @param stringIds
     * @return
     */
    @Async
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteBatchIds(List<String> stringIds) throws Exception {
        roundRuleMapper.deleteBatchIds(stringIds);
    }

}
