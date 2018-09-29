package com.sportsxdata.adms.dao;

import com.sportsxdata.adms.model.RolePermissionRelationKey;

public interface RolePermissionRelationMapper {
    int deleteByPrimaryKey(RolePermissionRelationKey key);

    int insert(RolePermissionRelationKey record);

    int insertSelective(RolePermissionRelationKey record);
}