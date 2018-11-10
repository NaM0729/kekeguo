package com.sunlands.examplan.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sunlands.examplan.base.service.BaseServiceImpl;
import com.sunlands.examplan.entity.StuRoundEntity;
import com.sunlands.examplan.mapper.StuRoundMapper;
import com.sunlands.examplan.service.StuRoundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

/**
 * 学员拥有的轮次实现类
 *
 * @author__zhouyu
 * @email__zhouyu01@sunlands.com
 * @date_2018-11-07 20:47:19
 */
@Service
@Transactional
public class StuRoundServiceImpl extends BaseServiceImpl<StuRoundEntity> implements StuRoundService {

    @Autowired
    private StuRoundMapper stuRoundMapper;

    /**
    * 后台默认查询列表（接口勿用）
    * @param params
    * @return
    */
    @Override
    public PageInfo<StuRoundEntity> findPageList(Map<String, Object> params) throws Exception {
        PageHelper.startPage(Integer.valueOf(String.valueOf(params.get("pageNumber"))), Integer.valueOf(String.valueOf(params.get("pageSize"))));
        List<StuRoundEntity> stuRoundList = findList(params);
        PageInfo<StuRoundEntity> pageInfo = new PageInfo<StuRoundEntity>(stuRoundList);
        return pageInfo;
    }

    /**
     * 保存
     * @param stuRoundEntity
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(StuRoundEntity stuRoundEntity, String sysUserId) throws Exception {
        stuRoundEntity.preInsert(sysUserId);
        stuRoundMapper.insert(stuRoundEntity);
    }

    /**
     * 修改
     * @param stuRoundEntity
     * @return
     */
    @Async
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(StuRoundEntity stuRoundEntity, String sysUserId) throws Exception {
        stuRoundEntity.preUpdate(sysUserId);
        stuRoundMapper.update(stuRoundEntity);
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
//        stuRoundMapper.delete(id);
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
        stuRoundMapper.deleteBatchIds(stringIds);
    }

}
