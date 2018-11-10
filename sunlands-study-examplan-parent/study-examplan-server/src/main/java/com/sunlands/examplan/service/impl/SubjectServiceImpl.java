package com.sunlands.examplan.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sunlands.examplan.base.service.BaseServiceImpl;
import com.sunlands.examplan.entity.SubjectEntity;
import com.sunlands.examplan.mapper.SubjectMapper;
import com.sunlands.examplan.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

/**
 * 学习科目实现类
 *
 * @author__zhouyu
 * @email__zhouyu01@sunlands.com
 * @date_2018-11-07 20:47:20
 */
@Service
@Transactional
public class SubjectServiceImpl extends BaseServiceImpl<SubjectEntity> implements SubjectService {

    @Autowired
    private SubjectMapper subjectMapper;

    /**
    * 后台默认查询列表（接口勿用）
    * @param params
    * @return
    */
    @Override
    public PageInfo<SubjectEntity> findPageList(Map<String, Object> params) throws Exception {
        PageHelper.startPage(Integer.valueOf(String.valueOf(params.get("pageNumber"))), Integer.valueOf(String.valueOf(params.get("pageSize"))));
        List<SubjectEntity> subjectList = findList(params);
        PageInfo<SubjectEntity> pageInfo = new PageInfo<SubjectEntity>(subjectList);
        return pageInfo;
    }

    /**
     * 保存
     * @param subjectEntity
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(SubjectEntity subjectEntity, String sysUserId) throws Exception {
        subjectEntity.preInsert(sysUserId);
        subjectMapper.insert(subjectEntity);
    }

    /**
     * 修改
     * @param subjectEntity
     * @return
     */
    @Async
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(SubjectEntity subjectEntity, String sysUserId) throws Exception {
        subjectEntity.preUpdate(sysUserId);
        subjectMapper.update(subjectEntity);
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
//        subjectMapper.delete(id);
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
        subjectMapper.deleteBatchIds(stringIds);
    }

}
