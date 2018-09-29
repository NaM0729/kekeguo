package com.sportsxdata.adms.dao;

import com.sportsxdata.adms.model.RoleMenuRelationKey;

public interface RoleMenuRelationMapper {
    int deleteByPrimaryKey(RoleMenuRelationKey key);

    int insert(RoleMenuRelationKey record);

    int insertSelective(RoleMenuRelationKey record);
}