package com.sunlands.examplan.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sunlands.examplan.base.service.BaseServiceImpl;
import com.sunlands.examplan.entity.ExamCourseEntity;
import com.sunlands.examplan.mapper.ExamCourseMapper;
import com.sunlands.examplan.service.ExamCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

/**
 * 考试科目实现类
 *
 * @author__zhouyu
 * @email__zhouyu01@sunlands.com
 * @date_2018-11-07 20:47:19
 */
@Service
@Transactional
public class ExamCourseServiceImpl extends BaseServiceImpl<ExamCourseEntity> implements ExamCourseService {

    @Autowired
    private ExamCourseMapper examCourseMapper;

    /**
    * 后台默认查询列表（接口勿用）
    * @param params
    * @return
    */
    @Override
    public PageInfo<ExamCourseEntity> findPageList(Map<String, Object> params) throws Exception {
        PageHelper.startPage(Integer.valueOf(String.valueOf(params.get("pageNumber"))), Integer.valueOf(String.valueOf(params.get("pageSize"))));
        List<ExamCourseEntity> examCourseList = findList(params);
        PageInfo<ExamCourseEntity> pageInfo = new PageInfo<ExamCourseEntity>(examCourseList);
        return pageInfo;
    }

    /**
     * 保存
     * @param examCourseEntity
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(ExamCourseEntity examCourseEntity, String sysUserId) throws Exception {
        examCourseEntity.preInsert(sysUserId);
        examCourseMapper.insert(examCourseEntity);
    }

    /**
     * 修改
     * @param examCourseEntity
     * @return
     */
    @Async
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(ExamCourseEntity examCourseEntity, String sysUserId) throws Exception {
        examCourseEntity.preUpdate(sysUserId);
        examCourseMapper.update(examCourseEntity);
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
//        examCourseMapper.delete(id);
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
        examCourseMapper.deleteBatchIds(stringIds);
    }

}
