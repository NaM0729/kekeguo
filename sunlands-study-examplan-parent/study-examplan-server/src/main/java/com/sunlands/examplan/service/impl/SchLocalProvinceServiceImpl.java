package com.sunlands.examplan.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sunlands.examplan.base.service.BaseServiceImpl;
import com.sunlands.examplan.entity.SchLocalProvinceEntity;
import com.sunlands.examplan.mapper.SchLocalProvinceMapper;
import com.sunlands.examplan.service.SchLocalProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 省份（来自分校系统）实现类
 *
 * @author__zhouyu
 * @email__zhouyu01@sunlands.com
 * @date_2018-11-08 11:20:40
 */
@Service
@Transactional
public class SchLocalProvinceServiceImpl extends BaseServiceImpl<SchLocalProvinceEntity> implements SchLocalProvinceService {

    @Autowired
    private SchLocalProvinceMapper schLocalProvinceMapper;

    /**
    * 后台默认查询列表（接口勿用）
    * @param params
    * @return
    */
    @Override
    public PageInfo<SchLocalProvinceEntity> findPageList(Map<String, Object> params) throws Exception {
        PageHelper.startPage(Integer.valueOf(String.valueOf(params.get("pageNumber"))), Integer.valueOf(String.valueOf(params.get("pageSize"))));
        List<SchLocalProvinceEntity> schLocalProvinceList = findList(params);
        PageInfo<SchLocalProvinceEntity> pageInfo = new PageInfo<SchLocalProvinceEntity>(schLocalProvinceList);
        return pageInfo;
    }

    /**
     * 保存
     * @param schLocalProvinceEntity
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(SchLocalProvinceEntity schLocalProvinceEntity, String sysUserId) throws Exception {
        schLocalProvinceEntity.preInsert(sysUserId);
        schLocalProvinceMapper.insert(schLocalProvinceEntity);
    }

    /**
     * 修改
     * @param schLocalProvinceEntity
     * @return
     */
    @Async
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(SchLocalProvinceEntity schLocalProvinceEntity, String sysUserId) throws Exception {
        schLocalProvinceEntity.preUpdate(sysUserId);
        schLocalProvinceMapper.update(schLocalProvinceEntity);
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
//        schLocalProvinceMapper.delete(id);
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
        schLocalProvinceMapper.deleteBatchIds(stringIds);
    }

}
