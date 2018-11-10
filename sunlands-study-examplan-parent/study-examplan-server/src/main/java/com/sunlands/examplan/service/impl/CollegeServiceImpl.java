package com.sunlands.examplan.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sunlands.examplan.base.service.BaseServiceImpl;
import com.sunlands.examplan.entity.CollegeEntity;
import com.sunlands.examplan.mapper.CollegeMapper;
import com.sunlands.examplan.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

/**
 * 学院实现类
 *
 * @author__zhouyu
 * @email__zhouyu01@sunlands.com
 * @date_2018-11-07 20:47:19
 */
@Service
@Transactional
public class CollegeServiceImpl extends BaseServiceImpl<CollegeEntity> implements CollegeService {

    @Autowired
    private CollegeMapper collegeMapper;

    /**
    * 后台默认查询列表（接口勿用）
    * @param params
    * @return
    */
    @Override
    public PageInfo<CollegeEntity> findPageList(Map<String, Object> params) throws Exception {
        PageHelper.startPage(Integer.valueOf(String.valueOf(params.get("pageNumber"))), Integer.valueOf(String.valueOf(params.get("pageSize"))));
        List<CollegeEntity> collegeList = findList(params);
        PageInfo<CollegeEntity> pageInfo = new PageInfo<CollegeEntity>(collegeList);
        return pageInfo;
    }

    /**
     * 保存
     * @param collegeEntity
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(CollegeEntity collegeEntity, String sysUserId) throws Exception {
        collegeEntity.preInsert(sysUserId);
        collegeMapper.insert(collegeEntity);
    }

    /**
     * 修改
     * @param collegeEntity
     * @return
     */
    @Async
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(CollegeEntity collegeEntity, String sysUserId) throws Exception {
        collegeEntity.preUpdate(sysUserId);
        collegeMapper.update(collegeEntity);
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
//        collegeMapper.delete(id);
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
        collegeMapper.deleteBatchIds(stringIds);
    }

}
