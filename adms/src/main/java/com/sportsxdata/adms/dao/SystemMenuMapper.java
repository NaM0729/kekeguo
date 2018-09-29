package com.sportsxdata.adms.dao;

import com.sportsxdata.adms.model.SystemMenu;
import com.sportsxdata.adms.model.SystemUser;

import java.util.List;

public interface SystemMenuMapper {
    int deleteByPrimaryKey(String id);

    int insert(SystemMenu record);

    int insertSelective(SystemMenu record);

    SystemMenu selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SystemMenu record);

    int updateByPrimaryKey(SystemMenu record);

    List<SystemMenu> selectMenuByUserName(String username);
}