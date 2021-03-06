package com.sunlands.examplan.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sunlands.examplan.base.service.BaseServiceImpl;
import com.sunlands.examplan.entity.RoundEntity;
import com.sunlands.examplan.mapper.RoundMapper;
import com.sunlands.examplan.service.RoundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

/**
 * 班号|轮次实现类
 *
 * @author__zhouyu
 * @email__zhouyu01@sunlands.com
 * @date_2018-11-07 20:47:19
 */
@Service
@Transactional
public class RoundServiceImpl extends BaseServiceImpl<RoundEntity> implements RoundService {

    @Autowired
    private RoundMapper roundMapper;

    /**
    * 后台默认查询列表（接口勿用）
    * @param params
    * @return
    */
    @Override
    public PageInfo<RoundEntity> findPageList(Map<String, Object> params) throws Exception {
        PageHelper.startPage(Integer.valueOf(String.valueOf(params.get("pageNumber"))), Integer.valueOf(String.valueOf(params.get("pageSize"))));
        List<RoundEntity> roundList = findList(params);
        PageInfo<RoundEntity> pageInfo = new PageInfo<RoundEntity>(roundList);
        return pageInfo;
    }

    /**
     * 保存
     * @param roundEntity
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(RoundEntity roundEntity, String sysUserId) throws Exception {
        roundEntity.preInsert(sysUserId);
        roundMapper.insert(roundEntity);
    }

    /**
     * 修改
     * @param roundEntity
     * @return
     */
    @Async
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(RoundEntity roundEntity, String sysUserId) throws Exception {
        roundEntity.preUpdate(sysUserId);
        roundMapper.update(roundEntity);
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
//        roundMapper.delete(id);
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
        roundMapper.deleteBatchIds(stringIds);
    }

}
