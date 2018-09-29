package com.sportsxdata.adms.service;

import com.sportsxdata.adms.model.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import com.sportsxdata.adms.model.DataResult;
import com.sportsxdata.adms.model.InsertTrainPlanPojo;
import com.sportsxdata.adms.model.PageSizeDataGrid;
import com.sportsxdata.adms.model.TraningPlanListsBycocahEntry;

public interface TrainingService {

    PageSizeDataGrid getTraningPlanListsBycocah(TraningPlanListsBycocahEntry entry);

    DataResult insertTrainPlan(InsertTrainPlanPojo insertTrainPlanPojo);

    PageSizeDataGrid deleteTraningPlanById(TraningPlanListsBycocahEntry entry);

    DataResult getPlanByAthleteIdAndDatetime(String athleteId,String datetime);


    DataResult getTrainingPlanById(String planId);


    DataResult selectThemeBySectionId(String sectionId,String coachId);

    DataResult selectActionByThemeId(String themeId,String coachId);

    DataResult getAthletesByTrainingTimeAndCoachId(String coachId);

    DataResult getAthletesTrainingByCoachId(String coachId);

    DataResult afterUpdateToSaveTrainPlan(InsertEveryDayTrainPlanPojo insertEveryDayTrainPlanPojo);

    DataResult getPlanInfoByAthleteIdAndTime(String athleteId, String date);

    DataResult editPlanInfoByCoachIdAndPlanId(String coachId, String planId);

    DataResult seachPlanInfoById(String planId);

    DataResult selectAllAthleteByCoachId(String coachId);


    List<AthletePlansVO>  excel(String athleteId,String datetime);
}
