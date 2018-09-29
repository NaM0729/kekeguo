package com.sportsxdata.adms.model;

import lombok.NonNull;

import javax.validation.constraints.NotNull;
import java.util.List;

public class InsertTrainPlanPojo {
    /**
     * 训练队名
     */
    @NotNull
    private String traningTeamName;
    /**
     * 训练阶段
     */
    @NotNull
    private String traningStage;
    /**
     * 训练目标
     */
    @NotNull
    private String traningTarget;
    /**
     * 训练地点
     */
    @NotNull
    private String traningSite;
    /**
     * 训练开始日期
     */
    @NotNull
    private String startDate;
    /**
     * 训练结束日期
     */
    @NotNull
    private String endDate;
    /**
     * 训练开始时间
     */
    @NotNull
    private String startTime;
    /**
     * 训练结束时间
     */
    @NonNull
    private String endTime;
    /**
     * 训练备注
     */
    private String traningRemark;
    /**
     * 训练制定教练id
     */
    @NotNull
    private String coachId;
    /**
     * 所属教练姓名
     */
    private String coachName;
    /**
     * 训练的运动员id
     */
    @NotNull
    private List<String> athleteIdList;
    /**
     * 动作准备阶段的动作
     */
    private List<PlanActionRelation> readyAction;
    /**
     * 主要训练阶段的动作
     */
    private List<PlanActionRelation> adminAction;
    /**
     * 整理放松阶段的动作
     */
    private List<PlanActionRelation> relaxAction;

    public String getCoachName() {
        return coachName;
    }

    public void setCoachName(String coachName) {
        this.coachName = coachName;
    }

    public String getTraningTeamName() {
        return traningTeamName;
    }

    public void setTraningTeamName(String traningTeamName) {
        this.traningTeamName = traningTeamName;
    }

    public String getTraningStage() {
        return traningStage;
    }

    public void setTraningStage(String traningStage) {
        this.traningStage = traningStage;
    }

    public String getTraningTarget() {
        return traningTarget;
    }

    public void setTraningTarget(String traningTarget) {
        this.traningTarget = traningTarget;
    }

    public String getTraningSite() {
        return traningSite;
    }

    public void setTraningSite(String traningSite) {
        this.traningSite = traningSite;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getTraningRemark() {
        return traningRemark;
    }

    public void setTraningRemark(String traningRemark) {
        this.traningRemark = traningRemark;
    }

    public String getCoachId() {
        return coachId;
    }

    public void setCoachId(String coachId) {
        this.coachId = coachId;
    }

    public List<String> getAthleteIdList() {
        return athleteIdList;
    }

    public void setAthleteIdList(List<String> athleteIdList) {
        this.athleteIdList = athleteIdList;
    }

    public List<PlanActionRelation> getReadyAction() {
        return readyAction;
    }

    public void setReadyAction(List<PlanActionRelation> readyAction) {
        this.readyAction = readyAction;
    }

    public List<PlanActionRelation> getAdminAction() {
        return adminAction;
    }

    public void setAdminAction(List<PlanActionRelation> adminAction) {
        this.adminAction = adminAction;
    }

    public List<PlanActionRelation> getRelaxAction() {
        return relaxAction;
    }

    public void setRelaxAction(List<PlanActionRelation> relaxAction) {
        this.relaxAction = relaxAction;
    }
}
