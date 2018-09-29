package com.sportsxdata.adms.service;

import com.sportsxdata.adms.model.DataResult;
import com.sportsxdata.adms.model.PlanActionRelation;
import com.sportsxdata.adms.model.TrainingDataForAllPrograms;
import com.sportsxdata.adms.model.TrainingPlanVO;

public interface DigitalTrainingService {

    DataResult getTrainingPlanDataByPlanIdAndAthleteId(String planId,String athleteId);

    DataResult getTrainingDataByPlanIdAndAthleteId(String planId,String athleteId);

    DataResult getTrainingDataByActionIdAndAthleteId(String planId,String athleteId,String actionId,String order);

    DataResult saveTrainingPlanData(TrainingPlanVO trainingPlanVO);

    DataResult saveTrainingPlanAllData(TrainingDataForAllPrograms trainingDataForAllPrograms);

}
