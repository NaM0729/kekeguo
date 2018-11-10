package com.sunlands.examplan.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sunlands.examplan.base.service.BaseServiceImpl;
import com.sunlands.examplan.entity.Proj1stEntity;
import com.sunlands.examplan.mapper.Proj1stMapper;
import com.sunlands.examplan.service.Proj1stService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

/**
 * 一级项目基础信息实现类
 *
 * @author__zhouyu
 * @email__zhouyu01@sunlands.com
 * @date_2018-11-07 20:47:19
 */
@Service
@Transactional
public class Proj1stServiceImpl extends BaseServiceImpl<Proj1stEntity> implements Proj1stService {

    @Autowired
    private Proj1stMapper proj1stMapper;

    /**
    * 后台默认查询列表（接口勿用）
    * @param params
    * @return
    */
    @Override
    public PageInfo<Proj1stEntity> findPageList(Map<String, Object> params) throws Exception {
        PageHelper.startPage(Integer.valueOf(String.valueOf(params.get("pageNumber"))), Integer.valueOf(String.valueOf(params.get("pageSize"))));
        List<Proj1stEntity> proj1stList = findList(params);
        PageInfo<Proj1stEntity> pageInfo = new PageInfo<Proj1stEntity>(proj1stList);
        return pageInfo;
    }

    /**
     * 保存
     * @param proj1stEntity
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(Proj1stEntity proj1stEntity, String sysUserId) throws Exception {
        proj1stEntity.preInsert(sysUserId);
        proj1stMapper.insert(proj1stEntity);
    }

    /**
     * 修改
     * @param proj1stEntity
     * @return
     */
    @Async
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(Proj1stEntity proj1stEntity, String sysUserId) throws Exception {
        proj1stEntity.preUpdate(sysUserId);
        proj1stMapper.update(proj1stEntity);
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
//        proj1stMapper.delete(id);
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
        proj1stMapper.deleteBatchIds(stringIds);
    }

}
