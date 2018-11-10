package com.sunlands.examplan.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sunlands.examplan.base.service.BaseServiceImpl;
import com.sunlands.examplan.entity.RoundRuleRelEntity;
import com.sunlands.examplan.mapper.RoundRuleRelMapper;
import com.sunlands.examplan.service.RoundRuleRelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

/**
 * 轮次与规则映射表实现类
 *
 * @author__zhouyu
 * @email__zhouyu01@sunlands.com
 * @date_2018-11-07 20:47:19
 */
@Service
@Transactional
public class RoundRuleRelServiceImpl extends BaseServiceImpl<RoundRuleRelEntity> implements RoundRuleRelService {

    @Autowired
    private RoundRuleRelMapper roundRuleRelMapper;

    /**
    * 后台默认查询列表（接口勿用）
    * @param params
    * @return
    */
    @Override
    public PageInfo<RoundRuleRelEntity> findPageList(Map<String, Object> params) throws Exception {
        PageHelper.startPage(Integer.valueOf(String.valueOf(params.get("pageNumber"))), Integer.valueOf(String.valueOf(params.get("pageSize"))));
        List<RoundRuleRelEntity> roundRuleRelList = findList(params);
        PageInfo<RoundRuleRelEntity> pageInfo = new PageInfo<RoundRuleRelEntity>(roundRuleRelList);
        return pageInfo;
    }

    /**
     * 保存
     * @param roundRuleRelEntity
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(RoundRuleRelEntity roundRuleRelEntity, String sysUserId) throws Exception {
        roundRuleRelEntity.preInsert(sysUserId);
        roundRuleRelMapper.insert(roundRuleRelEntity);
    }

    /**
     * 修改
     * @param roundRuleRelEntity
     * @return
     */
    @Async
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(RoundRuleRelEntity roundRuleRelEntity, String sysUserId) throws Exception {
        roundRuleRelEntity.preUpdate(sysUserId);
        roundRuleRelMapper.update(roundRuleRelEntity);
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
//        roundRuleRelMapper.delete(id);
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
        roundRuleRelMapper.deleteBatchIds(stringIds);
    }

}
