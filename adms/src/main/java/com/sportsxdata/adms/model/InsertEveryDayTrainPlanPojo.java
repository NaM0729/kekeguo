package com.sportsxdata.adms.model;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;


public class InsertEveryDayTrainPlanPojo {

    /**
     * 本条训练计划id
     */
    @NotNull
    private String id;
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

    /**
     * 教练id
     */
    private String coachId;

    public String getCoachId() {
        return coachId;
    }

    public void setCoachId(String coachId) {
        this.coachId = coachId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
