package com.sunlands.examplan.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sunlands.examplan.base.service.BaseServiceImpl;
import com.sunlands.examplan.entity.ExamProcessEntity;
import com.sunlands.examplan.mapper.ExamProcessMapper;
import com.sunlands.examplan.service.ExamProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

/**
 * 报考流程表实现类
 *
 * @author__zhouyu
 * @email__zhouyu01@sunlands.com
 * @date_2018-11-08 11:41:02
 */
@Service
@Transactional
public class ExamProcessServiceImpl extends BaseServiceImpl<ExamProcessEntity> implements ExamProcessService {

    @Autowired
    private ExamProcessMapper examProcessMapper;

    /**
    * 后台默认查询列表（接口勿用）
    * @param params
    * @return
    */
    @Override
    public PageInfo<ExamProcessEntity> findPageList(Map<String, Object> params) throws Exception {
        PageHelper.startPage(Integer.valueOf(String.valueOf(params.get("pageNumber"))), Integer.valueOf(String.valueOf(params.get("pageSize"))));
        List<ExamProcessEntity> examProcessList = findList(params);
        PageInfo<ExamProcessEntity> pageInfo = new PageInfo<ExamProcessEntity>(examProcessList);
        return pageInfo;
    }

    /**
     * 保存
     * @param examProcessEntity
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(ExamProcessEntity examProcessEntity, String sysUserId) throws Exception {
        examProcessEntity.preInsert(sysUserId);
        examProcessMapper.insert(examProcessEntity);
    }

    /**
     * 修改
     * @param examProcessEntity
     * @return
     */
    @Async
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(ExamProcessEntity examProcessEntity, String sysUserId) throws Exception {
        examProcessEntity.preUpdate(sysUserId);
        examProcessMapper.update(examProcessEntity);
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
//        examProcessMapper.delete(id);
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
        examProcessMapper.deleteBatchIds(stringIds);
    }

}
