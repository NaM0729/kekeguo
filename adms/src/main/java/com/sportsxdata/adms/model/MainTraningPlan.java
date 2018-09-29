package com.sportsxdata.adms.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class MainTraningPlan {
    private String id;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date modifyTime;

    private String admsCoachId;

    private String startDate;

    private String endDate;

    private String startTime;

    private String endTime;

    private String athleteNum;

    private String teamName;

    private String traningStage;

    private String theme1ProjectNum;

    private String theme2ProjectNum;

    private String theme3ProjectNum;

    private String planStatus;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getAdmsCoachId() {
        return admsCoachId;
    }

    public void setAdmsCoachId(String admsCoachId) {
        this.admsCoachId = admsCoachId == null ? null : admsCoachId.trim();
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate == null ? null : startDate.trim();
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate == null ? null : endDate.trim();
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime == null ? null : startTime.trim();
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime == null ? null : endTime.trim();
    }

    public String getAthleteNum() {
        return athleteNum;
    }

    public void setAthleteNum(String athleteNum) {
        this.athleteNum = athleteNum == null ? null : athleteNum.trim();
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName == null ? null : teamName.trim();
    }

    public String getTraningStage() {
        return traningStage;
    }

    public void setTraningStage(String traningStage) {
        this.traningStage = traningStage == null ? null : traningStage.trim();
    }

    public String getTheme1ProjectNum() {
        return theme1ProjectNum;
    }

    public void setTheme1ProjectNum(String theme1ProjectNum) {
        this.theme1ProjectNum = theme1ProjectNum == null ? null : theme1ProjectNum.trim();
    }

    public String getTheme2ProjectNum() {
        return theme2ProjectNum;
    }

    public void setTheme2ProjectNum(String theme2ProjectNum) {
        this.theme2ProjectNum = theme2ProjectNum == null ? null : theme2ProjectNum.trim();
    }

    public String getTheme3ProjectNum() {
        return theme3ProjectNum;
    }

    public void setTheme3ProjectNum(String theme3ProjectNum) {
        this.theme3ProjectNum = theme3ProjectNum == null ? null : theme3ProjectNum.trim();
    }

    public String getPlanStatus() {
        return planStatus;
    }

    public void setPlanStatus(String planStatus) {
        this.planStatus = planStatus == null ? null : planStatus.trim();
    }
}