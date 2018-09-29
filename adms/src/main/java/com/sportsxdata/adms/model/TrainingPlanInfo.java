package com.sportsxdata.adms.model;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TrainingPlanInfo {

    private String planId;
    private String remark;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date startTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date endTime;
    private String site;
    private String stage;
    private String teamName;
    private String target;
    private boolean editStatus = false;
    private String belongcoach;
    private List<SectionVoByPdf> sectionVoList;

    /**
     * 训练的运动员
     */
    private List<Athlete> athleteIdList;
    /**
     * 动作准备阶段的动作
     */
    private List<SectionVoByPdf> readyAction = new ArrayList<>();
    /**
     * 主要训练阶段的动作
     */
    private List<SectionVoByPdf> adminAction = new ArrayList<>();
    /**
     * 整理放松阶段的动作
     */
    private List<SectionVoByPdf> relaxAction = new ArrayList<>();

    public List<Athlete> getAthleteIdList() {
        return athleteIdList;
    }

    public void setAthleteIdList(List<Athlete> athleteIdList) {
        this.athleteIdList = athleteIdList;
    }

    public List<SectionVoByPdf> getReadyAction() {
        return readyAction;
    }

    public void setReadyAction(List<SectionVoByPdf> readyAction) {
        this.readyAction = readyAction;
    }

    public List<SectionVoByPdf> getAdminAction() {
        return adminAction;
    }

    public void setAdminAction(List<SectionVoByPdf> adminAction) {
        this.adminAction = adminAction;
    }

    public List<SectionVoByPdf> getRelaxAction() {
        return relaxAction;
    }

    public void setRelaxAction(List<SectionVoByPdf> relaxAction) {
        this.relaxAction = relaxAction;
    }

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public List<SectionVoByPdf> getSectionVoList() {
        return sectionVoList;
    }

    public void setSectionVoList(List<SectionVoByPdf> sectionVoList) {
        this.sectionVoList = sectionVoList;
    }

    public boolean isEditStatus() {
        return editStatus;
    }

    public void setEditStatus(boolean editStatus) {
        this.editStatus = editStatus;
    }

    public String getBelongcoach() {
        return belongcoach;
    }

    public void setBelongcoach(String belongcoach) {
        this.belongcoach = belongcoach;
    }
}
