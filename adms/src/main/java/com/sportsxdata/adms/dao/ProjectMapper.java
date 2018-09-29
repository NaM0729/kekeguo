package com.sportsxdata.adms.dao;

import com.sportsxdata.adms.model.Project;

public interface ProjectMapper {
    int deleteByPrimaryKey(String id);

    int insert(Project record);

    int insertSelective(Project record);

    Project selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Project record);

    int updateByPrimaryKey(Project record);
}