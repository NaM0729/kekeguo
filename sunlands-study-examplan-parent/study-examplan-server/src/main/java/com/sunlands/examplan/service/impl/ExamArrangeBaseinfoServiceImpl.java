package com.sunlands.examplan.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sunlands.examplan.base.service.BaseServiceImpl;
import com.sunlands.examplan.entity.ExamArrangeBaseinfoEntity;
import com.sunlands.examplan.mapper.ExamArrangeBaseinfoMapper;
import com.sunlands.examplan.service.ExamArrangeBaseinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

/**
 * 考试安排base表实现类
 *
 * @author__zhouyu
 * @email__zhouyu01@sunlands.com
 * @date_2018-11-07 20:47:19
 */
@Service
@Transactional
public class ExamArrangeBaseinfoServiceImpl extends BaseServiceImpl<ExamArrangeBaseinfoEntity> implements ExamArrangeBaseinfoService {

    @Autowired
    private ExamArrangeBaseinfoMapper examArrangeBaseinfoMapper;

    /**
    * 后台默认查询列表（接口勿用）
    * @param params
    * @return
    */
    @Override
    public PageInfo<ExamArrangeBaseinfoEntity> findPageList(Map<String, Object> params) throws Exception {
        PageHelper.startPage(Integer.valueOf(String.valueOf(params.get("pageNumber"))), Integer.valueOf(String.valueOf(params.get("pageSize"))));
        List<ExamArrangeBaseinfoEntity> examArrangeBaseinfoList = findList(params);
        PageInfo<ExamArrangeBaseinfoEntity> pageInfo = new PageInfo<ExamArrangeBaseinfoEntity>(examArrangeBaseinfoList);
        return pageInfo;
    }

    /**
     * 保存
     * @param examArrangeBaseinfoEntity
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(ExamArrangeBaseinfoEntity examArrangeBaseinfoEntity, String sysUserId) throws Exception {
        examArrangeBaseinfoEntity.preInsert(sysUserId);
        examArrangeBaseinfoMapper.insert(examArrangeBaseinfoEntity);
    }

    /**
     * 修改
     * @param examArrangeBaseinfoEntity
     * @return
     */
    @Async
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(ExamArrangeBaseinfoEntity examArrangeBaseinfoEntity, String sysUserId) throws Exception {
        examArrangeBaseinfoEntity.preUpdate(sysUserId);
        examArrangeBaseinfoMapper.update(examArrangeBaseinfoEntity);
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
//        examArrangeBaseinfoMapper.delete(id);
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
        examArrangeBaseinfoMapper.deleteBatchIds(stringIds);
    }

}
