package com.sunlands.examplan.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sunlands.examplan.base.service.BaseServiceImpl;
import com.sunlands.examplan.entity.ExamPlanEntity;
import com.sunlands.examplan.mapper.ExamPlanMapper;
import com.sunlands.examplan.service.ExamPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

/**
 * 考试计划实现类
 *
 * @author__zhouyu
 * @email__zhouyu01@sunlands.com
 * @date_2018-11-07 20:47:19
 */
@Service
@Transactional
public class ExamPlanServiceImpl extends BaseServiceImpl<ExamPlanEntity> implements ExamPlanService {

    @Autowired
    private ExamPlanMapper examPlanMapper;

    /**
    * 后台默认查询列表（接口勿用）
    * @param params
    * @return
    */
    @Override
    public PageInfo<ExamPlanEntity> findPageList(Map<String, Object> params) throws Exception {
        PageHelper.startPage(Integer.valueOf(String.valueOf(params.get("pageNumber"))), Integer.valueOf(String.valueOf(params.get("pageSize"))));
        List<ExamPlanEntity> examPlanList = findList(params);
        PageInfo<ExamPlanEntity> pageInfo = new PageInfo<ExamPlanEntity>(examPlanList);
        return pageInfo;
    }

    /**
     * 保存
     * @param examPlanEntity
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(ExamPlanEntity examPlanEntity, String sysUserId) throws Exception {
        examPlanEntity.preInsert(sysUserId);
        examPlanMapper.insert(examPlanEntity);
    }

    /**
     * 修改
     * @param examPlanEntity
     * @return
     */
    @Async
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(ExamPlanEntity examPlanEntity, String sysUserId) throws Exception {
        examPlanEntity.preUpdate(sysUserId);
        examPlanMapper.update(examPlanEntity);
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
//        examPlanMapper.delete(id);
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
        examPlanMapper.deleteBatchIds(stringIds);
    }

}
