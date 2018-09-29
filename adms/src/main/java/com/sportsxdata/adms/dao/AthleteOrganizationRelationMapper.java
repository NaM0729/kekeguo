package com.sportsxdata.adms.dao;

import com.sportsxdata.adms.model.AthleteOrganizationRelationKey;

public interface AthleteOrganizationRelationMapper {
    int deleteByPrimaryKey(AthleteOrganizationRelationKey key);

    int insert(AthleteOrganizationRelationKey record);

    int insertSelective(AthleteOrganizationRelationKey record);
}