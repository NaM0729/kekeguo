package com.sportsxdata.adms.service;

import com.sportsxdata.adms.model.AttendanceLog;
import com.sportsxdata.adms.model.DataResult;


public interface AttendanceLogService {

    DataResult saveAttendanceLogData(AttendanceLog attendanceLog);

    DataResult getAttendanceLogByCoachId(String coachId);

    DataResult getAthleticsByCoach(String coachId);
}
