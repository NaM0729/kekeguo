package com.sportsxdata.adms.dao;

import com.sportsxdata.adms.model.SystemUser;

public interface SystemUserMapper {
    int deleteByPrimaryKey(String id);

    int insert(SystemUser record);

    int insertSelective(SystemUser record);

    SystemUser selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SystemUser record);

    int updateByPrimaryKey(SystemUser record);

    SystemUser selectUserByName(String username);

}