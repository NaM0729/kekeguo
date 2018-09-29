package com.sportsxdata.adms.dao;

import com.sportsxdata.adms.model.AthleteGroup;

public interface AthleteGroupMapper {
    int deleteByPrimaryKey(String id);

    int insert(AthleteGroup record);

    int insertSelective(AthleteGroup record);

    AthleteGroup selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(AthleteGroup record);

    int updateByPrimaryKey(AthleteGroup record);
}