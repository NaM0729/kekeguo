package com.sportsxdata.adms.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class PlanActionRelation implements Cloneable {
    private String id;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date modifyTime;

    private String admsActionId;

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

    private String actionName;

    private String thenmeName;

    private String order;

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getThenmeName() {
        return thenmeName;
    }

    public void setThenmeName(String thenmeName) {
        this.thenmeName = thenmeName;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

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

    public String getAdmsActionId() {
        return admsActionId;
    }

    public void setAdmsActionId(String admsActionId) {
        this.admsActionId = admsActionId == null ? null : admsActionId.trim();
    }

    public String getAdmsTrainingPlaneId() {
        return admsTrainingPlaneId;
    }

    public void setAdmsTrainingPlaneId(String admsTrainingPlaneId) {
        this.admsTrainingPlaneId = admsTrainingPlaneId == null ? null : admsTrainingPlaneId.trim();
    }

    public String getGroupNum() {
        return groupNum;
    }

    public void setGroupNum(String groupNum) {
        this.groupNum = groupNum == null ? null : groupNum.trim();
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }

    public String getStrength() {
        return strength;
    }

    public void setStrength(String strength) {
        this.strength = strength == null ? null : strength.trim();
    }

    public String getInterval() {
        return interval;
    }

    public void setInterval(String interval) {
        this.interval = interval == null ? null : interval.trim();
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration == null ? null : duration.trim();
    }

    public String getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(String maxSpeed) {
        this.maxSpeed = maxSpeed == null ? null : maxSpeed.trim();
    }

    public String getAvgSpeed() {
        return avgSpeed;
    }

    public void setAvgSpeed(String avgSpeed) {
        this.avgSpeed = avgSpeed == null ? null : avgSpeed.trim();
    }

    public String getMaxPower() {
        return maxPower;
    }

    public void setMaxPower(String maxPower) {
        this.maxPower = maxPower == null ? null : maxPower.trim();
    }

    public String getAvgPower() {
        return avgPower;
    }

    public void setAvgPower(String avgPower) {
        this.avgPower = avgPower == null ? null : avgPower.trim();
    }

    public String getAssess() {
        return assess;
    }

    public void setAssess(String assess) {
        this.assess = assess == null ? null : assess.trim();
    }

    public String getTimeReal() {
        return timeReal;
    }

    public void setTimeReal(String timeReal) {
        this.timeReal = timeReal == null ? null : timeReal.trim();
    }

    public String getStrengthReal() {
        return strengthReal;
    }

    public void setStrengthReal(String strengthReal) {
        this.strengthReal = strengthReal == null ? null : strengthReal.trim();
    }

    public String getIntervalReal() {
        return intervalReal;
    }

    public void setIntervalReal(String intervalReal) {
        this.intervalReal = intervalReal == null ? null : intervalReal.trim();
    }

    public String getDurationReal() {
        return durationReal;
    }

    public void setDurationReal(String durationReal) {
        this.durationReal = durationReal == null ? null : durationReal.trim();
    }

    public String getThemeId() {
        return themeId;
    }

    public void setThemeId(String themeId) {
        this.themeId = themeId == null ? null : themeId.trim();
    }

    public String getAthleteId() {
        return athleteId;
    }

    public void setAthleteId(String athleteId) {
        this.athleteId = athleteId == null ? null : athleteId.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    @Override
    public PlanActionRelation clone() throws CloneNotSupportedException {
        PlanActionRelation clone = (PlanActionRelation) super.clone();
        //clone.createTime = (Date) createTime.clone();
        return clone;
    }
}