package com.sportsxdata.adms.dao;

import com.sportsxdata.adms.model.Race;

public interface RaceMapper {
    int deleteByPrimaryKey(String id);

    int insert(Race record);

    int insertSelective(Race record);

    Race selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Race record);

    int updateByPrimaryKey(Race record);
}