package com.sportsxdata.adms.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class SelfProfile {
    private String id;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date modifyTime;

    private String admsAthleteId;

    private String sleepQuality;

    private String recoverStatus;

    private String muscleAche;

    private String trainStatus;

    private String tiredFeel;

    private String gaietyFeel;

    private String trainPower;

    private String diseaseFeel;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date sleepStartTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date sleepEndTime;

    private String sleepDuration;

    private String restingHeartRate;

    private String bodyStatus;

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

    public String getSleepQuality() {
        return sleepQuality;
    }

    public void setSleepQuality(String sleepQuality) {
        this.sleepQuality = sleepQuality == null ? null : sleepQuality.trim();
    }

    public String getRecoverStatus() {
        return recoverStatus;
    }

    public void setRecoverStatus(String recoverStatus) {
        this.recoverStatus = recoverStatus == null ? null : recoverStatus.trim();
    }

    public String getMuscleAche() {
        return muscleAche;
    }

    public void setMuscleAche(String muscleAche) {
        this.muscleAche = muscleAche == null ? null : muscleAche.trim();
    }

    public String getTrainStatus() {
        return trainStatus;
    }

    public void setTrainStatus(String trainStatus) {
        this.trainStatus = trainStatus == null ? null : trainStatus.trim();
    }

    public String getTiredFeel() {
        return tiredFeel;
    }

    public void setTiredFeel(String tiredFeel) {
        this.tiredFeel = tiredFeel == null ? null : tiredFeel.trim();
    }

    public String getGaietyFeel() {
        return gaietyFeel;
    }

    public void setGaietyFeel(String gaietyFeel) {
        this.gaietyFeel = gaietyFeel == null ? null : gaietyFeel.trim();
    }

    public String getTrainPower() {
        return trainPower;
    }

    public void setTrainPower(String trainPower) {
        this.trainPower = trainPower == null ? null : trainPower.trim();
    }

    public String getDiseaseFeel() {
        return diseaseFeel;
    }

    public void setDiseaseFeel(String diseaseFeel) {
        this.diseaseFeel = diseaseFeel == null ? null : diseaseFeel.trim();
    }

    public Date getSleepStartTime() {
        return sleepStartTime;
    }

    public void setSleepStartTime(Date sleepStartTime) {
        this.sleepStartTime = sleepStartTime;
    }

    public Date getSleepEndTime() {
        return sleepEndTime;
    }

    public void setSleepEndTime(Date sleepEndTime) {
        this.sleepEndTime = sleepEndTime;
    }

    public String getSleepDuration() {
        return sleepDuration;
    }

    public void setSleepDuration(String sleepDuration) {
        this.sleepDuration = sleepDuration == null ? null : sleepDuration.trim();
    }

    public String getRestingHeartRate() {
        return restingHeartRate;
    }

    public void setRestingHeartRate(String restingHeartRate) {
        this.restingHeartRate = restingHeartRate == null ? null : restingHeartRate.trim();
    }

    public String getBodyStatus() {
        return bodyStatus;
    }

    public void setBodyStatus(String bodyStatus) {
        this.bodyStatus = bodyStatus == null ? null : bodyStatus.trim();
    }
}