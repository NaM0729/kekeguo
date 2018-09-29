package com.sportsxdata.adms.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class TrainingPlan {
    private String id;

    private Integer traningTheme;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date traningStartTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date traningEndTime;

    private String traningSite;

    private String traningRemark;

    private String traningTarget;

    private String traningTeamName;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date modifyTime;

    private String coachId;

    private String traningStage;

    private String mainPlanId;

    private String belongCoach;

    public String getBelongCoach() {
        return belongCoach;
    }

    public void setBelongCoach(String belongCoach) {
        this.belongCoach = belongCoach;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Integer getTraningTheme() {
        return traningTheme;
    }

    public void setTraningTheme(Integer traningTheme) {
        this.traningTheme = traningTheme;
    }

    public Date getTraningStartTime() {
        return traningStartTime;
    }

    public void setTraningStartTime(Date traningStartTime) {
        this.traningStartTime = traningStartTime;
    }

    public Date getTraningEndTime() {
        return traningEndTime;
    }

    public void setTraningEndTime(Date traningEndTime) {
        this.traningEndTime = traningEndTime;
    }

    public String getTraningSite() {
        return traningSite;
    }

    public void setTraningSite(String traningSite) {
        this.traningSite = traningSite == null ? null : traningSite.trim();
    }

    public String getTraningRemark() {
        return traningRemark;
    }

    public void setTraningRemark(String traningRemark) {
        this.traningRemark = traningRemark == null ? null : traningRemark.trim();
    }

    public String getTraningTarget() {
        return traningTarget;
    }

    public void setTraningTarget(String traningTarget) {
        this.traningTarget = traningTarget == null ? null : traningTarget.trim();
    }

    public String getTraningTeamName() {
        return traningTeamName;
    }

    public void setTraningTeamName(String traningTeamName) {
        this.traningTeamName = traningTeamName == null ? null : traningTeamName.trim();
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

    public String getCoachId() {
        return coachId;
    }

    public void setCoachId(String coachId) {
        this.coachId = coachId == null ? null : coachId.trim();
    }

    public String getTraningStage() {
        return traningStage;
    }

    public void setTraningStage(String traningStage) {
        this.traningStage = traningStage == null ? null : traningStage.trim();
    }

    public String getMainPlanId() {
        return mainPlanId;
    }

    public void setMainPlanId(String mainPlanId) {
        this.mainPlanId = mainPlanId == null ? null : mainPlanId.trim();
    }
}