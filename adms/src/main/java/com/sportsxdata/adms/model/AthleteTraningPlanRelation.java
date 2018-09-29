package com.sportsxdata.adms.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class AthleteTraningPlanRelation {
    private String id;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date modifyTime;

    private String admsAthleteId;

    private String admsTrainingPlanId;

    private String resetHr;

    private String maxHr;

    private String avgHr;

    private String avgSpeed;

    private String distance;

    private String sportsDuration;

    private String sportsLoad;

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

    public String getAdmsAthleteId() {
        return admsAthleteId;
    }

    public void setAdmsAthleteId(String admsAthleteId) {
        this.admsAthleteId = admsAthleteId == null ? null : admsAthleteId.trim();
    }

    public String getAdmsTrainingPlanId() {
        return admsTrainingPlanId;
    }

    public void setAdmsTrainingPlanId(String admsTrainingPlanId) {
        this.admsTrainingPlanId = admsTrainingPlanId == null ? null : admsTrainingPlanId.trim();
    }

    public String getResetHr() {
        return resetHr;
    }

    public void setResetHr(String resetHr) {
        this.resetHr = resetHr == null ? null : resetHr.trim();
    }

    public String getMaxHr() {
        return maxHr;
    }

    public void setMaxHr(String maxHr) {
        this.maxHr = maxHr == null ? null : maxHr.trim();
    }

    public String getAvgHr() {
        return avgHr;
    }

    public void setAvgHr(String avgHr) {
        this.avgHr = avgHr == null ? null : avgHr.trim();
    }

    public String getAvgSpeed() {
        return avgSpeed;
    }

    public void setAvgSpeed(String avgSpeed) {
        this.avgSpeed = avgSpeed == null ? null : avgSpeed.trim();
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance == null ? null : distance.trim();
    }

    public String getSportsDuration() {
        return sportsDuration;
    }

    public void setSportsDuration(String sportsDuration) {
        this.sportsDuration = sportsDuration == null ? null : sportsDuration.trim();
    }

    public String getSportsLoad() {
        return sportsLoad;
    }

    public void setSportsLoad(String sportsLoad) {
        this.sportsLoad = sportsLoad == null ? null : sportsLoad.trim();
    }
}