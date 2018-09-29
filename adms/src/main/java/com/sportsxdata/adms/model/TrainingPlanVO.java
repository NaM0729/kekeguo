package com.sportsxdata.adms.model;

import lombok.Data;

import java.util.List;
@Data
public class TrainingPlanVO {

    private String themeId;

    private String actionId;

    private String athleteId;

    private String assess;

    private String planId;

    private List<PlanActionRelation> planActionRelations;

    public String getThemeId() {
        return themeId;
    }

    public void setThemeId(String themeId) {
        this.themeId = themeId;
    }

    public String getActionId() {
        return actionId;
    }

    public void setActionId(String actionId) {
        this.actionId = actionId;
    }

    public String getAthleteId() {
        return athleteId;
    }

    public void setAthleteId(String athleteId) {
        this.athleteId = athleteId;
    }

    public String getAssess() {
        return assess;
    }

    public void setAssess(String assess) {
        this.assess = assess;
    }

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    public List<PlanActionRelation> getPlanActionRelations() {
        return planActionRelations;
    }

    public void setPlanActionRelations(List<PlanActionRelation> planActionRelations) {
        this.planActionRelations = planActionRelations;
    }
}
