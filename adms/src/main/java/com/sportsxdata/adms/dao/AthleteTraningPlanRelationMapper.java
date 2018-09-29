package com.sportsxdata.adms.dao;

import com.sportsxdata.adms.model.AthleteTraningPlanRelation;

public interface AthleteTraningPlanRelationMapper {
    int deleteByPrimaryKey(String id);

    int insert(AthleteTraningPlanRelation record);

    int insertSelective(AthleteTraningPlanRelation record);

    AthleteTraningPlanRelation selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(AthleteTraningPlanRelation record);

    int updateByPrimaryKey(AthleteTraningPlanRelation record);
}