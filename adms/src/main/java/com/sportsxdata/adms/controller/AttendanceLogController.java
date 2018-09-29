package com.sportsxdata.adms.controller;

import com.sportsxdata.adms.model.AttendanceLog;
import com.sportsxdata.adms.model.DataResult;
import com.sportsxdata.adms.service.AttendanceLogService;
import com.sportsxdata.adms.utils.JsonUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping("/attendance")
@ResponseBody
public class AttendanceLogController {
    @Resource
    AttendanceLogService attendanceLogService;

    /**
     * @param
     * @return
     * @throws IOException
     * 创建时间:2018年6月26日
     * 作用:添加出勤记录!
     * 返回值类型:DataResult
     */
    @RequestMapping("/saveAttendanceLogData")
    public DataResult saveAttendanceLogData(@RequestBody AttendanceLog attendanceLog) throws IOException {
        return attendanceLogService.saveAttendanceLogData(attendanceLog);
    }

    /**
     * 查看该教练下运动员出勤情况
     */
    @RequestMapping("/getAttendanceLogByCoachId")
    public DataResult getAttendanceLogByCoachId(@RequestBody String data) throws IOException {
        Map<String, Object> parseMap = JsonUtils.parseMap(data);
        String coachId = (String) parseMap.get("coachId");
        return attendanceLogService.getAttendanceLogByCoachId(coachId);
    }

    /**
     * 通过教练ID查看所有运动员列表，含请假情况，针对添加日常训练菜单
     * @param data
     * @return
     * @throws IOException
     */
    @RequestMapping("/getAthleticsByCoach")
    public DataResult getAthleticsByCoach(@RequestBody String data) throws IOException{
        Map<String, Object> parseMap = JsonUtils.parseMap(data);
        String coachId = (String) parseMap.get("coachId");
        return attendanceLogService.getAthleticsByCoach(coachId);
    }
}
