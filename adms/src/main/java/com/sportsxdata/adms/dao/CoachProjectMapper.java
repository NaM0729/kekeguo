package com.sportsxdata.adms.dao;

import com.sportsxdata.adms.model.CoachProject;

public interface CoachProjectMapper {
    int deleteByPrimaryKey(String id);

    int insert(CoachProject record);

    int insertSelective(CoachProject record);

    CoachProject selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CoachProject record);

    int updateByPrimaryKey(CoachProject record);
}