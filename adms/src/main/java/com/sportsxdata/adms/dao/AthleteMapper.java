package com.sportsxdata.adms.dao;

import com.sportsxdata.adms.model.Athlete;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AthleteMapper {
    int deleteByPrimaryKey(String id);

    int insert(Athlete record);

    int insertSelective(Athlete record);

    Athlete selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Athlete record);

    int updateByPrimaryKey(Athlete record);

    Athlete selectByCode(String username);

    List<Athlete> selectAthletesByPlanId(@Param("planId") String planId);

    List<Athlete> selectAllAthleteByCoachId(String coachId);
}