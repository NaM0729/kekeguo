package com.sportsxdata.adms.model;

import java.util.List;

public class TraningPlanListsBycocahEntry {
    public String coachId;
    public String time;
    public String teamName;
    public String stage;
    public Integer pageNum;
    public Integer pageRowNum;
    public String currentTime;
    public Integer startSize;
    public List<String> id;

    public String getCoachId() {
        return coachId;
    }

    public void setCoachId(String coachId) {
        this.coachId = coachId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageRowNum() {
        return pageRowNum;
    }

    public void setPageRowNum(Integer pageRowNum) {
        this.pageRowNum = pageRowNum;
    }

    public String getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }

    public Integer getStartSize() {
        return startSize;
    }

    public void setStartSize(Integer startSize) {
        this.startSize = startSize;
    }

    public List<String> getId() {
        return id;
    }

    public void setId(List<String> id) {
        this.id = id;
    }
}
