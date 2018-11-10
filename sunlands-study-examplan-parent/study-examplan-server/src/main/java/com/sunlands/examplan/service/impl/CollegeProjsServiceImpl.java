package com.sunlands.examplan.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sunlands.examplan.base.service.BaseServiceImpl;
import com.sunlands.examplan.entity.CollegeProjsEntity;
import com.sunlands.examplan.mapper.CollegeProjsMapper;
import com.sunlands.examplan.service.CollegeProjsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

/**
 * 二级项目基础信息实现类
 *
 * @author__zhouyu
 * @email__zhouyu01@sunlands.com
 * @date_2018-11-07 20:47:19
 */
@Service
@Transactional
public class CollegeProjsServiceImpl extends BaseServiceImpl<CollegeProjsEntity> implements CollegeProjsService {

    @Autowired
    private CollegeProjsMapper collegeProjsMapper;

    /**
    * 后台默认查询列表（接口勿用）
    * @param params
    * @return
    */
    @Override
    public PageInfo<CollegeProjsEntity> findPageList(Map<String, Object> params) throws Exception {
        PageHelper.startPage(Integer.valueOf(String.valueOf(params.get("pageNumber"))), Integer.valueOf(String.valueOf(params.get("pageSize"))));
        List<CollegeProjsEntity> collegeProjsList = findList(params);
        PageInfo<CollegeProjsEntity> pageInfo = new PageInfo<CollegeProjsEntity>(collegeProjsList);
        return pageInfo;
    }

    /**
     * 保存
     * @param collegeProjsEntity
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(CollegeProjsEntity collegeProjsEntity, String sysUserId) throws Exception {
        collegeProjsEntity.preInsert(sysUserId);
        collegeProjsMapper.insert(collegeProjsEntity);
    }

    /**
     * 修改
     * @param collegeProjsEntity
     * @return
     */
    @Async
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(CollegeProjsEntity collegeProjsEntity, String sysUserId) throws Exception {
        collegeProjsEntity.preUpdate(sysUserId);
        collegeProjsMapper.update(collegeProjsEntity);
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
//        collegeProjsMapper.delete(String.valueOf(id));
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
//        collegeProjsMapper.deleteBatchIds(stringIds);
    }

}
