package com.sunlands.examplan.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sunlands.examplan.base.service.BaseServiceImpl;
import com.sunlands.examplan.entity.TeachUnitEntity;
import com.sunlands.examplan.mapper.TeachUnitMapper;
import com.sunlands.examplan.service.TeachUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 教学活动表实现类
 *
 * @author__zhouyu
 * @email__zhouyu01@sunlands.com
 * @date_2018-11-08 11:13:44
 */
@Service
@Transactional
public class TeachUnitServiceImpl extends BaseServiceImpl<TeachUnitEntity> implements TeachUnitService {

    @Autowired
    private TeachUnitMapper teachUnitMapper;

    /**
    * 后台默认查询列表（接口勿用）
    * @param params
    * @return
    */
    @Override
    public PageInfo<TeachUnitEntity> findPageList(Map<String, Object> params) throws Exception {
        PageHelper.startPage(Integer.valueOf(String.valueOf(params.get("pageNumber"))), Integer.valueOf(String.valueOf(params.get("pageSize"))));
        List<TeachUnitEntity> teachUnitList = findList(params);
        PageInfo<TeachUnitEntity> pageInfo = new PageInfo<TeachUnitEntity>(teachUnitList);
        return pageInfo;
    }

    /**
     * 保存
     * @param teachUnitEntity
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(TeachUnitEntity teachUnitEntity, String sysUserId) throws Exception {
        teachUnitEntity.preInsert(sysUserId);
        teachUnitMapper.insert(teachUnitEntity);
    }

    /**
     * 修改
     * @param teachUnitEntity
     * @return
     */
    @Async
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(TeachUnitEntity teachUnitEntity, String sysUserId) throws Exception {
        teachUnitEntity.preUpdate(sysUserId);
        teachUnitMapper.update(teachUnitEntity);
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
//        teachUnitMapper.delete(id);
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
        teachUnitMapper.deleteBatchIds(stringIds);
    }

}
