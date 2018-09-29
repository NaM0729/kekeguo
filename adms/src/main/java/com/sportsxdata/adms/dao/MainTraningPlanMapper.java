package com.sportsxdata.adms.dao;

import com.sportsxdata.adms.model.MainTraningPlan;

public interface MainTraningPlanMapper {
    int deleteByPrimaryKey(String id);

    int insert(MainTraningPlan record);

    int insertSelective(MainTraningPlan record);

    MainTraningPlan selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(MainTraningPlan record);

    int updateByPrimaryKey(MainTraningPlan record);
}