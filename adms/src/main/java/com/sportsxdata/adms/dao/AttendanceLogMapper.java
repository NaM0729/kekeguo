package com.sportsxdata.adms.dao;

import com.sportsxdata.adms.model.AttendanceLog;
import com.sportsxdata.adms.model.AttendanceLogReasultByCoach;

import java.util.List;

import java.util.Date;
import java.util.Map;

public interface AttendanceLogMapper {
    int deleteByPrimaryKey(String id);

    int insert(AttendanceLog record);

    int insertSelective(AttendanceLog record);

    AttendanceLog selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(AttendanceLog record);

    int updateByPrimaryKey(AttendanceLog record);

    List<AttendanceLogReasultByCoach> getAttendanceLogByCoachId(String coachId);

    AttendanceLog selectByAthleteIdAndAttendanceTime(String athleteId, String startTime, String endTime);

    List<Map> getAthleticsByCoach (String coachId);
}