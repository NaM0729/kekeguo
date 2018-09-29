package com.sportsxdata.adms.service;

import com.sportsxdata.adms.model.DataResult;
import com.sportsxdata.adms.model.TrainingPlan;

public interface AdmsAthleticsDataService {

    DataResult queryAthleteDataList(String coachId);

    DataResult getAthletesByPlanId(String planId);

}
