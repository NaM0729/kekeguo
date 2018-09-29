package com.sportsxdata.adms.dao;

import com.sportsxdata.adms.model.SystemRole;

import java.util.List;

public interface SystemRoleMapper {
    int deleteByPrimaryKey(String id);

    int insert(SystemRole record);

    int insertSelective(SystemRole record);

    SystemRole selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SystemRole record);

    int updateByPrimaryKey(SystemRole record);

}