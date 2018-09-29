package com.sportsxdata.adms.dao;

import com.sportsxdata.adms.model.AthleteLevel;

public interface AthleteLevelMapper {
    int deleteByPrimaryKey(String id);

    int insert(AthleteLevel record);

    int insertSelective(AthleteLevel record);

    AthleteLevel selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(AthleteLevel record);

    int updateByPrimaryKey(AthleteLevel record);
}