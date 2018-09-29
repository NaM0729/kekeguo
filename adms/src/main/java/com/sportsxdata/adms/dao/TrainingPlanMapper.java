package com.sportsxdata.adms.dao;

import com.sportsxdata.adms.model.*;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

import java.util.List;
import java.util.Map;

public interface TrainingPlanMapper {
    int deleteByPrimaryKey(String id);

    int insert(TrainingPlan record);

    int insertSelective(TrainingPlan record);

    TrainingPlan selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TrainingPlan record);

    int updateByPrimaryKey(TrainingPlan record);

    int selectPlanByStartTimeAndEndTimeAndAthleteList(@Param("startDateTime")Date traningStartTime, @Param("endDateTime")Date traningEndTime, @Param("athleteIdList")List<String> athleteIdList);

    void batchInsert(@Param("planList")List<TrainingPlan> ereryDaysTrainingPlan);

    Integer getTraningPlanCountBycocah (TraningPlanListsBycocahEntry entry);

    List<TraningPlanListsBycocahResult> getTraningPlanListsBycocah(TraningPlanListsBycocahEntry entry);

    Map<String,String> selectCountByMainId(String id);

    List<TrainingPlan> getPlanByAthleteIdAndDatetime(@Param("athleteId") String athleteId,@Param("datetime") String datetime);

    List<AthletesByTrainingTimeResult> getAthletesByTrainingTimeAndCoachId(String coachId);

    List<AthletesTrainingResultV> getAthletesTrainingByCoachId(String coachId);
}