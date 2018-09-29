package com.sportsxdata.adms.dao;

import com.sportsxdata.adms.model.SystemPermission;

public interface SystemPermissionMapper {
    int deleteByPrimaryKey(String id);

    int insert(SystemPermission record);

    int insertSelective(SystemPermission record);

    SystemPermission selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SystemPermission record);

    int updateByPrimaryKey(SystemPermission record);
}