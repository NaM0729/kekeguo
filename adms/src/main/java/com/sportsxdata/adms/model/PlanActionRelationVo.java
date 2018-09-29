package com.sportsxdata.adms.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

public class PlanActionRelationVo{
    String pid;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date modifyTime;

    private String actid;

    private String actname;

    private String admsTrainingPlaneId;

    private String groupNum;

    private String time;

    private String strength;

    private String interval;

    private String duration;

    private String maxSpeed;

    private String avgSpeed;

    private String maxPower;

    private String avgPower;

    private String assess;

    private String timeReal;

    private String strengthReal;

    private String intervalReal;

    private String durationReal;

    private String themeId;

    private String athleteId;

    private String remark;

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
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

    public String getActid() {
        return actid;
    }

    public void setActid(String actid) {
        this.actid = actid;
    }

    public String getActname() {
        return actname;
    }

    public void setActname(String actname) {
        this.actname = actname;
    }

    public String getAdmsTrainingPlaneId() {
        return admsTrainingPlaneId;
    }

    public void setAdmsTrainingPlaneId(String admsTrainingPlaneId) {
        this.admsTrainingPlaneId = admsTrainingPlaneId;
    }

    public String getGroupNum() {
        return groupNum;
    }

    public void setGroupNum(String groupNum) {
        this.groupNum = groupNum;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getStrength() {
        return strength;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }

    public String getInterval() {
        return interval;
    }

    public void setInterval(String interval) {
        this.interval = interval;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(String maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public String getAvgSpeed() {
        return avgSpeed;
    }

    public void setAvgSpeed(String avgSpeed) {
        this.avgSpeed = avgSpeed;
    }

    public String getMaxPower() {
        return maxPower;
    }

    public void setMaxPower(String maxPower) {
        this.maxPower = maxPower;
    }

    public String getAvgPower() {
        return avgPower;
    }

    public void setAvgPower(String avgPower) {
        this.avgPower = avgPower;
    }

    public String getAssess() {
        return assess;
    }

    public void setAssess(String assess) {
        this.assess = assess;
    }

    public String getTimeReal() {
        return timeReal;
    }

    public void setTimeReal(String timeReal) {
        this.timeReal = timeReal;
    }

    public String getStrengthReal() {
        return strengthReal;
    }

    public void setStrengthReal(String strengthReal) {
        this.strengthReal = strengthReal;
    }

    public String getIntervalReal() {
        return intervalReal;
    }

    public void setIntervalReal(String intervalReal) {
        this.intervalReal = intervalReal;
    }

    public String getDurationReal() {
        return durationReal;
    }

    public void setDurationReal(String durationReal) {
        this.durationReal = durationReal;
    }

    public String getThemeId() {
        return themeId;
    }

    public void setThemeId(String themeId) {
        this.themeId = themeId;
    }

    public String getAthleteId() {
        return athleteId;
    }

    public void setAthleteId(String athleteId) {
        this.athleteId = athleteId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
