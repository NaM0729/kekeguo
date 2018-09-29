package com.sportsxdata.adms.service.impl;

import com.sportsxdata.adms.dao.AttendanceLogMapper;
import com.sportsxdata.adms.model.AttendanceLog;
import com.sportsxdata.adms.model.DataResult;
import com.sportsxdata.adms.model.AttendanceLogReasultByCoach;
import com.sportsxdata.adms.service.AttendanceLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class AttendanceLogServiceImpl implements AttendanceLogService {
    @Resource
    AttendanceLogMapper attendanceLogMapper;

    @Override
    public DataResult saveAttendanceLogData(AttendanceLog attendanceLog) {
        DataResult dataResult = new DataResult();
        if (attendanceLog == null) {
            dataResult.setCode(400);
            dataResult.setMessage("数据为空,无法出勤记录!");
            return dataResult;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        AttendanceLog attendance = attendanceLogMapper.selectByAthleteIdAndAttendanceTime(attendanceLog.getAdmsAthleteId(), sdf.format(attendanceLog.getStartTime()), sdf.format(attendanceLog.getEndTime()));
        if(attendance != null){
            dataResult.setCode(400);
            dataResult.setMessage("无需重复添加出勤记录");
            return dataResult;
        }
        attendanceLog.setId(UUID.randomUUID().toString());
        attendanceLogMapper.insert(attendanceLog);
        dataResult.setCode(200);
        dataResult.setMessage("添加出勤记录成功!");
        return dataResult;
    }

    /**
     * 通过教练ID查看所有运动员请假情况
     * @param coachId
     * @return
     */
    @Override
    public DataResult getAttendanceLogByCoachId(String coachId) {
        List<AttendanceLogReasultByCoach> lists = attendanceLogMapper.getAttendanceLogByCoachId(coachId);
        for (int i=0 ;i<lists.size();i++){
            AttendanceLogReasultByCoach att = lists.get(i);
            Integer time = Integer.valueOf(att.getLengthTime());
            int day = Integer.valueOf(time)/24 ;
            int hour = Integer.valueOf(time)%24 ;
            att.setLengthTime(day+"天"+hour+"小时");
        }
        return DataResult.success(lists);
    }

    /**
     * 通过教练ID查看所有运动员列表，含请假情况，针对添加日常训练菜单
     * @param coachId
     * @return
     */
    @Override
    public DataResult getAthleticsByCoach(String coachId) {
        List<Map> lists = attendanceLogMapper.getAthleticsByCoach(coachId);
        return DataResult.success(lists);
    }
}
