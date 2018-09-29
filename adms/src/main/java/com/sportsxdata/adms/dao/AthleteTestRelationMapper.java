package com.sportsxdata.adms.dao;

import com.sportsxdata.adms.model.AthleteTestRelation;

public interface AthleteTestRelationMapper {
    int deleteByPrimaryKey(String id);

    int insert(AthleteTestRelation record);

    int insertSelective(AthleteTestRelation record);

    AthleteTestRelation selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(AthleteTestRelation record);

    int updateByPrimaryKey(AthleteTestRelation record);
}