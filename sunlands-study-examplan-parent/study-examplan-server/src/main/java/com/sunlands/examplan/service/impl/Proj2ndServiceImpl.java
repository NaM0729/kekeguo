package com.sunlands.examplan.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sunlands.examplan.base.service.BaseServiceImpl;
import com.sunlands.examplan.entity.Proj2ndEntity;
import com.sunlands.examplan.mapper.Proj2ndMapper;
import com.sunlands.examplan.service.Proj2ndService;

/**
 * 学院与项目关系表实现类
 *
 * @author__zhouyu
 * @email__zhouyu01@sunlands.com
 * @date_2018-11-07 20:47:19
 */
@Service
@Transactional
public class Proj2ndServiceImpl extends BaseServiceImpl<Proj2ndEntity> implements Proj2ndService {

    @Autowired
    private Proj2ndMapper proj2ndMapper;

    /**
    * 后台默认查询列表（接口勿用）
    * @param params
    * @return
    */
    @Override
    public PageInfo<Proj2ndEntity> findPageList(Map<String, Object> params) throws Exception {
        PageHelper.startPage(Integer.valueOf(String.valueOf(params.get("pageNumber"))), Integer.valueOf(String.valueOf(params.get("pageSize"))));
        List<Proj2ndEntity> proj2ndList = findList(params);
        PageInfo<Proj2ndEntity> pageInfo = new PageInfo<Proj2ndEntity>(proj2ndList);
        return pageInfo;
    }

    /**
     * 保存
     * @param proj2ndEntity
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(Proj2ndEntity proj2ndEntity, String sysUserId) throws Exception {
        proj2ndEntity.preInsert(sysUserId);
        proj2ndMapper.insert(proj2ndEntity);
    }

    /**
     * 修改
     * @param proj2ndEntity
     * @return
     */
    @Async
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(Proj2ndEntity proj2ndEntity, String sysUserId) throws Exception {
        proj2ndEntity.preUpdate(sysUserId);
        proj2ndMapper.update(proj2ndEntity);
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
//        proj2ndMapper.delete(id);
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
        proj2ndMapper.deleteBatchIds(stringIds);
    }
    
    /**
     * 获取专业列表
     * @param major
     * @return
     */
    @Async
    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<Proj2ndEntity> getMajorList(Proj2ndEntity proj){
        return proj2ndMapper.getMajorList(proj);
    }
}
