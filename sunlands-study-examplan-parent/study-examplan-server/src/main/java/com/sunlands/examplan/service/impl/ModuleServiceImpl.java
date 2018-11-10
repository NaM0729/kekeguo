package com.sunlands.examplan.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sunlands.examplan.base.service.BaseServiceImpl;
import com.sunlands.examplan.entity.ModuleEntity;
import com.sunlands.examplan.mapper.ModuleMapper;
import com.sunlands.examplan.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

/**
 * 模块实现类
 *
 * @author__zhouyu
 * @email__zhouyu01@sunlands.com
 * @date_2018-11-07 20:47:20
 */
@Service
@Transactional
public class ModuleServiceImpl extends BaseServiceImpl<ModuleEntity> implements ModuleService {

    @Autowired
    private ModuleMapper moduleMapper;

    /**
    * 后台默认查询列表（接口勿用）
    * @param params
    * @return
    */
    @Override
    public PageInfo<ModuleEntity> findPageList(Map<String, Object> params) throws Exception {
        PageHelper.startPage(Integer.valueOf(String.valueOf(params.get("pageNumber"))), Integer.valueOf(String.valueOf(params.get("pageSize"))));
        List<ModuleEntity> moduleList = findList(params);
        PageInfo<ModuleEntity> pageInfo = new PageInfo<ModuleEntity>(moduleList);
        return pageInfo;
    }

    /**
     * 保存
     * @param moduleEntity
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(ModuleEntity moduleEntity, String sysUserId) throws Exception {
        moduleEntity.preInsert(sysUserId);
        moduleMapper.insert(moduleEntity);
    }

    /**
     * 修改
     * @param moduleEntity
     * @return
     */
    @Async
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(ModuleEntity moduleEntity, String sysUserId) throws Exception {
        moduleEntity.preUpdate(sysUserId);
        moduleMapper.update(moduleEntity);
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
//        moduleMapper.delete(id);
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
        moduleMapper.deleteBatchIds(stringIds);
    }

}
