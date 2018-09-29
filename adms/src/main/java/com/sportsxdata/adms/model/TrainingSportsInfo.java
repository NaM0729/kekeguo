package com.sportsxdata.adms.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class TrainingSportsInfo {
    private String id;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date modifyTime;

    private String admsTrainingPlaneId;

    private String admsAthleteId;

    private String heartRate;

    private String distance;

    private String acceleratedSpeed;

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

    public String getAdmsTrainingPlaneId() {
        return admsTrainingPlaneId;
    }

    public void setAdmsTrainingPlaneId(String admsTrainingPlaneId) {
        this.admsTrainingPlaneId = admsTrainingPlaneId == null ? null : admsTrainingPlaneId.trim();
    }

    public String getAdmsAthleteId() {
        return admsAthleteId;
    }

    public void setAdmsAthleteId(String admsAthleteId) {
        this.admsAthleteId = admsAthleteId == null ? null : admsAthleteId.trim();
    }

    public String getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(String heartRate) {
        this.heartRate = heartRate == null ? null : heartRate.trim();
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance == null ? null : distance.trim();
    }

    public String getAcceleratedSpeed() {
        return acceleratedSpeed;
    }

    public void setAcceleratedSpeed(String acceleratedSpeed) {
        this.acceleratedSpeed = acceleratedSpeed == null ? null : acceleratedSpeed.trim();
    }
}