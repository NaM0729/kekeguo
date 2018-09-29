package com.sportsxdata.adms.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class AttendanceLog {
    private String id;

    private String reason;

    private String admsAthleteId;

    private String admsAttendanceId;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date startTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date endTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    public String getAdmsAthleteId() {
        return admsAthleteId;
    }

    public void setAdmsAthleteId(String admsAthleteId) {
        this.admsAthleteId = admsAthleteId == null ? null : admsAthleteId.trim();
    }

    public String getAdmsAttendanceId() {
        return admsAttendanceId;
    }

    public void setAdmsAttendanceId(String admsAttendanceId) {
        this.admsAttendanceId = admsAttendanceId == null ? null : admsAttendanceId.trim();
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}