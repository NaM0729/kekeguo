package com.sportsxdata.adms.dao;

import com.sportsxdata.adms.model.AthleteProject;

public interface AthleteProjectMapper {
    int deleteByPrimaryKey(String id);

    int insert(AthleteProject record);

    int insertSelective(AthleteProject record);

    AthleteProject selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(AthleteProject record);

    int updateByPrimaryKey(AthleteProject record);
}