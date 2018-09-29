package com.sportsxdata.adms.service.impl;

import com.sportsxdata.adms.dao.PlanActionRelationMapper;
import com.sportsxdata.adms.model.*;
import com.sportsxdata.adms.service.DigitalTrainingService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.*;
import java.util.regex.Pattern;

@Service
public class DigitalTrainingServiceImpl implements DigitalTrainingService{
    @Resource
    private PlanActionRelationMapper planActionRelationMapper;
    @Override
    public DataResult getTrainingPlanDataByPlanIdAndAthleteId(String planId, String athleteId) {
        if((planId == null || "".equals(planId)) && (athleteId == null || "".equals(athleteId))){
            return DataResult.fail("参数为空");
        }
        List<TrainingPlanPojo> trainingPlanPojos = planActionRelationMapper.selectTrainingPlanDataByPlanIdAndAthleteId(planId, athleteId);
        if(trainingPlanPojos == null && trainingPlanPojos.size() ==0){
            return DataResult.fail("当前时间，id为"+planId+"的计划的运动员没有训练计划");
        }
        DataResult success = DataResult.success(trainingPlanPojos);
        return success;
    }

    @Override
    public DataResult getTrainingDataByPlanIdAndAthleteId(String planId, String athleteId) {
        if((planId == null || "".equals(planId)) && (athleteId == null || "".equals(athleteId))){
            return DataResult.fail("参数为空");
        }
        List<TrainingPlanPojo> trainingPlanPojos = planActionRelationMapper.selectTrainingDataByPlanIdAndAthleteId(planId,athleteId);
        if(trainingPlanPojos == null && trainingPlanPojos.size() ==0){
            return DataResult.fail("当前时间，id为"+planId+"的计划的运动员没有训练计划");
        }
        DataResult success = DataResult.success(trainingPlanPojos);
        return success;
    }

    @Override
    public DataResult getTrainingDataByActionIdAndAthleteId(String planId, String athleteId,String actionId,String order) {
        if((planId == null || "".equals(planId)) && (athleteId == null || "".equals(athleteId)) && (actionId == null || "".equals(actionId))){
            return DataResult.fail("参数为空");
        }
        List<ActionDataPojo> actionDataPojos = planActionRelationMapper.selectTrainingDataByActionIdAndAthleteId(planId,athleteId,actionId,order);
        if(actionDataPojos.size() == 0){
            return DataResult.fail("当前时间，id为"+planId+"的计划的运动员没有训练计划");
        }
        for(ActionDataPojo actionDataPojo : actionDataPojos){
            if(actionDataPojo.getStrengthReal() != null){
                String strengthReal = actionDataPojo.getStrengthReal();
                try {
                    String number = numberIntercept(strengthReal);
                    actionDataPojo.setStrengthReal(number);
                    String unit = strengthReal.substring(number.length());
                    actionDataPojo.setUnit(unit);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        DataResult success = DataResult.success(actionDataPojos);
        return success;
    }

    @Override
    public DataResult saveTrainingPlanData(TrainingPlanVO trainingPlanVO) {
        if(trainingPlanVO == null){
            return DataResult.fail("参数为空");
        }
        List<PlanActionRelation> planActionRelations = trainingPlanVO.getPlanActionRelations();
        if(planActionRelations.size() > 0){
            try {
                planActionRelationMapper.updateTrainingPlan(planActionRelations);
            }catch (Exception e){
                e.printStackTrace();
                return DataResult.fail(e.getMessage());
            }
        }
        try {
            planActionRelationMapper.updateTrainingActionAssess(trainingPlanVO.getAssess(),trainingPlanVO.getPlanId(),trainingPlanVO.getThemeId(),trainingPlanVO.getActionId(),trainingPlanVO.getAthleteId());
        }catch (Exception e){
            e.printStackTrace();
            return DataResult.fail(e.getMessage());
        }
        return DataResult.success("添加成功");
    }

    @Override
    public DataResult saveTrainingPlanAllData(TrainingDataForAllPrograms trainingDataForAllPrograms) {
        if(trainingDataForAllPrograms == null){
            return DataResult.fail("参数为空");
        }
        String planId = trainingDataForAllPrograms.getPlanId();
        List<TrainingActionForOneProgram> trainingActionForOnePrograms= trainingDataForAllPrograms.getActionForOnePrograms();
        if(trainingActionForOnePrograms == null && trainingActionForOnePrograms.size() == 0){
            return DataResult.fail("请求参数有误，请检查！");
        }
        List<TrainingDataForOneProgram> dataForOnePrograms = new ArrayList<>();
        for(TrainingActionForOneProgram program : trainingActionForOnePrograms){
            try {
                planActionRelationMapper.updateTrainingActionAssess(program.getAssess(),planId,program.getThemeId(),program.getActionId(),program.getAthleteId());
            }catch (Exception e){
                e.printStackTrace();
                return DataResult.fail(e.getMessage());
            }
            List<TrainingDataForOneProgram> trainingDataForOnePrograms = program.getDataForOnePrograms();
            if(trainingDataForOnePrograms != null && trainingDataForOnePrograms.size() > 0){
                for(TrainingDataForOneProgram trainingDataForOneProgram: trainingDataForOnePrograms){
                    dataForOnePrograms.add(trainingDataForOneProgram);
                }
            }
        }
        if(dataForOnePrograms.size() > 0){
            try {
                planActionRelationMapper.updateAllTrainingPlanData(dataForOnePrograms);
            }catch (Exception e){
                e.printStackTrace();
                return DataResult.fail(e.getMessage());
            }
        }
        try {
            //planActionRelationMapper.updateAllTrainingPlanData(dataForOnePrograms);
            planActionRelationMapper.updataTrainingTime(planId);
        }catch (Exception e){
            e.printStackTrace();
            return DataResult.fail(e.getMessage());
        }
        return DataResult.success("添加成功");
    }

    /**
     * 提取字符串中的数字
     *
     * @param number
     * @return
     * @throws Exception
     */
    private String numberIntercept(String number) throws Exception {

        return Pattern.compile("[^0-9]").matcher(number).replaceAll("");



    }

}
