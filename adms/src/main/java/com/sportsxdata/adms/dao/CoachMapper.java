package com.sportsxdata.adms.dao;

import com.sportsxdata.adms.model.Coach;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CoachMapper {
    int deleteByPrimaryKey(String id);

    int insert(Coach record);

    int insertSelective(Coach record);

    Coach selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Coach record);

    int updateByPrimaryKey(Coach record);

    List<Map<String,String>> selectAthleteDataList(@Param("coachId")String coachId);

    Coach selectByCode(String username);
}