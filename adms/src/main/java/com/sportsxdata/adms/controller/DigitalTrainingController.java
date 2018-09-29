package com.sportsxdata.adms.controller;

import com.sportsxdata.adms.model.DataResult;
import com.sportsxdata.adms.model.TrainingDataForAllPrograms;
import com.sportsxdata.adms.model.TrainingPlanVO;
import com.sportsxdata.adms.service.DigitalTrainingService;
import com.sportsxdata.adms.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/digitalTraining" )
@ResponseBody
public class DigitalTrainingController {
    @Autowired
    private DigitalTrainingService digitalTrainingService;

    /**
     * 根据计划id和运动员id查询正在执行的计划(包含所有数据)
     * @param data
     * @return
     * @throws Exception
     */
    @RequestMapping("/queryExecutingTrainingPlan")
    public DataResult queryExecutingTrainingPlan(@RequestBody String data) throws Exception{
        Map<String, Object> map = JsonUtils.parseMap(data);
        String planId = map.get("planId").toString();
        String athleteId = map.get("athleteId").toString();
        return digitalTrainingService.getTrainingPlanDataByPlanIdAndAthleteId(planId,athleteId);
    }
    /**
     * 根据计划id和运动员id查询正在执行的计划(不包含每个动作所属的各组数据)
     * @param data
     * @return
     * @throws Exception
     */
    @RequestMapping("/queryExecutingTraining")
    public DataResult queryExecutingTraining(@RequestBody String data) throws Exception{
        Map<String, Object> map = JsonUtils.parseMap(data);
        String planId = map.get("planId").toString();
        String athleteId = map.get("athleteId").toString();
        return digitalTrainingService.getTrainingDataByPlanIdAndAthleteId(planId,athleteId);
    }
    /**
     * 根据计划id、运动员id和动作id查询各组的数据
     * @param data
     * @return
     * @throws Exception
     */
    @RequestMapping("/queryExecutingTrainingAction")
    public DataResult queryExecutingTrainingAction(@RequestBody String data) throws Exception{
        Map<String, Object> map = JsonUtils.parseMap(data);
        String planId = map.get("planId").toString();
        String athleteId = map.get("athleteId").toString();
        String actionId = map.get("actionId").toString();
        String order = map.get("order").toString();
        return digitalTrainingService.getTrainingDataByActionIdAndAthleteId(planId,athleteId,actionId,order);
    }

    /**
     * 插入实际训练数据
     * @param trainingPlanVO
     * @return
     * @throws Exception
     */
    @RequestMapping("/saveTrainingPlan")
    public DataResult saveTrainingPlan(@RequestBody TrainingPlanVO trainingPlanVO) throws Exception{
        return digitalTrainingService.saveTrainingPlanData(trainingPlanVO);
    }

    /**
     * 插入整条计划的实际训练数据
     * @param trainingDataForAllPrograms
     * @return
     * @throws Exception
     */
    @RequestMapping("/saveOneTrainingPlan")
    public DataResult saveOneTrainingPlan(@RequestBody TrainingDataForAllPrograms trainingDataForAllPrograms) throws Exception{
        return digitalTrainingService.saveTrainingPlanAllData(trainingDataForAllPrograms);
    }


}
