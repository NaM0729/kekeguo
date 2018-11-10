package com.sunlands.examplan.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sunlands.examplan.base.service.BaseServiceImpl;
import com.sunlands.examplan.entity.OrdDetailsEntity;
import com.sunlands.examplan.mapper.OrdDetailsMapper;
import com.sunlands.examplan.service.OrdDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

/**
 * 订单明细表。子订单表。实现类
 *
 * @author__zhouyu
 * @email__zhouyu01@sunlands.com
 * @date_2018-11-07 20:47:19
 */
@Service
@Transactional
public class OrdDetailsServiceImpl extends BaseServiceImpl<OrdDetailsEntity> implements OrdDetailsService {

    @Autowired
    private OrdDetailsMapper ordDetailsMapper;

    /**
    * 后台默认查询列表（接口勿用）
    * @param params
    * @return
    */
    @Override
    public PageInfo<OrdDetailsEntity> findPageList(Map<String, Object> params) throws Exception {
        PageHelper.startPage(Integer.valueOf(String.valueOf(params.get("pageNumber"))), Integer.valueOf(String.valueOf(params.get("pageSize"))));
        List<OrdDetailsEntity> ordDetailsList = findList(params);
        PageInfo<OrdDetailsEntity> pageInfo = new PageInfo<OrdDetailsEntity>(ordDetailsList);
        return pageInfo;
    }

    /**
     * 保存
     * @param ordDetailsEntity
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(OrdDetailsEntity ordDetailsEntity, String sysUserId) throws Exception {
        ordDetailsEntity.preInsert(sysUserId);
        ordDetailsMapper.insert(ordDetailsEntity);
    }

    /**
     * 修改
     * @param ordDetailsEntity
     * @return
     */
    @Async
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(OrdDetailsEntity ordDetailsEntity, String sysUserId) throws Exception {
        ordDetailsEntity.preUpdate(sysUserId);
        ordDetailsMapper.update(ordDetailsEntity);
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
//        ordDetailsMapper.delete(id);
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
        ordDetailsMapper.deleteBatchIds(stringIds);
    }

}
