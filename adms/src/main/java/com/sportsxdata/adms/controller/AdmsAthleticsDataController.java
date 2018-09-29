package com.sportsxdata.adms.controller;

import com.sportsxdata.adms.model.DataResult;
import com.sportsxdata.adms.service.AdmsAthleticsDataService;
import com.sportsxdata.adms.utils.JsonUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping("/admsAthleticsData")
@ResponseBody
public class AdmsAthleticsDataController {

    @Autowired
    private AdmsAthleticsDataService admsAthleticsDataService;
    /**
     * @param data
     * @return
     * @throws IOException
     * 创建时间:2018年6月26日
     * 作用:通过教练id查询对应的远动员数据!
     * 返回值类型:DataResult
     */
    @RequiresRoles(value = {"coach"},logical = Logical.OR)
    @RequestMapping("/queryAthleticsDataList")
    public DataResult queryAthleticsDataList(@RequestBody String data)throws IOException {
        Map<String, Object> map = JsonUtils.parseMap(data);
        String coachId = map.get("coachId").toString();
        return admsAthleticsDataService.queryAthleteDataList(coachId);
    }



    @RequestMapping("/{planId}")
    public DataResult getAthletesByPlanId(@PathVariable String planId)throws IOException {
        DataResult athletesByPlanId = admsAthleticsDataService.getAthletesByPlanId(planId);
        return athletesByPlanId;
    }

}
