package com.sportsxdata.adms.dao;

import com.sportsxdata.adms.model.*;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface PlanActionRelationMapper {
    int deleteByPrimaryKey(String id);

    int insert(PlanActionRelation record);

    int insertSelective(PlanActionRelation record);

    PlanActionRelation selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PlanActionRelation record);

    int updateByPrimaryKey(PlanActionRelation record);

    void batchInsert(@Param("planActionRelationList")List<PlanActionRelation> toSavePlanActionRelation);

    List<PlanActionRelation> getPlanActionRelationByPlanId(@Param("planId") String planId);

    List<TrainingPlanPojo> selectTrainingPlanDataByPlanIdAndAthleteId(@Param("planId")String planId, @Param("athleteId")String athleteId);

    List<TrainingPlanPojo> selectTrainingDataByPlanIdAndAthleteId(@Param("planId")String planId, @Param("athleteId")String athleteId);

    List<ActionDataPojo> selectTrainingDataByActionIdAndAthleteId(@Param("planId")String planId, @Param("athleteId")String athleteId,@Param("actionId")String actionId,@Param("order")String order);

    void updateTrainingPlan(@Param("planActionRelations") List<PlanActionRelation> planActionRelations);

    void updateAllTrainingPlanData(@Param("dataForOnePrograms") List<TrainingDataForOneProgram> dataForOnePrograms);

    void updataTrainingTime(String planId);

    void updateTrainingActionAssess(@Param("assess") String assess,@Param("planId") String planId,@Param("themeId") String themeId,@Param("actionId") String actionId,@Param("athleteId") String athleteId);
    /**
     * 根据计划ids,运动员id获得计划列表
     * @param plandIds
     * @param athleteId
     * @return
     */
    List<AthletePlansVO> getPlanInfo(@Param("planIds")List<String> plandIds,@Param("athleteId")String athleteId);

    void deleteByTrainPlanId(String id);
    int deleteByTrainingPlaneId(String trainingPlaneId);
    /**
     * 编辑计划-查询计划
     * @param pid
     * @param coachId
     * @return
     */
    List<ActionRelEditPlanVo> editPlanSearch(@Param("pid") String pid, @Param("coachId")String coachId);

    TrainingPlanInfo selectInfoByPlanId(String planId);

    AthletePlansVO getOnePlanInfo(@Param("planId")String s, @Param("athleteId")String athleteId);
}