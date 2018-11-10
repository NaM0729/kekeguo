package com.sunlands.examplan.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sunlands.examplan.base.service.BaseServiceImpl;
import com.sunlands.examplan.entity.ExamSessionPlanEntity;
import com.sunlands.examplan.mapper.ExamSessionPlanMapper;
import com.sunlands.examplan.service.ExamSessionPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

/**
 * 专业省份下科目考试轮次表实现类
 *
 * @author__zhouyu
 * @email__zhouyu01@sunlands.com
 * @date_2018-11-08 11:41:02
 */
@Service
@Transactional
public class ExamSessionPlanServiceImpl extends BaseServiceImpl<ExamSessionPlanEntity> implements ExamSessionPlanService {

    @Autowired
    private ExamSessionPlanMapper examSessionPlanMapper;

    /**
    * 后台默认查询列表（接口勿用）
    * @param params
    * @return
    */
    @Override
    public PageInfo<ExamSessionPlanEntity> findPageList(Map<String, Object> params) throws Exception {
        PageHelper.startPage(Integer.valueOf(String.valueOf(params.get("pageNumber"))), Integer.valueOf(String.valueOf(params.get("pageSize"))));
        List<ExamSessionPlanEntity> examSessionPlanList = findList(params);
        PageInfo<ExamSessionPlanEntity> pageInfo = new PageInfo<ExamSessionPlanEntity>(examSessionPlanList);
        return pageInfo;
    }

    /**
     * 保存
     * @param examSessionPlanEntity
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(ExamSessionPlanEntity examSessionPlanEntity, String sysUserId) throws Exception {
        examSessionPlanEntity.preInsert(sysUserId);
        examSessionPlanMapper.insert(examSessionPlanEntity);
    }

    /**
     * 修改
     * @param examSessionPlanEntity
     * @return
     */
    @Async
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(ExamSessionPlanEntity examSessionPlanEntity, String sysUserId) throws Exception {
        examSessionPlanEntity.preUpdate(sysUserId);
        examSessionPlanMapper.update(examSessionPlanEntity);
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
//        examSessionPlanMapper.delete(id);
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
        examSessionPlanMapper.deleteBatchIds(stringIds);
    }

}
