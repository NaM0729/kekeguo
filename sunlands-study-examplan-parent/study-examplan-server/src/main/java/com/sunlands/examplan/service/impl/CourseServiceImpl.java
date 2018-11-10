package com.sunlands.examplan.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sunlands.examplan.base.service.BaseServiceImpl;
import com.sunlands.examplan.entity.CourseEntity;
import com.sunlands.examplan.mapper.CourseMapper;
import com.sunlands.examplan.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

/**
 * 科目表，不复用现在的ent_subject，因为含义不一致，现在科目隶属于二级项目实现类
 *
 * @author__zhouyu
 * @email__zhouyu01@sunlands.com
 * @date_2018-11-07 20:47:19
 */
@Service
@Transactional
public class CourseServiceImpl extends BaseServiceImpl<CourseEntity> implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    /**
    * 后台默认查询列表（接口勿用）
    * @param params
    * @return
    */
    @Override
    public PageInfo<CourseEntity> findPageList(Map<String, Object> params) throws Exception {
        PageHelper.startPage(Integer.valueOf(String.valueOf(params.get("pageNumber"))), Integer.valueOf(String.valueOf(params.get("pageSize"))));
        List<CourseEntity> courseList = findList(params);
        PageInfo<CourseEntity> pageInfo = new PageInfo<CourseEntity>(courseList);
        return pageInfo;
    }

    /**
     * 保存
     * @param courseEntity
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(CourseEntity courseEntity, String sysUserId) throws Exception {
        courseEntity.preInsert(sysUserId);
        courseMapper.insert(courseEntity);
    }

    /**
     * 修改
     * @param courseEntity
     * @return
     */
    @Async
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(CourseEntity courseEntity, String sysUserId) throws Exception {
        courseEntity.preUpdate(sysUserId);
        courseMapper.update(courseEntity);
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
//        courseMapper.delete(id);
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
        courseMapper.deleteBatchIds(stringIds);
    }

}
