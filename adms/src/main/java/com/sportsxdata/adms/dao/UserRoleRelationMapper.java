package com.sportsxdata.adms.dao;

import com.sportsxdata.adms.model.UserRoleRelationKey;

public interface UserRoleRelationMapper {
    int deleteByPrimaryKey(UserRoleRelationKey key);

    int insert(UserRoleRelationKey record);

    int insertSelective(UserRoleRelationKey record);
}