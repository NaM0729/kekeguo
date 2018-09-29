package com.sportsxdata.adms.service.impl;

import com.sportsxdata.adms.dao.AthleteMapper;
import com.sportsxdata.adms.dao.CoachMapper;
import com.sportsxdata.adms.model.Athlete;
import com.sportsxdata.adms.model.DataResult;
import com.sportsxdata.adms.service.AdmsAthleticsDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class AdmsAthleticsDataServiceImpl implements AdmsAthleticsDataService {

    @Resource
    private CoachMapper coachMapper;
    @Autowired
    AthleteMapper athleteMapper;

    @Override
    public DataResult queryAthleteDataList(String coachId) {
        DataResult dataResult = new DataResult();
        if (coachId == null || "".equals(coachId)) {
            dataResult.setCode(400);
            dataResult.setMessage("教练id为空,无法查询数据!");
            return dataResult;
        }
        List<Map<String, String>> athleteDataList = coachMapper.selectAthleteDataList(coachId);
        if(athleteDataList != null && athleteDataList.size()>0){
            dataResult.setCode(200);
            dataResult.setMessage("查询成功!");
            dataResult.setData(athleteDataList);
        }else{
            dataResult.setCode(400);
            dataResult.setMessage("id为"+coachId+"的教练员查不到运动员数据");
        }
        return dataResult;
    }

    @Override
    public DataResult getAthletesByPlanId(String planId) {
        List<Athlete> athletes = athleteMapper.selectAthletesByPlanId(planId);
        DataResult success = DataResult.success(athletes);
        return success;
    }
}
